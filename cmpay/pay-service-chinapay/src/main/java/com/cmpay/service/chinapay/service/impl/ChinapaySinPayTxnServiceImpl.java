package com.cmpay.service.chinapay.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpay.service.chinapay.model.CpSinPayQueryReq;
import com.cmpay.service.chinapay.model.CpSinPayQueryRespDef;
import com.cmpay.service.chinapay.model.CpSinPayReq;
import com.cmpay.service.chinapay.model.CpSinPayRespDef;
import com.cmpay.service.chinapay.model.IdType;
import com.cmpay.service.chinapay.model.TransStatusDef;

import chinapay.Base64;
import chinapay.SecureLink;

/**
 * chinapay代付平台交易的service
 * 
 * @author shenxw
 */
@Service
@Transactional
public class ChinapaySinPayTxnServiceImpl{

	// public static String encoding = "GBK";

	private Logger logger = LoggerFactory.getLogger(getClass());


	private ChinaPaySinPayParamFactory paramFactory;

	/**
	 * 卡号或存折号标识位 (0表示卡,1表示折)
	 */
	private static final String CARD_TYPE1 = "0";
	
	/**
	 * 卡号或存折号标识位 (0表示卡,1表示折)
	 */
//	private static final String CARD_TYPE2 = "1";
	
	/**
	 * 人民币币种代码
	 */
	private static final String CURY_RMB = "156";
	
	/**
	 * 固定，交易类型
	 */
	private static final String TRANS_TYPE = "0003";
	
	/**
	 * 金额以分为单位
	 */
	private static final DecimalFormat AMT_FORMAT = new DecimalFormat("000000000000"); 
	
	/**
	 * 对公对私标记。“00”对私，“01”对公。
	 */
	private static final String PRIVATE_FLAG = "00";
	
//	@Autowired
//	 private SystemStatusFacility systemStatusFacility;
	
	/**
	 * 对公对私标记。“00”对私，“01”对公。
	 */
//	private static final String PUBLIC_FLAG = "01";
	
	// @Autowired
	// private SystemStatusFacility systemStatusFacility;

	/**
	 * 格式化为银联的订单号格式
	 * 
	 * @param txnNo
	 * @return
	 */
	private String formatOrderNo(Integer txnNo) {
		// ---- FOR TEST --- BEGIN --- 测试用，需删除 ！ 为避免测试时，银联报[重复订单号]，用随机数做订单号
//		 txnNo = randomOrderNo();
		// ---- FOR TEST --- END

		String orderNo = StringUtils.leftPad(String.valueOf(txnNo), 16, '0');
		logger.info("订单号=[{}]", orderNo);
		return orderNo;
	}

	 private int randomOrderNo() {
	 Random random = new Random();
	 int tn = Math.abs(random.nextInt());
	 return tn;
	 }

	private String getCpIdType(IdType idType) {
		String cpIdType = "01";
		if (IdType.I == idType) {
			cpIdType = "01";
		} else if (IdType.B == idType) {
			cpIdType = "02";
		} else if (IdType.P == idType) {
			cpIdType = "03";
		} else if (IdType.W == idType) {
			cpIdType = "05";
		} else if (IdType.C == idType) {
			cpIdType = "06";
		} else if (IdType.S == idType) {
			cpIdType = "07";
		} else {
			cpIdType = "99";
		}
		return cpIdType;
	}

	/**
	 * chinapay支付捷 - 单笔代付交易 ResponseCode : 0000-成功
	 * 
	 * @param transInf
	 * @return
	 */
	public CpSinPayRespDef sinPay(Integer payOrderNo,String transId, String cardNo, String custId, String bankId,String bankName, BigDecimal transAmt, String purpose, String custName, String province, String city, String subBank)  {
		CpSinPayRespDef cpSinPayRespDef = new CpSinPayRespDef();
		
		//记录代付请求
//		CpPayOrder payOrder = new CpPayOrder();
//		payOrder.setProcDate(systemStatusFacility.getSystemStatus().businessDate);
//		payOrder.setAmount(transAmt);
//		payOrder.setBankCode(bankId);
//		payOrder.setCardName(custName);
//		payOrder.setCardNo(cardNo);
//		payOrder.setCardType("");
//		payOrder.setCertId("");
//		payOrder.setCertType("");
//		payOrder.setCity(city);
//		payOrder.setCreateTime(new Date());
//		payOrder.setCuryId("");
//		payOrder.setCustId(custId);
//		payOrder.setDescription(purpose);
//		payOrder.setFlag(PRIVATE_FLAG);
//		payOrder.setMerId(paramFactory.getMerId());
//		payOrder.setProv(province);
//		payOrder.setSubBank(subBank);
//		payOrder.setTransDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
//		payOrder.setTransId(transId);
//		payOrder.setTransStatus(TransStatusDef.U);
//		em.persist(payOrder);
		
		// ---- 封装请求
		CpSinPayReq req = new CpSinPayReq();
		req.setMerId(paramFactory.getMerId());//req.setMerId("808080211389034");
		req.setMerDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));//req.setMerDate("20151019");
		req.setMerSeqId(formatOrderNo(payOrderNo));//req.setMerSeqId("0000000000123454");
		req.setCardNo(cardNo);//req.setCardNo("6226620607792207");
		req.setUsrName(custName);//req.setUsrName(toUnicode("刘敏"));
		//FIXME   bankId应该对应的是银行全称
		req.setOpenBank(bankName);//req.setOpenBank(toUnicode("光大银行"));
		//FIXME   province连连支付中为省编码，在银联为全称
		req.setProv(province);//req.setProv(toUnicode("湖北"));
		//FIXME   city连连支付中为省编码，在银联为全称
		req.setCity(city);//req.setCity(toUnicode("上海市"));
		req.setTransAmt(AMT_FORMAT.format(transAmt.multiply(new BigDecimal(100)))); // 根据transAmt格式化
		req.setPurpose(toUnicode(purpose));//req.setPurpose(toUnicode("测试代付"));  可空
		//req.setSubBank(toUnicode(subBank));//req.setSubBank(toUnicode("光大银行宜昌支行"));
		// FIXME 若走到”交行大小额“和”人行大小额“通道上，是会验省市的，故贵司的省市字段要传正确，且支行字段也要传正确
		req.setSubBank("");
		req.setFlag(PRIVATE_FLAG);//req.setFlag("00");
		req.setVersion(paramFactory.getSfjSinPayVersion());//req.setVersion("20090501");
		req.setSignFlag("1");//固定
		//获得签名
		String chkValue = getCpSinPayCheckValue(req);
		req.setChkValue(chkValue);
		//发送请求
		String resMes = null;
		try {
			resMes = sendCpSinPay(req);
		
			//解析结果并验签
			cpSinPayRespDef = praseCpSinPayRes(resMes);
			//记录订单信息
//			payOrder.setResCode(cpSinPayRespDef.getResponseCode());
//			payOrder.setResStat(cpSinPayRespDef.getStat());
//			payOrder.setCpSeqid(cpSinPayRespDef.getCpSeqId());
//			payOrder.setCpDate(cpSinPayRespDef.getCpDate());
			//订单状态更新
			if(cpSinPayRespDef.getResponseCode().equals("0000")){//交易接收成功
				if(cpSinPayRespDef.getStat().equals("s")){//代付成功
//					payOrder.setTransStatus(TransStatusDef.S);
					cpSinPayRespDef.setTransStat(TransStatusDef.S.toString());
				} else if (cpSinPayRespDef.getStat().equals("9") || cpSinPayRespDef.getStat().equals("6")) {
//					payOrder.setTransStatus(TransStatusDef.F);
					cpSinPayRespDef.setTransStat(TransStatusDef.F.toString());
				} else {
//					payOrder.setTransStatus(TransStatusDef.U);
					cpSinPayRespDef.setTransStat(TransStatusDef.U.toString());
				}
			}else{//交易接收失败
//				payOrder.setTransStatus(TransStatusDef.F);
				cpSinPayRespDef.setTransStat(TransStatusDef.F.toString());
			}
		} catch (Exception e) {
			logger.error("银联代付出现异常！{}",e);
//			payOrder.setTransStatus(TransStatusDef.U);
			cpSinPayRespDef.setTransStat(TransStatusDef.Q.toString());
		}
		String message = "银联响应码:["+cpSinPayRespDef.getResponseCode()+"],响应信息:"+cpSinPayRespDef.getRespMsg();
		cpSinPayRespDef.setRespMsg(message);
		cpSinPayRespDef.setThirdPartOrderNo(req.getMerSeqId());
		return cpSinPayRespDef;
	}
	
	
	/**
	 * chinapay支付捷 - 单笔代付交易 ResponseCode : 0000-成功,加超时
	 * 
	 * @param transInf
	 * @return
	 */
	public CpSinPayRespDef sinPay1(Integer payOrderNo,String transId, String cardNo, String custId, String bankId,String bankName, BigDecimal transAmt, String purpose, String custName, String province, String city, String subBank) throws Exception,IOException {
		CpSinPayRespDef cpSinPayRespDef = new CpSinPayRespDef();
		
		//记录代付请求
//		CpPayOrder payOrder = new CpPayOrder();
//		payOrder.setProcDate(systemStatusFacility.getSystemStatus().businessDate);
//		payOrder.setAmount(transAmt);
//		payOrder.setBankCode(bankId);
//		payOrder.setCardName(custName);
//		payOrder.setCardNo(cardNo);
//		payOrder.setCardType("");
//		payOrder.setCertId("");
//		payOrder.setCertType("");
//		payOrder.setCity(city);
//		payOrder.setCreateTime(new Date());
//		payOrder.setCuryId("");
//		payOrder.setCustId(custId);
//		payOrder.setDescription(purpose);
//		payOrder.setFlag(PRIVATE_FLAG);
//		payOrder.setMerId(paramFactory.getMerId());
//		payOrder.setProv(province);
//		payOrder.setSubBank(subBank);
//		payOrder.setTransDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
//		payOrder.setTransId(transId);
//		payOrder.setTransStatus(TransStatusDef.U);
//		em.persist(payOrder);
		
		// ---- 封装请求
		CpSinPayReq req = new CpSinPayReq();
		req.setMerId(paramFactory.getMerId());//req.setMerId("808080211389034");
		req.setMerDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));//req.setMerDate("20151019");
		req.setMerSeqId(formatOrderNo(payOrderNo));//req.setMerSeqId("0000000000123454");
		req.setCardNo(cardNo);//req.setCardNo("6226620607792207");
		req.setUsrName(custName);//req.setUsrName(toUnicode("刘敏"));
		//FIXME   bankId应该对应的是银行全称
		req.setOpenBank(bankName);//req.setOpenBank(toUnicode("光大银行"));
		//FIXME   province连连支付中为省编码，在银联为全称
		req.setProv(province);//req.setProv(toUnicode("湖北"));
		//FIXME   city连连支付中为省编码，在银联为全称
		req.setCity(city);//req.setCity(toUnicode("上海市"));
		req.setTransAmt(AMT_FORMAT.format(transAmt.multiply(new BigDecimal(100)))); // 根据transAmt格式化
		req.setPurpose(toUnicode(purpose));//req.setPurpose(toUnicode("测试代付"));  可空
		//req.setSubBank(toUnicode(subBank));//req.setSubBank(toUnicode("光大银行宜昌支行"));
		// FIXME 若走到”交行大小额“和”人行大小额“通道上，是会验省市的，故贵司的省市字段要传正确，且支行字段也要传正确
		req.setSubBank("");
		req.setFlag(PRIVATE_FLAG);//req.setFlag("00");
		req.setVersion(paramFactory.getSfjSinPayVersion());//req.setVersion("20090501");
		req.setSignFlag("1");//固定
		//获得签名
		String chkValue = getCpSinPayCheckValue(req);
		req.setChkValue(chkValue);
		//发送请求
		String resMes = null;
		try {
			resMes = sendCpSinPay1(req);
		
			//解析结果并验签
			cpSinPayRespDef = praseCpSinPayRes(resMes);
			//记录订单信息
//			payOrder.setResCode(cpSinPayRespDef.getResponseCode());
//			payOrder.setResStat(cpSinPayRespDef.getStat());
//			payOrder.setCpSeqid(cpSinPayRespDef.getCpSeqId());
//			payOrder.setCpDate(cpSinPayRespDef.getCpDate());
			//订单状态更新
			if(cpSinPayRespDef.getResponseCode().equals("0000")){//交易接收成功
				if(cpSinPayRespDef.getStat().equals("s")){//代付成功
//					payOrder.setTransStatus(TransStatusDef.S);
					cpSinPayRespDef.setTransStat(TransStatusDef.S.toString());
				} else if (cpSinPayRespDef.getStat().equals("9") || cpSinPayRespDef.getStat().equals("6")) {
//					payOrder.setTransStatus(TransStatusDef.F);
					cpSinPayRespDef.setTransStat(TransStatusDef.F.toString());
				} else {
//					payOrder.setTransStatus(TransStatusDef.U);
					cpSinPayRespDef.setTransStat(TransStatusDef.U.toString());
				}
			}else{//交易接收失败
//				payOrder.setTransStatus(TransStatusDef.F);
				cpSinPayRespDef.setTransStat(TransStatusDef.F.toString());
			}
		} catch (Exception e) {
			logger.error("银联代付出现异常！{}",e);
//			payOrder.setTransStatus(TransStatusDef.U);
			cpSinPayRespDef.setTransStat(TransStatusDef.Q.toString());
		}
		String message = "银联响应码:["+cpSinPayRespDef.getResponseCode()+"],响应信息:"+cpSinPayRespDef.getRespMsg();
		cpSinPayRespDef.setRespMsg(message);
		cpSinPayRespDef.setThirdPartOrderNo(req.getMerSeqId());
		return cpSinPayRespDef;
	}

	/**
	 * chinapay支付捷 - 单笔代付交易查询 merDate 固定格式'yyyyMMdd'
	 * 
	 * @return
	 */
	public CpSinPayQueryRespDef sinPayQuery(Integer orderNo,String transDate,Integer payOrderNo) {
//		CpPayOrder payOrder = em.find(CpPayOrder.class, orderNo);
//		if (payOrder == null) {
//			return null;
//		}
		
		CpSinPayQueryRespDef cpSinPayQueryRespDef = new CpSinPayQueryRespDef();
		
		//封装查询请求
		CpSinPayQueryReq req = new CpSinPayQueryReq();
		req.setMerId(paramFactory.getMerId());// 固定
		req.setMerDate(transDate);
		req.setMerSeqId(formatOrderNo(payOrderNo));
		req.setVersion(paramFactory.getSfjSinPayVersion());
		req.setSignFlag("1");// 固定
		//获得签名值
		String chkValue = getCpSinPayQueryCheckValue(req);
		req.setChkValue(chkValue);
		//发送请求
		String resMes = null;
		try {
			resMes = sendCpSinPayQuery(req);
		} catch (Exception e) {
			logger.error("发送请求失败！{}",e);
		}
		//解析结果并验签
		cpSinPayQueryRespDef = praseCpSinPayQueryRes(resMes);
		//记录订单信息
//		payOrder.setResStat(cpSinPayQueryRespDef.getStat());
		//订单状态更新
		if(cpSinPayQueryRespDef.getCode().equals("000")){//查询交易成功
			if(cpSinPayQueryRespDef.getStat().equals("s")){
//				payOrder.setTransStatus(TransStatusDef.S);
			}else if(cpSinPayQueryRespDef.getStat().equals("6") || cpSinPayQueryRespDef.getStat().equals("9")){
//				payOrder.setTransStatus(TransStatusDef.F);
			}else{
//				payOrder.setTransStatus(TransStatusDef.U);
			}
		}else if(cpSinPayQueryRespDef.getCode().equals("001")){
//			logger.info("银联查询无此代付订单，[银联代付订单号={}]", payOrder.getPayOrderNo());
		}else{
			logger.info("银联查询代付订单出错.");
		}
		return cpSinPayQueryRespDef;
	}

	
	/**
	 * 获得单笔代付签名值
	 * @param req
	 * @return
	 */
	public String getCpSinPayCheckValue(CpSinPayReq req){
		String Data = req.getString4Chk();
		String plainData = "";
		try {
			plainData = new String(Base64.encode(Data.getBytes("GBK")));
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		logger.debug("转换成Base64后数据：" + plainData);
		String chkValue = null;
		// 初始化key文件：
		chinapay.PrivateKey key = new chinapay.PrivateKey();
		boolean flag = false;
		try {
			flag = key.buildKey(paramFactory.getMerId(), 0, paramFactory.getMerPrK());
		} catch (Exception e) {
			logger.error("build key error!{}", e);
			return null;
		}
		if(flag == false){
			logger.error("build key error!");
			return null;
		}else{
			logger.debug("build key success!");
		}
		SecureLink sl = new SecureLink(key);
		chkValue = sl.Sign(plainData);
		logger.debug("签名内容:"+ chkValue);
		return chkValue;
	}
	
	/**
	 * 获得代付查询签名值
	 * @param req
	 * @return
	 */
	public String getCpSinPayQueryCheckValue(CpSinPayQueryReq req){
		String Data = req.getString4Chk();
		String plainData = "";
		try {
			plainData = new String(Base64.encode(Data.getBytes("GBK")));
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		logger.debug("转换成Base64后数据："+plainData);
		//签名
		String chkValue = null;
		int KeyUsage = 0;
		chinapay.PrivateKey key = new chinapay.PrivateKey();
		boolean flag = false;
		try {
			flag = key.buildKey(paramFactory.getMerId(), 0, paramFactory.getMerPrK());
		} catch (Exception e) {
			logger.error("build key error!{}",e);
			return null;
		}
		if(flag == false){
			logger.error("build key error!");
			return null;
		}else{
			logger.debug("build key success!");
		}
		SecureLink sl = new SecureLink(key);
		chkValue = sl.Sign(plainData);
		logger.debug("签名内容："+chkValue);
		return chkValue;
	}
	
	
	/**
	 * 发送单笔代付请求报文
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String sendCpSinPay(CpSinPayReq req) throws Exception{
		logger.info("代付请求报文:"+req.toString());
		//连接Chinapay控台
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, paramFactory.getSfjEncoding());
//		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(300000);//链接超时
//		httpClient.getHttpConnectionManager().getParams().setSoTimeout(360000);//读取超时
		PostMethod postMethod = new PostMethod(paramFactory.getSfjSinPayReqUrl());
		//填入各个表单域的值
		NameValuePair[] data = { 
				new NameValuePair("merId", req.getMerId()),
				new NameValuePair("merDate", req.getMerDate()),
				new NameValuePair("merSeqId", req.getMerSeqId()),
				new NameValuePair("cardNo", req.getCardNo()),
				new NameValuePair("usrName", req.getUsrName()),
				new NameValuePair("openBank", req.getOpenBank()),
				new NameValuePair("prov", req.getProv()),
				new NameValuePair("city", req.getCity()),
				new NameValuePair("transAmt", req.getTransAmt()),
				new NameValuePair("purpose", req.getPurpose()),
				new NameValuePair("subBank", req.getSubBank()),
				new NameValuePair("flag", req.getFlag()),
				new NameValuePair("version", req.getVersion()),
				new NameValuePair("chkValue",req.getChkValue()),
				new NameValuePair("signFlag", req.getSignFlag())
		};
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		try {
			httpClient.executeMethod(postMethod);
		} catch (Exception e) {
			logger.error("发送代付请求异常,{}", e);
		}
		// 读取内容
		InputStream resInputStream = null;
		try {
			resInputStream = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 处理内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
		String tempBf = null;
		StringBuffer html=new StringBuffer(); 
		while((tempBf = reader.readLine()) != null){ 
							
			html.append(tempBf); 
		}
		String resMes = html.toString();
		logger.info("代付交易返回报文：" + resMes);
		return resMes;
	}
	
	/**
	 * 发送单笔代付请求报文,加超时
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String sendCpSinPay1(CpSinPayReq req) throws Exception,IOException{
		logger.info("代付请求报文:"+req.toString());
		//连接Chinapay控台
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, paramFactory.getSfjEncoding());
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(300000);//链接超时
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(360000);//读取超时
		PostMethod postMethod = new PostMethod(paramFactory.getSfjSinPayReqUrl());
		//填入各个表单域的值
		NameValuePair[] data = { 
				new NameValuePair("merId", req.getMerId()),
				new NameValuePair("merDate", req.getMerDate()),
				new NameValuePair("merSeqId", req.getMerSeqId()),
				new NameValuePair("cardNo", req.getCardNo()),
				new NameValuePair("usrName", req.getUsrName()),
				new NameValuePair("openBank", req.getOpenBank()),
				new NameValuePair("prov", req.getProv()),
				new NameValuePair("city", req.getCity()),
				new NameValuePair("transAmt", req.getTransAmt()),
				new NameValuePair("purpose", req.getPurpose()),
				new NameValuePair("subBank", req.getSubBank()),
				new NameValuePair("flag", req.getFlag()),
				new NameValuePair("version", req.getVersion()),
				new NameValuePair("chkValue",req.getChkValue()),
				new NameValuePair("signFlag", req.getSignFlag())
		};
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		try {
			httpClient.executeMethod(postMethod);
		} catch (Exception e) {
			logger.error("发送代付请求异常,{}", e);
		}
		// 读取内容
		InputStream resInputStream = null;
		try {
			resInputStream = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 处理内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
		String tempBf = null;
		StringBuffer html=new StringBuffer(); 
		while((tempBf = reader.readLine()) != null){ 
							
			html.append(tempBf); 
		}
		String resMes = html.toString();
		logger.info("代付交易返回报文：" + resMes);
		return resMes;
	}
	
	/**
	 * 发送单笔代付查询请求报文
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String sendCpSinPayQuery(CpSinPayQueryReq req) throws Exception{
		logger.info("代付查询报文:"+req.toString());
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, paramFactory.getSfjEncoding());
		PostMethod postMethod = new PostMethod(paramFactory.getSfjSinPayQueryReqUrl());
		//填入各个表单域的值
		NameValuePair[] data = { 
				new NameValuePair("merId", req.getMerId()),
				new NameValuePair("merDate", req.getMerDate()),
				new NameValuePair("merSeqId", req.getMerSeqId()),
		 		new NameValuePair("version", req.getVersion()),
				new NameValuePair("chkValue",req.getChkValue()),
				new NameValuePair("signFlag", "1")
		};
		
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		try {
			httpClient.executeMethod(postMethod);
		} catch (Exception e) {
			logger.error("发送代付请求异常,{}", e);
		}
		// 读取内容
		InputStream resInputStream = null;
		try {
			resInputStream = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 处理内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
		String tempBf = null;
		StringBuffer html=new StringBuffer(); 
		while((tempBf = reader.readLine()) != null){ 
					
			html.append(tempBf); 
		}
		String resMes = html.toString();
		logger.info("代付查询返回报文：" + resMes);
		return resMes;
	}
	
	/**
	 * 解析代付请求结果报文并验签
	 * @param resMes
	 * @return
	 */
	public CpSinPayRespDef praseCpSinPayRes(String resMes){
		CpSinPayRespDef cpSinPayRespDef = new CpSinPayRespDef();
		int dex = resMes.lastIndexOf("&");
		//拆分页面应答数据
		String str[] = resMes.split("&");
		//提取返回数据
		if(str.length == 10){//返回成功
			int Res_Code = str[0].indexOf("=");
			int Res_merId = str[1].indexOf("=");
			int Res_merDate = str[2].indexOf("=");
			int Res_merSeqId = str[3].indexOf("=");
			int Res_cpDate = str[4].indexOf("=");
			int Res_cpSeqId = str[5].indexOf("=");
			int Res_transAmt = str[6].indexOf("=");
			int Res_stat = str[7].indexOf("=");
			int Res_cardNo = str[8].indexOf("=");
			int Res_chkValue = str[9].indexOf("=");
						
			String responseCode = str[0].substring(Res_Code+1);
			cpSinPayRespDef.setResponseCode(responseCode);
			String MerId = str[1].substring(Res_merId+1);
			String MerDate = str[2].substring(Res_merDate+1);
			String MerSeqId = str[3].substring(Res_merSeqId+1);
//			cpSinPayRespDef.setPayOrderNo(MerSeqId);
			String CpDate = str[4].substring(Res_cpDate+1);
			cpSinPayRespDef.setCpDate(CpDate);
			String CpSeqId = str[5].substring(Res_cpSeqId+1);
			cpSinPayRespDef.setCpSeqId(CpSeqId);
			String TransAmt = str[6].substring(Res_transAmt+1);
			String Stat = str[7].substring(Res_stat+1);
			cpSinPayRespDef.setStat(Stat);
			String CardNo = str[8].substring(Res_cardNo+1);
			String ChkValue = str[9].substring(Res_chkValue+1);
			String msg = resMes.substring(0,dex);
			String plainData1 = new String(Base64.encode(msg.getBytes()));
			//对收到的ChinaPay应答传回的域段进行验签
			boolean buildOK = false;
			boolean res = false;
			int KeyUsage = 0;
			chinapay.PrivateKey key1 = new chinapay.PrivateKey();
			try {
				buildOK = key1.buildKey(paramFactory.getPubId(), KeyUsage, paramFactory.getPgPubk());
			} catch (Exception e) {
				logger.error("build key error,{}", e);
			}
			if (!buildOK) {
				logger.error("build key error!");
			}else{
				logger.debug("build key success!");
			}
			SecureLink sl1 = new SecureLink(key1);
			res=sl1.verifyAuthToken(plainData1,ChkValue);
			if (res){
				logger.debug("验签数据正确!");
			}else {
				logger.error("签名数据不匹配,签名数据:{}"+msg);
			}
			return cpSinPayRespDef;
		}
		if(str.length == 2){//交易失败应答
			int Res_Code = str[0].indexOf("=");
			int Res_chkValue = str[1].indexOf("=");
			
			String responseCode = str[0].substring(Res_Code+1);
			String ChkValue = str[1].substring(Res_chkValue+1);
			cpSinPayRespDef.setResponseCode(responseCode);
			
			String plainData2 = str[0];
			String plainData3 = new String(Base64.encode(plainData2.getBytes()));
			
			//对收到的ChinaPay应答传回的域段进行验签
			boolean buildOK = false;
			boolean res = false;
			int KeyUsage = 0;
			chinapay.PrivateKey key2 = new chinapay.PrivateKey();
			try {
				buildOK = key2.buildKey(paramFactory.getPubId(), KeyUsage, paramFactory.getPgPubk());
			} catch (Exception e) {
				logger.error("build key error,{}", e);
			}
			if (!buildOK) {
				logger.error("build key error!");
			}else{
				logger.debug("build key success!");
			}
			SecureLink sl2 = new SecureLink(key2);
			res=sl2.verifyAuthToken(plainData3,ChkValue);
			if (res){
				logger.debug("验签数据正确!");
			}else {
				logger.error("签名数据不匹配,签名数据:{}"+plainData2);
			}
			return cpSinPayRespDef;
		}
		return cpSinPayRespDef;
	}
	
	/**
	 *  解析代付查询请求结果报文并验签
	 * @param resMes
	 * @return
	 */
	public CpSinPayQueryRespDef praseCpSinPayQueryRes(String resMes){
		CpSinPayQueryRespDef cpSinPayQueryRespDef = new CpSinPayQueryRespDef();
		int dex = resMes.lastIndexOf("|");
		String Res_Code = resMes.substring(0,3);
		cpSinPayQueryRespDef.setCode(Res_Code);
		//提取返回数据
		if(Res_Code.equals("000")){
			String nResMes = resMes.substring(0,dex);
			int nDex = nResMes.lastIndexOf("|");
			//String Res_stat = resMes.substring(dex-2,dex-1);
			String Res_stat = nResMes.substring(nDex-1,nDex);
			String Res_chkValue = resMes.substring(dex+1);
			cpSinPayQueryRespDef.setStat(Res_stat);
			cpSinPayQueryRespDef.setChkValue(Res_chkValue);
			String plainData = resMes.substring(0,dex+1);
			String Data = "";
			try {
				Data = new String(Base64.encode(plainData.getBytes("GBK")));
			} catch (Exception e) {
				logger.error("签名编码转换失败:"+e.getMessage());
				e.printStackTrace();
			}
			//对收到的ChinaPay应答传回的域段进行验签
			boolean buildOK = false;
			boolean res = false;
			int KeyUsage = 0;
			chinapay.PrivateKey key1 = new chinapay.PrivateKey();
			try {
				buildOK = key1.buildKey(paramFactory.getPubId(), KeyUsage, paramFactory.getPgPubk());
			} catch (Exception e) {
				logger.error("build key error,{}", e);
			}
			if (!buildOK) {
				logger.error("build key error!");
			}else{
				logger.debug("build key success!");
			}
			SecureLink sl1 = new SecureLink(key1);
			res=sl1.verifyAuthToken(Data,Res_chkValue);
			if (res){
				logger.debug("验签数据正确!");
			}else {
				logger.error("签名数据不匹配,签名数据:{}"+Data);
			}
//			logger.info("cpSinPayQueryRespDef----------{}",cpSinPayQueryRespDef.toString());
			return cpSinPayQueryRespDef;
		}else{
			String Res_chkValue = resMes.substring(dex+1);
			cpSinPayQueryRespDef.setChkValue(Res_chkValue);
			String plainData = resMes.substring(0,dex+1);
			String Data = "";
			try {
				Data = new String(Base64.encode(plainData.getBytes("GBK")));
			} catch (Exception e) {
				logger.error("签名编码转换失败:"+e.getMessage());
				e.printStackTrace();
			}
			//对收到的ChinaPay应答传回的域段进行验签
			boolean buildOK = false;
			boolean res = false;
			int KeyUsage = 0;
			chinapay.PrivateKey key2 = new chinapay.PrivateKey();
			try {
				buildOK = key2.buildKey(paramFactory.getPubId(), KeyUsage, paramFactory.getPgPubk());
			} catch (Exception e) {
				logger.error("build key error,{}", e);
			}
			if (!buildOK) {
				logger.error("build key error!");
			}else{
				logger.debug("build key success!");
			}
			SecureLink sl2 = new SecureLink(key2);
			res=sl2.verifyAuthToken(Data,Res_chkValue);
			if (res){
				logger.debug("验签数据正确!");
			}else {
				logger.error("签名数据不匹配,签名数据:{}"+Data);
			}
			return cpSinPayQueryRespDef;
		}
	}

	/**
	 * 将Unicode码转换为中文
	 * 
	 * @param unicode
	 * @return
	 */
	private String tozhCN(String unicode) {
		StringBuffer gbk = new StringBuffer();
		String hex[] = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) { // 注意要从 1 开始，而不是从0开始。第一个是空。
			int data = Integer.parseInt(hex[i], 16); // 将16进制数转换为 10进制的数据。
			gbk.append((char) data); // 强制转换为char类型就是我们的中文字符了。
		}
		logger.debug("这是从 Unicode编码 转换为 中文字符: " + gbk.toString());
		return gbk.toString();
	}

	/**
	 * 将字符串转换为Unicode码
	 * 
	 * @param zhStr
	 * @return
	 */
	private String toUnicode(String zhStr) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < zhStr.length(); i++) {
			char c = zhStr.charAt(i);
			unicode.append("\\u" + Integer.toHexString(c));
		}
		logger.debug(unicode.toString());
		logger.debug(zhStr + "转换为unicode码成功！");
		return unicode.toString();
	}

	public ChinaPaySinPayParamFactory getParamFactory() {
		return paramFactory;
	}

	public void setParamFactory(ChinaPaySinPayParamFactory paramFactory) {
		this.paramFactory = paramFactory;
	}

	

}
