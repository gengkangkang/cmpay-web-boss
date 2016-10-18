package org.pay.service.jytpay.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.pay.service.jytpay.model.CpJYTRespDef;
import org.pay.service.jytpay.model.SignCardTypeDef;
import org.pay.service.jytpay.service.JinYuntongPayService;
import org.pay.service.jytpay.utils.AppException;
import org.pay.service.jytpay.utils.CryptoUtils;
import org.pay.service.jytpay.utils.DESHelper;
import org.pay.service.jytpay.utils.DateTimeUtils;
import org.pay.service.jytpay.utils.HttpClient431Util;
import org.pay.service.jytpay.utils.RSAHelper;
import org.pay.service.jytpay.utils.StringUtil;
import org.pay.service.jytpay.utils.XmlMsgConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;


@Service
public class JinYuntongPayServiceImpl implements JinYuntongPayService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private JYTPayParamFactory paramFactory;
	
	private RSAHelper rsaHelper;
	
	@PostConstruct
	public void initRsaHelper() {
		rsaHelper = new RSAHelper();
		try {
				if(CLIENT_PRIVATE_KEY.equals("")&&paramFactory!=null){
				   CLIENT_PRIVATE_KEY=initKey(paramFactory.getJytPath() ,paramFactory.getJytPrivateKEY());
				   SERVER_PUBLIC_KEY=initKey(paramFactory.getJytPath()  ,paramFactory.getJytPublicKEY());
	
					rsaHelper.initKey(CLIENT_PRIVATE_KEY, SERVER_PUBLIC_KEY, 2048);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static String TRAN_CODE_1001 = "TC1001";
	public static String TRAN_CODE_2001 = "TC2001";
	public static String TRAN_CODE_1002 = "TC1002";
	public static String TRAN_CODE_2002 = "TC2002";
	public static String TRAN_CODE_4003 = "TR4003";

	//测试环境
	//public static String APP_SERVER_URL = "http://test1.jytpay.com:8080/JytCPService/tranCenter/encXmlReq.do";
	
	//测试环境测试商户
	//public static String MERCHANT_ID = "290007420008";	//替换为自己的商户号
	
	public static String RESP_MSG_PARAM_SEPARATOR = "&";
	
	/**返回报文merchant_id字段前缀*/
	public static String RESP_MSG_PARAM_PREFIX_MERCHANT_ID = "merchant_id=";
	
	/**返回报文xml_enc字段前缀*/
	public static String RESP_MSG_PARAM_PREFIX_XML_ENC = "xml_enc=";
	/**返回报文xml_enc字段前缀*/
	public static String RESP_MSG_PARAM_PREFIX_KEY_ENC = "key_enc=";
	
	/**返回报文sign字段前缀*/
	public static String RESP_MSG_PARAM_PREFIX_SIGN = "sign=";
	
	//替换为自己的客户端私钥
	//测试环境
	public static String CLIENT_PRIVATE_KEY="";
	
	//替换匹配的服务端公钥
	//测试环境
	public static String SERVER_PUBLIC_KEY= "";

	public String tran_flowid = "";
	public String tran_date = "";
	public String tran_time = "";
	
	public String payChanndelCode = null;
	public String MerchantId=null;

	private BufferedReader br;
	
	
	public JYTPayParamFactory getParamFactory() {
		return paramFactory;
	}

	public void setParamFactory(JYTPayParamFactory paramFactory) {
		this.paramFactory = paramFactory;
	}

	/**
	 *  - 单笔代收交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef setCollection(String bank_name,String account_no,String account_name,String account_type,String brach_bank_province,String brach_bank_city,
			String brach_bank_name,String tran_amt,String currency,String bsn_code,String cert_type,String cert_no,String mobile,String remark,String trans_id,String cust_id,String order_id,String payChanndelCode) {
		CpJYTRespDef cpJYTRespDef = new CpJYTRespDef();
		tran_flowid = getTranFlow(payChanndelCode);
    	tran_date =DateTimeUtils.getNowDateStr(DateTimeUtils.DATE_FORMAT_YYYYMMDD);
    	tran_time = DateTimeUtils.getNowDateStr(DateTimeUtils.DATETIME_FORMAT_HHMMSS);
    	cpJYTRespDef.setTran_flowid(tran_flowid);
    	cpJYTRespDef.setTran_date(tran_date);
    	cpJYTRespDef.setTran_time(tran_time);
    	cpJYTRespDef.setTran_code(TRAN_CODE_1001);

    	account_type = paramFactory.getJytAccountType();
    	currency = paramFactory.getJytCurrencyType();
    	bsn_code = paramFactory.getJytCollectionCode();
    	cert_type = "01";
		//把接口参数数据保存到数据库中
//    	JytCutRecord zmCpJinyuntongPay = new JytCutRecord();
//    	zmCpJinyuntongPay.setTranFlowid(tran_flowid);     	    
//    	zmCpJinyuntongPay.setTranDate(tran_date);     
//    	zmCpJinyuntongPay.setTranTime(tran_time);     
//    	zmCpJinyuntongPay.setTransId(trans_id);  
//    	zmCpJinyuntongPay.setOrderNo(order_id);
//    	zmCpJinyuntongPay.setCustId(cust_id);       
//    	zmCpJinyuntongPay.setBankName(bank_name);     
//    	zmCpJinyuntongPay.setAccountNo(account_no);    
//    	zmCpJinyuntongPay.setAccountName(account_name);  
//    	zmCpJinyuntongPay.setAccountType(account_type);  
//    	zmCpJinyuntongPay.setTranAmt(new BigDecimal(tran_amt));      
//    	zmCpJinyuntongPay.setCurrency(currency);      
//    	zmCpJinyuntongPay.setBsnCode(bsn_code);      
//    	zmCpJinyuntongPay.setCertType(cert_type);     
//    	zmCpJinyuntongPay.setCertNo(cert_no);         
//    	zmCpJinyuntongPay.setCreateDate(new Date());
//    	zmCpJinyuntongPay.setTranCode(TRAN_CODE_1001);
//    	zmCpJinyuntongPay.setMobile(mobile);
//
//		
//    	zmCpJinyuntongPay.setMerId(MerchantId);
//    	
//    	zmCpJinyuntongPay.setProcDate(systemStatusFacility.getSystemStatus().businessDate);

		try {
			String xml= getXmlTrading(bank_name,account_no,account_name,account_type,brach_bank_province,brach_bank_city,brach_bank_name,tran_amt,currency,
					bsn_code,cert_type,cert_no,mobile,remark,TRAN_CODE_1001);
			// 把XML对象转换成HEX
			String mac=signMsg(xml);
			// 发送报文
	        String respXml = sendMsg(xml, mac,paramFactory.getJytAppSeverUrl() );
	        // 获取报文头的响应代码
	        String respCode = getMsgRespCode(respXml);
	        //zmCpJinyuntongPay.setTranCode(respCode); 
	        // 获取报文交易状态信息
	        String respDesc = getMsgRespDesc(respXml);
	        // 获取报文交易状态码
	        String tranState = getMsgState(respXml);
	        cpJYTRespDef.setResp_code(respCode);
	        cpJYTRespDef.setTran_state(tranState);
	        
//	        zmCpJinyuntongPay.setRespCode(respCode);
	        String message = "金运通响应码:["+respCode+"],响应信息:"+respDesc;
//	        zmCpJinyuntongPay.setDescription(message);
	        cpJYTRespDef.setDescription(message);
	        
	        cpJYTRespDef = StringToDef(cpJYTRespDef,bank_name,account_no,account_name,account_type,brach_bank_province,brach_bank_city,brach_bank_name,tran_amt,currency,
					bsn_code,cert_type,cert_no,mobile,remark);
	        // 判断如果响应代码为S0000000时 或 E0000000时为正确结果
//	        if(XmlMsgConstant.MSG_RES_CODE_SUCCESS.equals(respCode)||XmlMsgConstant.MSG_RES_CODE_PROCESSING.equals(respCode)){
//	        	// 判断报文交易状态为01时 成功
//				if(tranState.equals("01")){
//					zmCpJinyuntongPay.setTranState("01");
//				// 判断报文交易状态为00或无返回时 受理中
//				}else if(tranState.equals("00") || tranState.equals("")){
//					zmCpJinyuntongPay.setTranState("00");
//				}else{
//					zmCpJinyuntongPay.setTranState("03");
//				}
//	        }else{
//	        	zmCpJinyuntongPay.setTranState("00");
//	        	logger.info("返回报文异常，网络通讯问题");
//	        }
		} catch (Exception e) {
			cpJYTRespDef.setTran_state("00");
//			zmCpJinyuntongPay.setTranState("00");
		}
//		em.persist(zmCpJinyuntongPay);
		return cpJYTRespDef;
	}
	
	/**
	 *  - 查询单笔代收交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef queryCollection(String ori_tran_flowid,String payChanndelCode) {
		CpJYTRespDef cpJYTRespDef = new CpJYTRespDef();
		String query_tran_flowid = getTranFlow(payChanndelCode);
    	tran_date =DateTimeUtils.getNowDateStr(DateTimeUtils.DATE_FORMAT_YYYYMMDD);
    	tran_time = DateTimeUtils.getNowDateStr(DateTimeUtils.DATETIME_FORMAT_HHMMSS);
    	cpJYTRespDef.setTran_flowid(query_tran_flowid);
    	cpJYTRespDef.setTran_date(tran_date);
    	cpJYTRespDef.setTran_time(tran_time);
    	cpJYTRespDef.setTran_code(TRAN_CODE_2001);
		String xml= getXmlQuery(ori_tran_flowid,TRAN_CODE_2001,query_tran_flowid);    
		try {
			// 把XML对象转换成HEX
			String mac=signMsg(xml); 
			// 发送报文
			String respXml = sendMsg(xml, mac,paramFactory.getJytAppSeverUrl());	
			logger.info("金运通响应xml:{}",respXml);
	        // 获取报文头的响应代码
	        String respCode = getMsgRespCode(respXml);
	        logger.info("respCode:{}",respCode);
	        // 获取报文交易状态码
	        String tranState = getMsgState(respXml);
	        // 获取报文交易状态码
	        String respDesc = getMsgRespDesc(respXml);
		
	        String tran_resp_code= getMsgTranRespCode(respXml);
	        
	        logger.info("tran_resp_code:{}",tran_resp_code);
	        
	        cpJYTRespDef.setTran_state(tranState);
			cpJYTRespDef.setTran_flowid(ori_tran_flowid);
	        cpJYTRespDef.setResp_code(respCode);
	        cpJYTRespDef.setDescription(respDesc);
	        cpJYTRespDef.setTran_resp_code(tran_resp_code);
		} catch (Exception e) {
			logger.error("报文错误：{}",e);
			e.printStackTrace();
		}
		return cpJYTRespDef;
	}
	
	/**
	 *  - 单笔代付交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef setPayment(String bank_name,String account_no,String account_name,String account_type,String brach_bank_province,String brach_bank_city,
			String brach_bank_name,String tran_amt,String currency,String bsn_code,String cert_type,String cert_no,String mobile,String remark,String trans_id,String cust_id,String order_id, String sinpayChanndelCode) {
		CpJYTRespDef cpJYTRespDef = new CpJYTRespDef();
		tran_flowid = getTranFlow(sinpayChanndelCode);
    	tran_date =DateTimeUtils.getNowDateStr(DateTimeUtils.DATE_FORMAT_YYYYMMDD);
    	tran_time = DateTimeUtils.getNowDateStr(DateTimeUtils.DATETIME_FORMAT_HHMMSS);
    	cpJYTRespDef.setTran_flowid(tran_flowid);
    	cpJYTRespDef.setTran_date(tran_date);
    	cpJYTRespDef.setTran_time(tran_time);
    	cpJYTRespDef.setTran_code(TRAN_CODE_1002);
    	
    	account_type = paramFactory.getJytAccountType();
    	currency = paramFactory.getJytCurrencyType();
    	bsn_code = paramFactory.getJytPaymentCode();

		//把接口参数数据保存到数据库中
//    	JytPayRecord zmCpJinyuntongPay = new JytPayRecord();
//    	zmCpJinyuntongPay.setTranFlowid(tran_flowid);     	    
//    	zmCpJinyuntongPay.setTranDate(tran_date);     
//    	zmCpJinyuntongPay.setTranTime(tran_time);     
//    	zmCpJinyuntongPay.setTransId(trans_id);
//    	zmCpJinyuntongPay.setOrderNo(order_id);
//    	zmCpJinyuntongPay.setCustId(cust_id);       
//    	zmCpJinyuntongPay.setBankName(bank_name);     
//    	zmCpJinyuntongPay.setAccountNo(account_no);    
//    	zmCpJinyuntongPay.setAccountName(account_name);  
//    	zmCpJinyuntongPay.setAccountType(account_type);  
//    	zmCpJinyuntongPay.setTranAmt(new BigDecimal(tran_amt));      
//    	zmCpJinyuntongPay.setCurrency(currency);      
//    	zmCpJinyuntongPay.setBsnCode(bsn_code);      
//    	zmCpJinyuntongPay.setCertType(cert_type);     
//    	zmCpJinyuntongPay.setCertNo(cert_no);         
//    	zmCpJinyuntongPay.setCreateDate(new Date());
//    	zmCpJinyuntongPay.setTranCode(TRAN_CODE_1002);
//    	zmCpJinyuntongPay.setMobile(mobile);
//	    zmCpJinyuntongPay.setMerId(paramFactory.getJytMerchantId());
//    	zmCpJinyuntongPay.setProcDate(systemStatusFacility.getSystemStatus().businessDate);

		try {
			String xml= getXmlTrading(bank_name,account_no,account_name,account_type,brach_bank_province,brach_bank_city,brach_bank_name,tran_amt,currency,
					bsn_code,cert_type,cert_no,mobile,remark,TRAN_CODE_1002);
			// 把XML对象转换成HEX
			String mac=signMsg(xml);
			// 发送报文
	        String respXml = sendMsg(xml, mac,paramFactory.getJytAppSeverUrl());
	        // 获取报文头的响应代码
	        String respCode = getMsgRespCode(respXml);
	        // zmCpJinyuntongPay.setTranCode(respCode); 
	        // 获取报文交易状态码
	        String respDesc = getMsgRespDesc(respXml);
	        // 获取报文交易状态码
	        String tranState = getMsgState(respXml);
	        cpJYTRespDef.setTran_state(tranState);
	        cpJYTRespDef.setResp_code(respCode);
	        
//	        zmCpJinyuntongPay.setRespCode(respCode);	        
	        String message = "金运通响应码:["+respCode+"],响应信息:"+respDesc;
//	        zmCpJinyuntongPay.setDescription(message);
	        cpJYTRespDef.setDescription(message);
	        
	        cpJYTRespDef = StringToDef(cpJYTRespDef,bank_name,account_no,account_name,account_type,brach_bank_province,brach_bank_city,brach_bank_name,tran_amt,currency,
					bsn_code,cert_type,cert_no,mobile,remark);
        
	        // 判断如果响应代码为S0000000时 为正确结果
	        if(XmlMsgConstant.MSG_RES_CODE_SUCCESS.equals(respCode)||XmlMsgConstant.MSG_RES_CODE_PROCESSING.equals(respCode)){
	        	// 判断报文交易状态为01时 成功
				if(tranState.equals("01")){
//					zmCpJinyuntongPay.setTranState("01");
				// 判断报文交易状态为00或无返回时 受理中
				}else if(tranState.equals("00") || tranState.equals("")){
//					zmCpJinyuntongPay.setTranState("00");
				}else{
//					zmCpJinyuntongPay.setTranState("03");
				}
	        }else{
//	        	zmCpJinyuntongPay.setTranState("00");
	        	logger.info("返回报文异常，网络通讯问题");
	        }
		} catch (Exception e) {
			cpJYTRespDef.setTran_state("00");
//			zmCpJinyuntongPay.setTranState("00");
		}
//		em.persist(zmCpJinyuntongPay);
		return cpJYTRespDef;
	}
	
	/**
	 *  - 查询单笔代付交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef queryPayment(String ori_tran_flowid,String sinpayChanndelCode) {
		CpJYTRespDef cpJYTRespDef = new CpJYTRespDef();
		String query_tran_flowid = getTranFlow(sinpayChanndelCode);
    	tran_date =DateTimeUtils.getNowDateStr(DateTimeUtils.DATE_FORMAT_YYYYMMDD);
    	tran_time = DateTimeUtils.getNowDateStr(DateTimeUtils.DATETIME_FORMAT_HHMMSS);
    	cpJYTRespDef.setTran_flowid(query_tran_flowid);
    	cpJYTRespDef.setTran_date(tran_date);
    	cpJYTRespDef.setTran_time(tran_time);
    	cpJYTRespDef.setTran_code(TRAN_CODE_2001);
		String xml= getXmlQuery(ori_tran_flowid,TRAN_CODE_2002,query_tran_flowid);    
		try {
			// 把XML对象转换成HEX
			String mac=signMsg(xml); 
			// 发送报文
			String respXml = sendMsg(xml, mac,paramFactory.getJytAppSeverUrl());	
	        // 获取报文头的响应代码
	        String respCode = getMsgRespCode(respXml);
	        // 获取报文交易状态码
	        String tranState = getMsgState(respXml);
	        // 获取报文交易状态码
	        String respDesc = getMsgRespDesc(respXml);
		
	        cpJYTRespDef.setTran_state(tranState);
			cpJYTRespDef.setTran_flowid(ori_tran_flowid);
	        cpJYTRespDef.setResp_code(respCode);
	        cpJYTRespDef.setDescription(respDesc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpJYTRespDef;
	}
	
	
	
	/**
	 * 金运通四要素后台认证
	 * 
	 * @param bank_card_no
	 * @param bank_code
	 * @param id_num
	 * @param id_name
	 * @param terminal_type 认证请求终端类型 商户使用验证接口的终端类型：01 APP，02 WAP，03 WEB，04 SIM卡，05 VI-POS，06 SD卡
	 * @param bank_card_type
	 * @param phone_no
	 * @return
	 * @throws Exception
	 */
	public CpJYTRespDef JYTAuth(String bank_card_no, String bank_code,
    	String id_num, String id_name, String terminal_type, String bank_card_type, String phone_no) {
		CpJYTRespDef cpJYTRespDef = new CpJYTRespDef();
		String query_tran_flowid = getTranFlow("");
    	tran_date =DateTimeUtils.getNowDateStr(DateTimeUtils.DATE_FORMAT_YYYYMMDD);
    	tran_time = DateTimeUtils.getNowDateStr(DateTimeUtils.DATETIME_FORMAT_HHMMSS);
    	cpJYTRespDef.setTran_flowid(query_tran_flowid);
    	cpJYTRespDef.setTran_date(tran_date);
    	cpJYTRespDef.setTran_time(tran_time);
    	cpJYTRespDef.setTran_code(TRAN_CODE_2001);	
    	terminal_type = paramFactory.getJytTerminalType();
    	try {
    		// 卡类型转换
			String dcType = "";
			if (SignCardTypeDef.DEBIT.toString().equals(bank_card_type)) {
				dcType = "D";
			} else if (SignCardTypeDef.CREDIT.toString().equals(bank_card_type)) {
				dcType = "C";
			}
			
			String xml= getXmlAccount(TRAN_CODE_4003,query_tran_flowid,bank_card_no, bank_code,
					id_num, id_name, terminal_type, dcType, phone_no);    
			
			// 把XML对象转换成HEX
			String mac=signMsg(xml); 
			// 发送报文
			String respXml = sendMsg(xml, mac,paramFactory.getJytAuthSeverUrl());
			
	        // 获取报文头的响应代码
	        String respCode = getMsgRespCode(respXml);
	        // 获取报文交易状态码
	        String IsBcnAndIdnConform = getIsBcnAndIdnConform(respXml);
	        // 获取报文交易状态码
	        String respDesc = getMsgRespDesc(respXml);
		
	        String bank_name = getBankName(respXml);
	        cpJYTRespDef.setResp_code(respCode);
	        cpJYTRespDef.setIsBcnAndIdnConform(IsBcnAndIdnConform);
	        cpJYTRespDef.setBank_name(bank_name);
	        cpJYTRespDef.setDescription(respDesc);
		      
    	} catch (Exception e) {
		
			e.printStackTrace();
		}	
		return cpJYTRespDef;
	}
	
	
	/**
	 * 获得TC1001 TC1002单笔代收，代付的上送报文字符串
	 * <p> Create Date: 2015-10-19 </p>
	 * @return
	 */
    public String getXmlTrading(String bank_name,String account_no,String account_name,String account_type,String brach_bank_province,String brach_bank_city,
			String brach_bank_name,String tran_amt,String currency,String bsn_code,String cert_type,String cert_no,String mobile,String remark,String tran_code){

    	StringBuffer xml = new StringBuffer();
		xml.append(getMsgHeadXml(tran_code,tran_flowid));
		xml.append("<body><mer_viral_acct></mer_viral_acct><agrt_no></agrt_no>");
		xml.append("<bank_name>").append(bank_name).append("</bank_name><account_no>").append(account_no).append("</account_no>");
		xml.append("<account_name>").append(account_name).append("</account_name>");
		xml.append("<account_type>").append(account_type).append("</account_type>");
		xml.append("<brach_bank_province>").append(brach_bank_province).append("</brach_bank_province>");
		xml.append("<brach_bank_city>").append(brach_bank_city).append("</brach_bank_city>");
		xml.append("<brach_bank_name>").append(brach_bank_name).append("</brach_bank_name>");
		xml.append("<tran_amt>").append(tran_amt).append("</tran_amt>");
		xml.append("<currency>").append(currency).append("</currency>");
		xml.append("<bsn_code>").append(bsn_code).append("</bsn_code>");
		xml.append("<cert_type>").append(cert_type).append("</cert_type>");
		xml.append("<cert_no>").append(cert_no).append("</cert_no>");
		xml.append("<mobile>").append(mobile).append("</mobile>");
		xml.append("<remark>").append(remark).append("</remark>");
		xml.append("<reserve></reserve>");
		xml.append("</body></message>");
		return xml.toString();
	}
    
    
    /**
	 * 获得TC2001 获得TC2002单笔代收，代付查询的上送报文字符串
	 * <p> Create Date: 2015-10-19 </p>
	 * @return
	 */
    public String getXmlQuery(String ori_tran_flowid,String tran_code,String query_tran_flowid){	
		StringBuffer xml = new StringBuffer();
		xml.append(getMsgHeadXml(tran_code,query_tran_flowid));
		xml.append("<body>");
		xml.append("<ori_tran_flowid>").append(ori_tran_flowid).append("</ori_tran_flowid>");
		xml.append("</body></message>");
		return xml.toString();
	}
    
    /**
	 * 获得四要素验证上送报文字符串
	 * <p> Create Date: 2015-10-19 </p>
	 * @return
	 */
    public String getXmlAccount(String tran_code,String query_tran_flowid,String bank_card_no, String bank_code,
    		String id_num, String id_name, String terminal_type, String bank_card_type, String phone_no){	
		StringBuffer xml = new StringBuffer();
		xml.append(getMsgHeadXml(tran_code,query_tran_flowid));
		xml.append("<body>");
		xml.append("<bank_card_no>").append(bank_card_no).append("</bank_card_no>");
		xml.append("<bank_code>").append(bank_code).append("</bank_code>");
		xml.append("<id_num>").append(id_num).append("</id_num>");
		xml.append("<id_name>").append(id_name).append("</id_name>");
		xml.append("<terminal_type>").append(terminal_type).append("</terminal_type>");
		xml.append("<bank_card_type>").append(bank_card_type).append("</bank_card_type>");
		xml.append("<phone_no>").append(phone_no).append("</phone_no>");
		xml.append("</body></message>");
		return xml.toString();
	}
	
	/**
	 * 获取交易流水号
	 * <p> Create Date: 2014-5-10 </p>
	 * @return
	 */
	public String getTranFlow(String payChanndelCode){
		if("JinYongTongCut1".equals(payChanndelCode)){
			MerchantId=paramFactory.getJytMerchantGoldId();
    	}else{
    		MerchantId=paramFactory.getJytMerchantId();
    	}    	
		return MerchantId+ DateTimeUtils.getNowDateStr(DateTimeUtils.DATETIME_FORMAT_YYYYMMDDHHMMSS)+RandomStringUtils.randomNumeric(6);
	}
	
	
	/**
	 * 获得报文头字符串
	 * <p> Create Date: 2014-5-10 </p>
	 * @param tranCode
	 * @return
	 */
	public String getMsgHeadXml(String tranCode,String tran_flowid){
		StringBuffer headXml = new StringBuffer();
		headXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><head><version>1.0.0</version>");
		headXml.append("<tran_type>01</tran_type>")
			   .append("<merchant_id>").append(MerchantId).append("</merchant_id>");
		headXml.append("<tran_date>").append(tran_date)
		       .append("</tran_date>");
		headXml.append("<tran_time>").append(tran_time)
		       .append("</tran_time><tran_flowid>").append(tran_flowid)
		       .append("</tran_flowid><tran_code>").append(tranCode).append("</tran_code>");
		headXml.append("</head>");
		
		return headXml.toString();
	}
	
	public String sendMsg(String xml,String sign,String appSeverUrl) throws Exception{
		logger.info("上送报文："+xml);
		logger.info("上送签名："+sign);
		
		byte[] des_key = DESHelper.generateDesKey() ;
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("merchant_id", MerchantId);
		paramMap.put("xml_enc", encryptXml(xml,des_key));
		paramMap.put("key_enc", encryptKey(des_key));
		paramMap.put("sign", sign);
	
		// 获取执行结果

		String res = HttpClient431Util.doPost(paramMap, appSeverUrl);
		
		if(res  == null){
			logger.error("服务器连接失败");
			
			throw new AppException("测试异常");
		}else{
			logger.info("连接服务器成功,返回结果"+res);
		}
		String []respMsg = res.split(paramFactory.getJytRespMsgParamSeparator());
		
		String merchantId = respMsg[0].substring(paramFactory.getJytRespMsgParamPrefixMerchantId().length()+1);
		String respXmlEnc = respMsg[1].substring(paramFactory.getJytRespMsgParamPrefixXmlEnc().length()+1);
		String respKeyEnc = respMsg[2].substring(paramFactory.getJytRespMsgParamPrefixKeyEnc().length()+1);
		String respSign = respMsg[3].substring(paramFactory.getJytRespMsgParamPrefixSign().length()+1);
		
		byte respKey[] = decryptKey(respKeyEnc) ;
		
		String respXml = decrytXml( respXmlEnc,respKey ) ;
		
		
		logger.info("返回报文merchantId:"+merchantId);
		logger.info("返回报文XML:"+respXml);
		logger.info("返回报文签名:"+respSign);
		
		return respXml;
	}
	
	public String getMsgRespCode(String respMsg) throws Exception{
        SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new InputSource(new StringReader(respMsg)));
		
		//解析报文头
		Node packageHead = doc.selectSingleNode("/message/head");
		
		Node respCodeNode = packageHead.selectSingleNode("resp_code");
		
		return respCodeNode.getText();
	}
	
	public String getMsgRespDesc(String respMsg) throws Exception{
        SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new InputSource(new StringReader(respMsg)));
		
		//解析报文头
		Node packageHead = doc.selectSingleNode("/message/head");
		
		Node respCodeNode = packageHead.selectSingleNode("resp_desc");
		
		return respCodeNode.getText();
	}
	
	public String getMsgTranRespCode(String respMsg) throws Exception{
        SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new InputSource(new StringReader(respMsg)));
		
		//解析报文头
		Node packageHead = doc.selectSingleNode("/message/body");
		
		Node respCodeNode = packageHead.selectSingleNode("tran_resp_code");
		
		return respCodeNode.getText();
	}
	
	public String getMsgState(String respMsg) throws Exception{
        SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new InputSource(new StringReader(respMsg)));
		
		//解析报文头
		Node packageHead = doc.selectSingleNode("/message/body");
		if(packageHead==null)
			return null;
		
		Node tranStateNode = packageHead.selectSingleNode("tran_state");
		if(tranStateNode==null)
			return null;
		
		return tranStateNode.getText();
	}
	
	public String getIsBcnAndIdnConform(String respMsg) throws Exception{
        SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new InputSource(new StringReader(respMsg)));
		
		//解析报文头
		Node packageHead = doc.selectSingleNode("/message/body");
		if(packageHead==null)
			return null;
		
		Node IsBcnAndIdnConformNode = packageHead.selectSingleNode("is_bcn_and_idn_conform");
		if(IsBcnAndIdnConformNode==null)
			return null;
		
		return IsBcnAndIdnConformNode.getText();
	}
	
	public String getBankName(String respMsg) throws Exception{
        SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new InputSource(new StringReader(respMsg)));
		
		//解析报文头
		Node packageHead = doc.selectSingleNode("/message/body");
		if(packageHead==null)
			return null;
		
		Node bankNameNode = packageHead.selectSingleNode("bank_name");
		if(bankNameNode==null)
			return null;
		
		return bankNameNode.getText();
	}
	
	
	private String encryptKey( byte[] key){
		
		byte[] enc_key = null ;
		try {
			enc_key = rsaHelper.encryptRSA(key, false, "UTF-8") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return StringUtil.bytesToHexString(enc_key) ;
	}
	
	private byte[] decryptKey(String hexkey){
		byte[] key = null ;
		byte[] enc_key = StringUtil.hexStringToBytes(hexkey) ;
		
		try {
			key = rsaHelper.decryptRSA(enc_key, false, "UTF-8") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return key ;
	}
	
	private String encryptXml( String xml, byte[] key){
		
		String enc_xml = CryptoUtils.desEncryptToHex(xml, key) ;
		
		return enc_xml;
	}
	
	public String decrytXml(String xml_enc, byte[] key) {
		String xml = CryptoUtils.desDecryptFromHex(xml_enc, key) ;
		return xml;
	}

	public boolean verifyMsgSign(String xml, String sign)
	{
		byte[] bsign = StringUtil.hexStringToBytes(sign) ;
		
		boolean ret = false ;
		try {
			ret = rsaHelper.verifyRSA(xml.getBytes("UTF-8"), bsign, false, "UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public String signMsg( String xml ){
		String hexSign = null ;
		
		try {
			byte[] sign = rsaHelper.signRSA(xml.getBytes("UTF-8"), false, "UTF-8") ;
			
			hexSign = StringUtil.bytesToHexString(sign) ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hexSign;
	}
	
	public boolean verifySign(byte[] plainBytes, byte[] signBytes){
		boolean flag = false;
		try {
			flag = rsaHelper.verifyRSA(plainBytes, signBytes, false, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public CpJYTRespDef StringToDef(CpJYTRespDef cpJYTRespDef, String bank_name,String account_no,String account_name,String account_type,String brach_bank_province,String brach_bank_city,
			String brach_bank_name,String tran_amt,String currency,String bsn_code,String cert_type,String cert_no,String mobile,String remark){
		cpJYTRespDef.setBank_name(brach_bank_name);
		cpJYTRespDef.setAccount_no(account_no);
		cpJYTRespDef.setAccount_name(account_name);
		cpJYTRespDef.setAccount_type(account_type);
		cpJYTRespDef.setTran_amt(tran_amt);
		cpJYTRespDef.setCurrency(currency);
		cpJYTRespDef.setBsn_code(bsn_code);
		cpJYTRespDef.setCert_no(cert_no);
		cpJYTRespDef.setCert_type(cert_type);
		
		return cpJYTRespDef;
		
	}
	
    /** 
     * 读取密钥 
     */  
	public String initKey(String path ,String fileName) {  
		StringBuffer publickey = new StringBuffer(); 
        try {  
            br = new BufferedReader(new FileReader(path  
                    + fileName));             
            String s = null;  
            while ((s = br.readLine()) != null){         
                publickey.append(s + "\n");  
            }  	           
        } catch (Exception e) {  
        }
		return publickey.toString();  
    }  
	
	
//		public static void main(String[] args) {
//		
//		JinYuntongPayServiceImpl mo =new JinYuntongPayServiceImpl();
//		String bank_name = "中国建设银行";
//		String account_no = "6227000013500065541";
//		String account_name = "王新河";
//		String account_type = "00";		
//		String brach_bank_province = "";
//		String brach_bank_city = "";
//		String brach_bank_name = "";
//		String tran_amt = "102.22";
//		String currency = "CNY";
//		//String bsn_code = "10101";
//		String bsn_code = "10101";
//		String cert_type = "01";
//		String cert_no = "210302198107062717";
//		String mobile = "18611344667";
//		String remark = "测试通道";
//		String trans_id="1231";
//		String cust_id="2222";
//		
//		try {
//			mo.initRsaHelper();
//			mo.JYTAuth(account_no, "", cert_no, account_name, "03","DEBIT",mobile);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}			
//	}

	
}
	
