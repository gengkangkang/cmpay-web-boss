package com.cmpay.service.llpay.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cmpay.service.llpay.conn.HttpRequestSimplePay;
import com.cmpay.service.llpay.model.CashBean;
import com.cmpay.service.llpay.model.CashQueryReqBean;
import com.cmpay.service.llpay.model.CashQueryResBean;
import com.cmpay.service.llpay.model.RetBean;
import com.cmpay.service.llpay.utils.LLPayUtil;
import com.cmpay.service.llpay.utils.Md5Algorithm;
import com.cmpay.service.llpay.utils.TraderRSAUtil;

/**
 * 连连代付的service
 * 
 * @author zy
 * 
 */
@Service
@Transactional
public class LlPaySinPayService {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	@PersistenceContext
//	private EntityManager em;

	private LlPaySinpayParamFactory paramFactory;
	
//	@Autowired
//	private SystemStatusFacility systemStatusFacility;

	public LlPaySinpayParamFactory getParamFactory() {
		return paramFactory;
	}

	public void setParamFactory(LlPaySinpayParamFactory paramFactory) {
		this.paramFactory = paramFactory;
	}

	/**
	 * 连连代付
	 * 
	 * @return
	 */
	public CashBean cashPay(String payOrderNo,String uPayOrderNo, String custId, String custName, String cardNo, String bankCode, String orderDt, String cityCode, String brabankName, String orderMoney,
			String orderInfo, String provinceCode) {
		// 登记代付记录
//		LlPayOrder payOrder = new LlPayOrder();
//		payOrder.setProcDate(systemStatusFacility.getSystemStatus().businessDate);
//		// 暂时默认不收手续费，为0
//		payOrder.setProcedureFee(BigDecimal.valueOf(0));
//		payOrder.setUpayOrderNo(uPayOrderNo);
//		payOrder.setTransDate(orderDt.substring(0, 8));
//		payOrder.setCreateDate(new Date());
//		BigDecimal amount = new BigDecimal(orderMoney);
//		payOrder.setMoneyOrder(amount);
//		payOrder.setTransStatus(TransStatusDef.U);
//		payOrder.setCustId(custId);
//		payOrder.setApiVersion(paramFactory.getPayApiVersion());
//		payOrder.setOidPartner(paramFactory.getPayOidPartner());
//		payOrder.setSignType(paramFactory.getPaySignType());
//		payOrder.setAcctName(custName);
//		payOrder.setCardNo(cardNo);
//		payOrder.setBankCode(bankCode);
//		payOrder.setDtOrder(orderDt);
//		payOrder.setProvinceCode(provinceCode);
//		payOrder.setCityCode(cityCode);
//		payOrder.setBrabankName(brabankName);
//		payOrder.setFlagCard(paramFactory.getPayFlagCard());
//		payOrder.setInfoOrder(orderInfo);
//		payOrder.setNotifyUrl(paramFactory.getPayNotifyUrl());
//		em.persist(payOrder);

		// 封装代付请求对象
		String orderNo = payOrderNo;
		CashBean reqBean = new CashBean();
		reqBean.setApi_version(paramFactory.getPayApiVersion());
		reqBean.setOid_partner(paramFactory.getPayOidPartner());
		reqBean.setSign_type(paramFactory.getPaySignType());
		reqBean.setUser_id(custId);
		reqBean.setAcct_name(custName);
		reqBean.setCard_no(cardNo);
		// 对公bank_code 必传
		if (bankCode != null)
			reqBean.setBank_code(bankCode);
		reqBean.setNo_order(orderNo);
		// 格式：YYYYMMDDH24MISS 14 位数字，精确到秒
		reqBean.setDt_order(orderDt);
		// 标准省份编码 工、农、中, 招,光大浦发（对私打款），建行（对公打款）可以不传, 其他银行必须传
		if (provinceCode != null)
			reqBean.setProvince_code(provinceCode);
		// 标准地市编码 杭州：330100 ,工、农、中, 招,光大浦发（对私打款），建行（对公打款）可以不传, 其他银行必须传
		if (cityCode != null)
			reqBean.setCity_code(cityCode);
		// 工、农、中, 招,光大浦发（对私打款），建行（对公打款）可以不传, 其他银行必须传
		if (brabankName != null)
			reqBean.setBrabank_name(brabankName);
		reqBean.setMoney_order(orderMoney);
		reqBean.setFlag_card(paramFactory.getPayFlagCard());
		// 代付的原因
		reqBean.setInfo_order(orderInfo);
		reqBean.setNotify_url(paramFactory.getPayNotifyUrl());
		String sign = genSign(JSON.parseObject(JSON.toJSONString(reqBean)));
		reqBean.setSign(sign);
//		payOrder.setSign(sign);
		String reqJson = JSON.toJSONString(reqBean);
		logger.info("代付请求:{}", reqJson);
		String resJson = null;
		CashBean cashBean = null;
		HttpRequestSimplePay httpclent = new HttpRequestSimplePay();
		try {
			resJson = httpclent.postSendHttp(paramFactory.getServerPay(), reqJson);
			logger.info("代付请求结果报文:{}", resJson);
			cashBean = JSON.parseObject(resJson, CashBean.class);
			// 更新订单结果(此时为同步更新，异步也可以更新)
//			payOrder.setTransRetCode(cashBean.getRet_code());
			if (cashBean.getRet_code().equals("0000") || cashBean.getRet_code().equals("2008") ||cashBean.getRet_code().equals("9970")
					||cashBean.getRet_code().equals("2004")) {// 0000为成功，只是交易成功，具体支付结果不知道，所以订单状态得是由异步通知和主动查询为准
//				payOrder.setTransStatus(TransStatusDef.U);
			} else {
//				payOrder.setTransStatus(TransStatusDef.F);
			}
		} catch (Exception e) {
			logger.error("连连代付请求异常:{}", e);
			//自定义错误响应码，代表交易出现异常,订单状态为处理中,具体结果交由轮询处理
			cashBean.setRet_code("99");
//			payOrder.setTransStatus(TransStatusDef.U);
		}
		return cashBean;
	}

	/**
	 * 代付结果查询
	 * 
	 * @return
	 */
	public CashQueryResBean cashOrderQuery(String orderNo, String typeDc) {
		// 封装查询结果对象
		CashQueryReqBean reqBean = new CashQueryReqBean();
		reqBean.setOid_partner(paramFactory.getPayOidPartner());
		reqBean.setSign_type(paramFactory.getPaySignType());
		reqBean.setNo_order(orderNo);
		// 收付类型，标志交易收付款方类型 0：商户收款（单业务等）1：商户付款（商户提现、批付提现、批付业务等）代付查询传1
		reqBean.setType_dc(typeDc);
		reqBean.setSign(genSign(JSON.parseObject(JSON.toJSONString(reqBean))));
		String reqJson = JSON.toJSONString(reqBean);
		logger.info("代付查询请求:{}", reqJson);
		String resJson = null;
		HttpRequestSimplePay httpclent = new HttpRequestSimplePay();
		try {
			resJson = httpclent.postSendHttp(paramFactory.getPayQueryUrl(), reqJson);
		} catch (Exception e) {
			logger.error("连连代付请求异常:{}", e);
		}
		logger.info("代付查询请求结果报文:{}", resJson);
		CashQueryResBean cashQueryResBean = JSON.parseObject(resJson, CashQueryResBean.class);
		// 订单状态更新
		if (cashQueryResBean.getRet_code().equals("0000")) {
//			LlPayOrder payOrder = em.find(LlPayOrder.class, Integer.valueOf(cashQueryResBean.getNo_order()));
//			if (payOrder != null) {
//				payOrder.setQueryRetCode(cashQueryResBean.getRet_code());
//				payOrder.setOidPaybill(cashQueryResBean.getOid_paybill());
//				payOrder.setResultPay(cashQueryResBean.getResult_pay());
//				payOrder.setSettleDate(cashQueryResBean.getSettle_date());
				if (cashQueryResBean.getResult_pay().equals("SUCCESS")) {// 代付成功
//					payOrder.setTransStatus(TransStatusDef.S);
				} else if (cashQueryResBean.getResult_pay().equals("PROCESSING")) {// 银行代付处理中
//					payOrder.setTransStatus(TransStatusDef.U);
				} else if (cashQueryResBean.getResult_pay().equals("WAITING")) {// 等待支付
//					payOrder.setTransStatus(TransStatusDef.U);
				} else if (cashQueryResBean.getResult_pay().equals("FAILURE")) {// 代付失败
//					payOrder.setTransStatus(TransStatusDef.F);
				} else if (cashQueryResBean.getResult_pay().equals("REFUND")) {// 代付退款
//					payOrder.setTransStatus(TransStatusDef.F);
				}
//			}
		}
		return cashQueryResBean;
	}

	/**
	 * 代付结果异步响应通知
	 * 
	 * @param reqStr
	 * @return
	 */
	public RetBean cashOnNotify(String reqStr) {
		RetBean retBean = new RetBean();
		if (LLPayUtil.isnull(reqStr)) {
			retBean.setRet_code("9999");
			retBean.setRet_msg("交易失败");
			return retBean;
		}
		logger.info("接收代付异步通知数据：【" + reqStr + "】");
		try {
			if (!LLPayUtil.checkSign(reqStr, paramFactory.getPayYtPubKey(), paramFactory.getTraderMd5key())) {
				retBean.setRet_code("9999");
				retBean.setRet_msg("交易失败");
				logger.info("支付异步通知验签失败");
				return retBean;
			}
		} catch (Exception e) {
			logger.error("代付异步通知报文解析异常,{}", e);
			retBean.setRet_code("9999");
			retBean.setRet_msg("交易失败");
			return retBean;
		}

		retBean.setRet_code("0000");
		retBean.setRet_msg("交易成功");
		// 解析代付异步通知对象
		CashQueryResBean cashQueryResBean = JSON.parseObject(reqStr, CashQueryResBean.class);
		// 更新订单状态
		String orderNo = cashQueryResBean.getNo_order();
		String result_pay = cashQueryResBean.getResult_pay();
//		LlPayOrder payOrder = em.find(LlPayOrder.class, Integer.valueOf(orderNo));
//		payOrder.setOidPaybill(cashQueryResBean.getOid_paybill());
//		payOrder.setResultPay(cashQueryResBean.getResult_pay());
//		payOrder.setSettleDate(cashQueryResBean.getSettle_date());//yyyyMMdd
		if (result_pay.equals("SUCCESS")) {// 代付成功
//			payOrder.setTransStatus(TransStatusDef.S);
		} else if (result_pay.equals("FAILURE")) {// 代付失败
//			payOrder.setTransStatus(TransStatusDef.F);
		} else if (result_pay.equals("REFUND")) {// 代付退款
//			payOrder.setTransStatus(TransStatusDef.F);
		}
		retBean.setAmt(cashQueryResBean.getMoney_order());
//		retBean.setuOrderNo(payOrder.getUpayOrderNo());
		retBean.setResultPay(result_pay);
		// channel在核心那边通过coretransid可查到
		return retBean;
	}

	private String genSign(JSONObject reqObj) {
		// String sign = reqObj.getString("sign");
		String sign_type = reqObj.getString("sign_type");
		// // 生成待签名串
		String sign_src = genSignData(reqObj);
		logger.info("商户[" + reqObj.getString("oid_partner") + "]待签名原串" + sign_src);
		if ("MD5".equals(sign_type)) {
			sign_src += "&key=" + paramFactory.getTraderMd5key();
			return signMD5(sign_src);
		}
		if ("RSA".equals(sign_type)) {
			return getSignRSA(sign_src);
		}
		return null;
	}

	/**
	 * 生成待签名串
	 * 
	 * @param paramMap
	 * @return
	 */
	public String genSignData(JSONObject jsonObject) {
		StringBuffer content = new StringBuffer();

		// 按照key做首字母升序排列
		List<String> keys = new ArrayList<String>(jsonObject.keySet());
		Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			// sign 和ip_client 不参与签名
			if ("sign".equals(key)) {
				continue;
			}
			String value = (String) jsonObject.getString(key);
			// 空串不参与签名
			if (null == value) {
				continue;
			}
			content.append((i == 0 ? "" : "&") + key + "=" + value);

		}
		String signSrc = content.toString();
		if (signSrc.startsWith("&")) {
			signSrc = signSrc.replaceFirst("&", "");
		}
		return signSrc;
	}

	/**
	 * md5加密
	 * 
	 * @param signSrc
	 * @return
	 */
	private String signMD5(String signSrc) {

		try {
			return Md5Algorithm.getInstance().md5Digest(signSrc.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * RSA签名验证
	 * 
	 * @param reqObj
	 * @return
	 */
	public String getSignRSA(String sign_src) {
		return TraderRSAUtil.sign(paramFactory.getTraderRsaPrikey(), sign_src);

	}

}
