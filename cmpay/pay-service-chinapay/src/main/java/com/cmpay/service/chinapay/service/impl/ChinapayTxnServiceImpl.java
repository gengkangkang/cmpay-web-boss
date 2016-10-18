package com.cmpay.service.chinapay.service.impl;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpay.service.chinapay.model.ChinapaySfjReq;
import com.cmpay.service.chinapay.model.CpSinCutQueryReq;
import com.cmpay.service.chinapay.model.CpSinCutQueryResp;
import com.cmpay.service.chinapay.model.CpSinCutQueryRespDef;
import com.cmpay.service.chinapay.model.CpSinCutReq;
import com.cmpay.service.chinapay.model.CpSinCutResp;
import com.cmpay.service.chinapay.model.CpSinCutRespDef;
import com.cmpay.service.chinapay.model.CpSinPayQueryReq;
import com.cmpay.service.chinapay.model.CpSinPayQueryResp;
import com.cmpay.service.chinapay.model.CpSinPayQueryRespDef;
import com.cmpay.service.chinapay.model.CpSinPayReq;
import com.cmpay.service.chinapay.model.CpSinPayResp;
import com.cmpay.service.chinapay.model.CpSinPayRespDef;
import com.cmpay.service.chinapay.model.IdType;
import com.cmpay.service.chinapay.model.TransStatusDef;
import com.cmpay.service.chinapay.service.ChinapayTxnService;
import com.cmpay.service.chinapay.util.ChinapayUtil;
import com.cmpay.service.chinapay.util.HttpClient;

import chinapay.Base64;
import chinapay.SecureLink;
import chinapay.PrivateKey;

/**
 * chinapay收付捷平台交易的service
 * 
 * @author shenxw
 */
@Service
@Transactional
public class ChinapayTxnServiceImpl implements ChinapayTxnService {

	// public static String encoding = "GBK";

	private Logger logger = LoggerFactory.getLogger(getClass());


	private ChinaPayParamFactory paramFactory;

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
	
	/**
	 * 对公对私标记。“00”对私，“01”对公。
	 */
//	private static final String PUBLIC_FLAG = "01";
	

	/**
	 * chinapay支付捷 - 单笔代扣交易
	 * 
	 * @param transInf
	 * @return
	 */
	@Override
	public CpSinCutRespDef sinCut(Integer cutOrderNo,String transId, String cardNo, String custId, String bankCode, BigDecimal transAmt, String custName, String idNo, String description) {
		CpSinCutRespDef cpSinCutRespDef = new CpSinCutRespDef();
		CpSinCutResp resp = null;

		// 登记代扣记录
//		CpCutOrder cutOrder = new CpCutOrder();
//		cutOrder.setProcDate(systemStatusFacility.getSystemStatus().businessDate);
//		cutOrder.setAmount(transAmt);
//		cutOrder.setBankCode(bankCode);
//		cutOrder.setCardName(custName);
//		cutOrder.setCardNo(cardNo);
//		cutOrder.setCardType(CARD_TYPE1);
//		cutOrder.setCertId(idNo);
//		cutOrder.setCertType(getCpIdType(IdType.I));
//		cutOrder.setCreateTime(new Date());
//		cutOrder.setCuryId(CURY_RMB);
//		cutOrder.setCustId(custId);
//		cutOrder.setDescription(description);
//		cutOrder.setMerId(paramFactory.getMerId());
//		cutOrder.setTransDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
//		cutOrder.setTransId(transId);
//		cutOrder.setTransStatus(TransStatusDef.U);
//		cutOrder.setDescription(description);
//		em.persist(cutOrder);
//		
		// 准备代扣请求
		CpSinCutReq req = new CpSinCutReq();
		req.setMerId(paramFactory.getMerId());// 固定
		req.setTransDate(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		req.setOrderNo(formatOrderNo(cutOrderNo)); // getOrderNo根据txnNo格式化
		req.setTransType(TRANS_TYPE); // 固定
		req.setOpenBankId(bankCode);
		req.setCardType(CARD_TYPE1); // 卡号或存折号标识位 (0表示卡,1表示折)
		req.setCardNo(cardNo);
		req.setUsrName(toUnicode(custName));
		req.setCertType(getCpIdType(IdType.I));
		req.setCertId(idNo);
		req.setCuryId(CURY_RMB); // 固定
		// TODO 暂时不上送purpose字段，上送会签名失败
//		req.setPurpose(toUnicode(cutOrder.getDescription()));
		req.setPurpose("");
		req.setPriv1("");
		req.setTransAmt(AMT_FORMAT.format(transAmt.multiply(BigDecimal.valueOf(100)))); // 根据transAmt格式化
		req.setVersion(paramFactory.getSfjSinCutVersion()); // 固定
		req.setGateId(paramFactory.getSfjGateId()); // 固定
		
		Map<String, String> resmap = null;
		try {
			resmap = send(paramFactory.getSfjSinCutReqUrl(), req, true);
			resp = new CpSinCutResp();

			// 把map封装到bean里
			try {
				BeanUtils.populate(resp, resmap);
			} catch (Exception e) {
				logger.error("BeanUtils.populate:{}" + e);
			}
			if (StringUtils.isNotBlank(resp.getMessage())) {
				resp.setMessage(tozhCN(resp.getMessage()));
				logger.info("response message=[{}]", resp.getMessage());
			}
			if (resp != null) {
				try {
					BeanUtils.copyProperties(cpSinCutRespDef, resp);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			//记录返回信息
//			cutOrder.setResCode(cpSinCutRespDef.getResponseCode());
//			cutOrder.setResTransStat(cpSinCutRespDef.getTransStat());
			if (cpSinCutRespDef.getResponseCode().equals("00")) {
//				cutOrder.setTransStatus(TransStatusDef.S);
				cpSinCutRespDef.setTransStat(TransStatusDef.S.toString());
			} else if (cpSinCutRespDef.getResponseCode().equals("45") || cpSinCutRespDef.getResponseCode().equals("") || cpSinCutRespDef.getResponseCode().equals("09")) {
//				cutOrder.setTransStatus(TransStatusDef.U);
				cpSinCutRespDef.setTransStat(TransStatusDef.U.toString());
			} else {
//				cutOrder.setTransStatus(TransStatusDef.F);
				cpSinCutRespDef.setTransStat(TransStatusDef.F.toString());
			}
		} catch (Exception e) {
			//自定义错误响应码，代表交易出现异常,订单状态为处理中,具体结果交由轮询处理
			cpSinCutRespDef.setResponseCode("99");
//			cutOrder.setTransStatus(TransStatusDef.U);
			cpSinCutRespDef.setTransStat(TransStatusDef.U.toString());
		}
		String msg="";
		if(StringUtils.isNotBlank(cpSinCutRespDef.getMessage())){
			msg=cpSinCutRespDef.getMessage();
		}
		String message = "银联响应码:["+cpSinCutRespDef.getResponseCode()+"],响应信息:"+msg;
		cpSinCutRespDef.setMessage(message);
		cpSinCutRespDef.setCutOrderNo(cutOrderNo);
		cpSinCutRespDef.setThirdPartyOrderNo(req.getOrderNo());
		
		return cpSinCutRespDef;
	}

	/**
	 * chinapay支付捷 - 单笔代扣交易查询 transDate 固定格式'yyyyMMdd'
	 * 
	 * @return
	 */
	public CpSinCutQueryRespDef sinCutQuery(Integer orderNo,String transDate) {
		CpSinCutQueryRespDef cpSinCutQueryRespDef = new CpSinCutQueryRespDef();
		
//		CpCutOrder cutOrder = em.find(CpCutOrder.class, orderNo);
//		if (orderNo == null) { // 查无此交易
//			return null;
//		} 
		
		// 组装查询交易
		CpSinCutQueryReq req = new CpSinCutQueryReq();
		req.setMerId(paramFactory.getMerId());
		req.setTransType("0003");
		req.setOrderNo(formatOrderNo(Integer.valueOf(orderNo)));
		req.setTransDate(transDate);
		req.setVersion(paramFactory.getSfjSinCutVersion());
		req.setPriv1("");

		CpSinCutQueryResp cpSinCutQueryResp = sendQuerySinCut(paramFactory.getSfjSinCutQueryReqUrl(), req);
//		cutOrder.setResCode(cpSinCutQueryResp.getResponseCode());
//		cutOrder.setResTransStat(cpSinCutQueryResp.getTransStat());
		if (cpSinCutQueryResp.getResponseCode().equals("00")) {// 更新订单状态
//			cutOrder.setTransStatus(TransStatusDef.S);
		} else if (cpSinCutQueryResp.getResponseCode().equals("45") || cpSinCutQueryResp.getResponseCode().equals("") || cpSinCutQueryResp.getResponseCode().equals("09")) {
//			cutOrder.setTransStatus(TransStatusDef.U);
		} else {
//			cutOrder.setTransStatus(TransStatusDef.F);
		}
		if (cpSinCutQueryResp != null) {
			try {
				BeanUtils.copyProperties(cpSinCutQueryRespDef, cpSinCutQueryResp);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (StringUtils.isNotBlank(cpSinCutQueryRespDef.getMessage())) {
				cpSinCutQueryRespDef.setMessage(tozhCN(cpSinCutQueryRespDef.getMessage()));
				logger.info("response message=[{}]", cpSinCutQueryRespDef.getMessage());
			}
		}
		return cpSinCutQueryRespDef;
	}

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
	@Override
	public CpSinPayRespDef sinPay(Integer payOrderNo,String transId, String cardNo, String custId, String bankId, BigDecimal transAmt, String purpose, String custName, String province, String city, String subBank) {
		CpSinPayRespDef cpSinPayRespDef = new CpSinPayRespDef();
		CpSinPayResp resp = null;

		// 记录代付请求
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
		req.setMerId(paramFactory.getMerId());// 固定//req.setMerId("808080211389035");
		req.setMerDate(DateFormatUtils.format(new Date(), "yyyyMMdd")); // req.setMerDate("20150624");
		// 左边补0
		req.setMerSeqId(formatOrderNo(payOrderNo)); // req.setMerSeqId("0020150624102069");
		req.setCardNo(cardNo);
		req.setUsrName(toUnicode(custName));
		req.setOpenBank(bankId);
		req.setProv(toUnicode(province));
		req.setCity(toUnicode(city));
		req.setTransAmt(AMT_FORMAT.format(transAmt.multiply(new BigDecimal(100)))); // 根据transAmt格式化
		req.setPurpose(toUnicode(purpose));
		req.setSubBank(toUnicode(subBank)); // req.setSubBank("浦东支行");
		req.setFlag(PRIVATE_FLAG);// req.setFlag("00");
		req.setVersion(paramFactory.getSfjSinPayVersion());
		req.setSignFlag("1");

		Map<String, String> resmap = null;

		try {
			resmap = send(paramFactory.getSfjSinPayReqUrl(), req, false);
			resp = new CpSinPayResp();
			
			// 把map封装到bean里
			try {
				BeanUtils.populate(resp, resmap);
				logger.debug(resp.toString());
			} catch (Exception e) {
				logger.error("BeanUtils.populate:{}" + e);
			}
			if (resp != null) {
				try {
					BeanUtils.copyProperties(cpSinPayRespDef, resp);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if (cpSinPayRespDef.getResponseCode().equals("0000")) {
				if (cpSinPayRespDef.getStat().equals("s")) {
//					payOrder.setTransStatus(TransStatusDef.S);
					cpSinPayRespDef.setTransStat(TransStatusDef.S.toString());
				} else if (cpSinPayRespDef.getStat().equals("9") || cpSinPayRespDef.getStat().equals("6")) {
//					payOrder.setTransStatus(TransStatusDef.F);
					cpSinPayRespDef.setTransStat(TransStatusDef.F.toString());
				} else {
//					payOrder.setTransStatus(TransStatusDef.U);
					cpSinPayRespDef.setTransStat(TransStatusDef.U.toString());
				}
			} else {
//				payOrder.setTransStatus(TransStatusDef.F);
				cpSinPayRespDef.setTransStat(TransStatusDef.F.toString());
			}
		} catch (Exception e) {
//			payOrder.setTransStatus(TransStatusDef.Q);
			cpSinPayRespDef.setTransStat(TransStatusDef.Q.toString());
		}
		
		cpSinPayRespDef.setPayOrderNo(payOrderNo);
		
		return cpSinPayRespDef;
	}

	/**
	 * chinapay支付捷 - 单笔代付交易查询 merDate 固定格式'yyyyMMdd'
	 * 
	 * @return
	 */
	public CpSinPayQueryRespDef sinPayQuery(Integer orderNo,String transDate) {
//		CpPayOrder payOrder = em.find(CpPayOrder.class, orderNo);
//		if (payOrder == null) {
//			return null;
//		}
		
		CpSinPayQueryRespDef cpSinPayQueryRespDef = new CpSinPayQueryRespDef();
		CpSinPayQueryReq req = new CpSinPayQueryReq();
		req.setMerId(paramFactory.getMerId());// 固定
		req.setMerDate(transDate);
		req.setMerSeqId(formatOrderNo(orderNo));
		req.setVersion(paramFactory.getSfjSinPayVersion());
		req.setSignFlag("1");// 固定
		CpSinPayQueryResp resp = sendQuerySinPay(paramFactory.getSfjSinPayQueryReqUrl(), req);
		if (resp != null) {
			try {
				BeanUtils.copyProperties(cpSinPayQueryRespDef, resp);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		//订单状态更新
		if(resp.getCode().equals("000")){
			if(resp.getStat().equals("s")){
//				payOrder.setTransStatus(TransStatusDef.S);
			}else if(resp.getStat().equals("6") || resp.getStat().equals("9")){
//				payOrder.setTransStatus(TransStatusDef.F);
			}else{
//				payOrder.setTransStatus(TransStatusDef.U);
			}
		}else if(resp.getCode().equals("001")){
//			logger.info("银联查询无此代付订单，[银联代付订单号={}]", payOrder.getPayOrderNo());
		}else{
			logger.info("银联查询代付订单出错.");
		}
		return cpSinPayQueryRespDef;
	}

	/**
	 * 发报文
	 * 
	 * @param url
	 * @param req
	 * @param orgDataWithChkValueFlag
	 *            验签时原字符串是否包含[chkValue=]
	 * @return
	 */
	private Map<String, String> send(String url, ChinapaySfjReq req, boolean orgDataWithChkValueFlag) {
		// 初始化key文件：
		chinapay.PrivateKey key = new chinapay.PrivateKey();
		boolean flag1;
		String msg;
		// 将要签名的数据传给msg
		msg = req.getString4Chk();
		logger.debug("要签名的数据:" + msg);

		// 对签名的数据进行Base64编码
		String msg1 = "";
		try {
			msg1 = new String(Base64.encode(msg.toString().getBytes(paramFactory.getSfjEncoding())));
		} catch (UnsupportedEncodingException e) {
			logger.error("Base64 encode Error:{}" + e);
		}
		logger.debug("要签名的数据进行Base64编码后为:" + msg1);
		try {
			flag1 = key.buildKey(paramFactory.getMerId(), 0, paramFactory.getMerPrK());
			 logger.debug("merPrk文件绝对路径:{},商户号:{}",paramFactory.getMerPrK(),paramFactory.getMerId());
		} catch (Exception e1) {
			logger.error("build key error!", e1);
			return null;
		}
		if (flag1 == false) {
			logger.error("build key error!--");
			return null;
		}
		
		// 签名
		SecureLink s = new SecureLink(key);

		String chkValue = s.Sign(msg1);

		logger.debug("签名内容:" + chkValue);

		req.setChkValue(chkValue);
		Map<String, String> reqMap = new HashMap<String, String>();
		try {
			// reqMap = BeanUtils.describe(req);
			reqMap = req.convertToMap();
		} catch (Exception e) {
			logger.error("BeanUtils.describe:{}" + e);
		}

		Map<String, String> resmap = submitUrl(reqMap, url, orgDataWithChkValueFlag); // 如果所有字段都出现,用reqMap替换req.convertToMap()

		logger.debug("resmap内容:" + resmap);

		return resmap;
	}

	private CpSinPayQueryResp sendQuerySinPay(String url, ChinapaySfjReq req) {
		// 初始化key文件：
		chinapay.PrivateKey key = new chinapay.PrivateKey();
		boolean flag1;
		String msg;
		// 将要签名的数据传给msg
		msg = req.getString4Chk();
		logger.debug("要签名的数据：" + msg);
		// 对签名的数据进行Base64编码
		String msg1 = "";
		try {
			msg1 = new String(Base64.encode(msg.toString().getBytes(paramFactory.getSfjEncoding())));
		} catch (UnsupportedEncodingException e) {
			logger.error("Base64 encode Error:{}" + e);
		}
		logger.debug("要签名的数据进行Base64编码后为:" + msg1);
		try {
			flag1 = key.buildKey(paramFactory.getMerId(), 0, paramFactory.getMerPrK());
			// logger.info("merPrK文件绝对路径"+merPrK.getFile().getAbsolutePath());
		} catch (Exception e1) {
			logger.error("build key error!", e1);
			return null;
		}
		if (flag1 == false) {
			logger.error("build key error!");
			return null;
		}
		// 签名
		SecureLink s = new SecureLink(key);

		String chkValue = s.Sign(msg1);

		logger.debug("签名内容:" + chkValue);

		req.setChkValue(chkValue);
		Map<String, String> reqMap = new HashMap<String, String>();
		try {
			// reqMap = BeanUtils.describe(req);
			reqMap = req.convertToMap();
		} catch (Exception e) {
			logger.error("BeanUtils.describe:{}" + e);
		}
		CpSinPayQueryResp res = submitUrlQuerySinPay(reqMap, url);
		logger.debug("resmap内容:" + res.toString());
		return res;
	}

	private CpSinCutQueryResp sendQuerySinCut(String url, CpSinCutQueryReq req) {
		// 初始化key文件：
		chinapay.PrivateKey key = new chinapay.PrivateKey();
		boolean flag1;
		String msg;
		// 将要签名的数据传给msg
		msg = req.getString4Chk();
		logger.debug("要签名的数据：" + msg);
		// 对签名的数据进行Base64编码
		String msg1 = "";
		try {
			msg1 = new String(Base64.encode(msg.toString().getBytes(paramFactory.getSfjEncoding())));
		} catch (UnsupportedEncodingException e) {
			logger.error("Base64 encode Error:{}" + e);
		}
		logger.debug("要签名的数据进行Base64编码后为:" + msg1);
		try {
			flag1 = key.buildKey(paramFactory.getMerId(), 0, paramFactory.getMerPrK());
			// logger.info("merPrK据对路径"+merPrK.getFile().getAbsolutePath());
		} catch (Exception e1) {
			logger.error("build key error!", e1);
			return null;
		}
		if (flag1 == false) {
			logger.error("build key error!");
			return null;
		}
		// 签名
		SecureLink s = new SecureLink(key);

		String chkValue = s.Sign(msg1);

		logger.debug("签名内容:" + chkValue);

		req.setChkValue(chkValue);
		Map<String, String> reqMap = new HashMap<String, String>();
		try {
			// reqMap = BeanUtils.describe(req);
			reqMap = req.convertToMap();
		} catch (Exception e) {
			logger.error("BeanUtils.describe:{}" + e);
		}
		CpSinCutQueryResp res = submitUrlQuerySinCut(reqMap, url);
		return res;
	}

	/**
	 * HTTP提交
	 * 
	 * @param submitFromData
	 * @param requestUrl
	 * @param orgDataWithChkValueFlag
	 *            验签是原字符串是否包含[chkValue=]
	 * @return
	 */
	private Map<String, String> submitUrl(Map<String, String> submitFromData, String requestUrl, boolean orgDataWithChkValueFlag) {
		String resultString = "";
		logger.info("requestUrl=[" + requestUrl + "]");
		logger.info("requestMap=[" + submitFromData + "]");
		/**
		 * 发送
		 */
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
		try {
			int status = hc.send(submitFromData, paramFactory.getSfjEncoding());
//			int status = hc.send(submitFromData, "GBK");
			if (200 == status) {
				resultString = hc.getResult();
				logger.info("responseString=[" + resultString + "]");
			}
		} catch (Exception e) {
			logger.error("hc.send err,{}", e);
		}
		Map<String, String> resData = new HashMap<String, String>();
		/**
		 * 验证签名
		 */
		if (null != resultString && !"".equals(resultString)) {
			// 将返回结果转换为map
			resData = ChinapayUtil.convertResultStringToMap(resultString);
			if (sfjValidate(resultString, orgDataWithChkValueFlag)) {
				logger.debug("验证签名成功");
			} else {
				logger.error("验证签名失败,resultString:{}" + resultString);
			}
		}
		return resData;
	}

	private CpSinPayQueryResp submitUrlQuerySinPay(Map<String, String> submitFromData, String requestUrl) {
		CpSinPayQueryResp cpSinPayQueryResp = new CpSinPayQueryResp();
		String resultString = "";
		logger.info("requestUrl=[" + requestUrl + "]");
		logger.info("requestMap=[" + submitFromData + "]");
		/**
		 * 发送
		 */
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
		try {
			int status = hc.send(submitFromData, paramFactory.getSfjEncoding());
			if (200 == status) {
				resultString = hc.getResult();
				logger.info("responseString=[" + resultString + "]");
			}
		} catch (Exception e) {
			logger.error("hc.send err,{}", e);
		}
		/**
		 * 验证签名
		 */
		if (null != resultString && !"".equals(resultString)) {
			// 解析返回结果
			String[] value = resultString.split("\\|");
			cpSinPayQueryResp.setCode(value[0]);
			cpSinPayQueryResp.setMerId(value[1]);
			cpSinPayQueryResp.setMerDate(value[2]);
			cpSinPayQueryResp.setMerSeqId(value[3]);
			cpSinPayQueryResp.setCpDate(value[4]);
			cpSinPayQueryResp.setCpSeqId(value[5]);
			cpSinPayQueryResp.setBankName(value[6]);
			cpSinPayQueryResp.setCardNo(value[7]);
			cpSinPayQueryResp.setUsrName(value[8]);
			cpSinPayQueryResp.setTransAmt(value[9]);
			cpSinPayQueryResp.setFeeAmt(value[10]);
			cpSinPayQueryResp.setProv(value[11]);
			cpSinPayQueryResp.setCity(value[12]);
			cpSinPayQueryResp.setPurpose(value[13]);
			cpSinPayQueryResp.setStat(value[14]);
			cpSinPayQueryResp.setBackDate(value[15]);
			cpSinPayQueryResp.setChkValue(value[16]);

			// 验证签名
			if (queryValidate(resultString)) {
				logger.debug("验证签名成功");
			} else {
				logger.error("验证签名失败,resultString:{}" + resultString);
			}
		}
		return cpSinPayQueryResp;
	}

	private CpSinCutQueryResp submitUrlQuerySinCut(Map<String, String> submitFromData, String requestUrl) {
		CpSinCutQueryResp cpSinCutQueryResp = new CpSinCutQueryResp();
		String resultString = "";
		logger.info("requestUrl=[" + requestUrl + "]");
		logger.info("requestMap=[" + submitFromData + "]");
		Map<String, String> resData = new HashMap<String, String>();
		/**
		 * 发送
		 */
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
		try {
			int status = hc.send(submitFromData, paramFactory.getSfjEncoding());
			if (200 == status) {
				resultString = hc.getResult();
				logger.info("responseString=[" + resultString + "]");
			}
		} catch (Exception e) {
			logger.error("hc.send err,{}", e);
		}
		/**
		 * 验证签名
		 */
		if (null != resultString && !"".equals(resultString)) {
			// 将返回结果转换为map
			resData = ChinapayUtil.convertResultStringToMap(resultString);
			if (sfjValidate(resultString, true)) {
				logger.debug("验证签名成功");
			} else {
				logger.error("验证签名失败,resultString:{}" + resultString);
			}
		}
		// 把map封装到bean里
		try {
			BeanUtils.populate(cpSinCutQueryResp, resData);
		} catch (Exception e) {
			logger.error("BeanUtils.populate:{}" + e);
		}
		return cpSinCutQueryResp;
	}

	/**
	 * 验证签名
	 * 
	 * @param resMes
	 * @param orgDataWithChkValueFlag
	 *            验签是原字符串是否包含[chkValue=]
	 * @return
	 */
	private boolean sfjValidate(String resMes, boolean orgDataWithChkValueFlag) {
		int dex = resMes.lastIndexOf("=");
		String orgStr;
		if (orgDataWithChkValueFlag) { // 代扣交易的验签,结尾包括[&chkValue=],等号后面是空
			orgStr = resMes.substring(0, dex + 1);
		} else { // 代付交易的验签，不包含结尾的[&chkValue=......]
			int dex2 = resMes.lastIndexOf("&");
			orgStr = resMes.substring(0, dex2);
		}

		String strBase64 = "";
		try {
			strBase64 = new String(Base64.encode(orgStr.getBytes(paramFactory.getSfjEncoding())));
		} catch (UnsupportedEncodingException e) {
			logger.info("(Base64 encode Error:{}" + e);
		}

		// 对收到的ChinaPay应答传回的域段进行验签
		boolean buildOK = false;
		boolean res = false;
		int KeyUsage = 0;
		PrivateKey key = new PrivateKey();
		try {
			buildOK = key.buildKey(paramFactory.getPubId(), KeyUsage, paramFactory.getPgPubk());
			// logger.info("pgPubk文件绝对路径"+pgPubk.getFile().getAbsolutePath());
		} catch (Exception e) {
			logger.info("bulidKey Error:{}" + e);
		}
		if (!buildOK) {
			// errorList.add("build error!");
			logger.info("bulidKey Error");
			return false;
		}
		// if (!errorList.isEmpty()) {
		// request.setAttribute("errors", errorList);
		// return;
		// }

		SecureLink sl = new SecureLink(key);
		String chkValue = resMes.substring(dex + 1);
		res = sl.verifyAuthToken(strBase64, chkValue);
		return res;
	}

	private boolean queryValidate(String resMes) {
		int index = resMes.lastIndexOf("|");
		String orgStr = resMes.substring(0, index + 1);

		String strBase64 = "";
		try {
			strBase64 = new String(Base64.encode(orgStr.getBytes(paramFactory.getSfjEncoding())));
		} catch (UnsupportedEncodingException e) {
			logger.info("(Base64 encode Error:{}" + e);
		}

		// 对收到的ChinaPay应答传回的域段进行验签
		boolean buildOK = false;
		boolean res = false;
		int KeyUsage = 0;
		PrivateKey key = new PrivateKey();
		try {
			buildOK = key.buildKey(paramFactory.getPubId(), KeyUsage, paramFactory.getPgPubk());
			// logger.info("pgPubk文件绝对路径"+pgPubk.getFile().getAbsolutePath());
		} catch (Exception e) {
			logger.info("bulidKey Error:{}" + e);
		}
		if (!buildOK) {
			// errorList.add("build error!");
			logger.info("bulidKey Error");
			return false;
		}
		// if (!errorList.isEmpty()) {
		// request.setAttribute("errors", errorList);
		// return;
		// }

		SecureLink sl = new SecureLink(key);
		String chkValue = resMes.substring(index + 1);
		res = sl.verifyAuthToken(strBase64, chkValue);
		return res;
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

	public ChinaPayParamFactory getParamFactory() {
		return paramFactory;
	}

	public void setParamFactory(ChinaPayParamFactory paramFactory) {
		this.paramFactory = paramFactory;
	}
	
	public static void main(String[] args) {
		// 初始化key文件：
		chinapay.PrivateKey key = new chinapay.PrivateKey();
		boolean flag1;
		flag1 = key.buildKey("808080211389035", 0, "E:\\mywork\\kelanwork1\\1.0.0\\core\\core-cashier\\src\\main\\resources\\china-pay-key\\MerPrK_808080211389035_20150228173140.key");
		System.out.println(flag1);
//		ChinapayTxnServiceImpl chinapayTxnServiceImpl = new ChinapayTxnServiceImpl();
//		chinapayTxnServiceImpl.submitUrl(null, "http://sfj-test.chinapay.com/dac/SinCutServletGBK", true);
		String resultString = null;
		HttpClient hc = new HttpClient("http://sfj-test.chinapay.com/dac/SinCutServletGBK", 30000, 30000);
		try {
			int status = hc.send(null, "GBK");
//			int status = hc.send(submitFromData, "GBK");
			if (200 == status) {
				resultString = hc.getResult();
				System.out.println("responseString=[" + resultString + "]");
			}
		} catch (Exception e) {
//			logger.error("hc.send err,{}", e);
			e.printStackTrace();
		}
	}

}
