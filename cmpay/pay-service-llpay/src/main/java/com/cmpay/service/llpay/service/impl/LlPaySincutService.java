package com.cmpay.service.llpay.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cmpay.service.llpay.conn.HttpRequestSimplePay;
import com.cmpay.service.llpay.model.OrderInfo;
import com.cmpay.service.llpay.model.PayDataBean;
import com.cmpay.service.llpay.model.PayQueryReqBean;
import com.cmpay.service.llpay.model.PayQueryResBean;
import com.cmpay.service.llpay.model.PaymentInfo;
import com.cmpay.service.llpay.model.RetBean;
import com.cmpay.service.llpay.utils.LLPayUtil;

/**
 * 连连网关支付的service
 * 
 * @author zy
 * 
 */
@Service
@Transactional
public class LlPaySincutService {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	@PersistenceContext
//	private EntityManager em;
//	
//	@Autowired
//	private SystemStatusFacility systemStatusFacility;

	private LlPaySincutParamFactory paramFactory;

	public LlPaySincutParamFactory getParamFactory() {
		return paramFactory;
	}

	public void setParamFactory(LlPaySincutParamFactory paramFactory) {
		this.paramFactory = paramFactory;
	}

	/**
	 * 普通支付处理
	 * 
	 * @param req
	 * @param order
	 */
	public PaymentInfo plainPay(String orderNo,OrderInfo order, String ucutOrderNo, String userId, String userReqIp, String idNo, String acctName, String urlReturn, String userDtregister,String bankCode) {
		// 登记支付记录
//		LlCutOrder cutOrder = new LlCutOrder();
//		cutOrder.setProcDate(systemStatusFacility.getSystemStatus().businessDate);
//		cutOrder.setProcedureFee(BigDecimal.valueOf(0));
//		cutOrder.setUcutOrderNo(ucutOrderNo);
//		cutOrder.setTransDate(order.getDt_order().substring(0, 8));
//		cutOrder.setCrateDate(new Date());
//		BigDecimal amount = new BigDecimal(order.getMoney_order());
//		cutOrder.setMoneyOrder(amount);
//		cutOrder.setTransStatus(TransStatusDef.U);
//		cutOrder.setCustId(userId);
//		cutOrder.setVersion(paramFactory.getVersion());
//		cutOrder.setOidPartner(paramFactory.getOidPartner());
//		cutOrder.setSignType(paramFactory.getSignType());
//		cutOrder.setDtOrder(order.getDt_order());
//		cutOrder.setNameGoods(order.getName_goods());
//		cutOrder.setInfoOrder(order.getInfo_order());
//		cutOrder.setNotifyUrl(paramFactory.getNotifyUrl());
//		cutOrder.setUrlReturn(urlReturn);
//		cutOrder.setUserreqIp(userReqIp.replaceAll("\\.", "_"));
//		cutOrder.setUrlOrder("");
//		cutOrder.setValidOrder(paramFactory.getOrderValid());//订单时效，单位分钟
		String timeStamp = LLPayUtil.getCurrentDateTimeStr();
//		cutOrder.setTimeStamp(timeStamp);
		String riskItem = createRiskItem(acctName, userId, userDtregister, idNo);
//		cutOrder.setRiskItem(riskItem);
//		cutOrder.setIdType("0");
//		cutOrder.setIdNo(idNo);
//		cutOrder.setAcctName(acctName);
//		cutOrder.setFlagModify("1");
//		cutOrder.setBankCode(bankCode);//传入此字段，说明是网银支付
//		cutOrder.setBusiPartner(paramFactory.getBusiPartner());
//		em.persist(cutOrder);
		// 封装支付请求
//		String orderNo = String.valueOf(cutOrder.getCutOrderNo());

		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setVersion(paramFactory.getVersion());
		paymentInfo.setOid_partner(paramFactory.getOidPartner());
		paymentInfo.setUser_id(userId);
		paymentInfo.setSign_type(paramFactory.getSignType());
		paymentInfo.setBusi_partner(paramFactory.getBusiPartner());
		paymentInfo.setNo_order(orderNo);
		paymentInfo.setDt_order(order.getDt_order());
		paymentInfo.setName_goods(order.getName_goods());
		paymentInfo.setInfo_order(order.getInfo_order());
		paymentInfo.setMoney_order(order.getMoney_order());
		paymentInfo.setNotify_url(paramFactory.getNotifyUrl());
		paymentInfo.setUrl_return(urlReturn);
		paymentInfo.setUserreq_ip(userReqIp.replaceAll("\\.", "_"));
		paymentInfo.setUrl_order("");
		paymentInfo.setValid_order(paramFactory.getOrderValid());// 单位分钟，可以为空，默认7天
		paymentInfo.setTimestamp(timeStamp);
		paymentInfo.setRisk_item(riskItem);
		//TODO 连连网银测试
		paymentInfo.setId_type("0");
		paymentInfo.setId_no(idNo);
		paymentInfo.setAcct_name(acctName);
		paymentInfo.setFlag_modify("1");
		paymentInfo.setBank_code(bankCode);
		
		// 加签名
		String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(paymentInfo)), paramFactory.getTraderPriKey(), paramFactory.getMd5Key());
		paymentInfo.setSign(sign);
//		cutOrder.setSign(sign);
		return paymentInfo;
	}
	
	public PayQueryResBean payOrderQuery(String orderNo,String orderDt){
		//封装查询对象
		PayQueryReqBean payQueryReqBean = new PayQueryReqBean();
		payQueryReqBean.setOid_partner(paramFactory.getOidPartner());
		payQueryReqBean.setSign_type(paramFactory.getSignType());
		payQueryReqBean.setNo_order(orderNo);
		payQueryReqBean.setDt_order(orderDt);//：YYYYMMDDH24MISS
		
		//加签名
		String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(payQueryReqBean)), paramFactory.getTraderPriKey(), paramFactory.getMd5Key());
		payQueryReqBean.setSign(sign);
		String reqJson = JSON.toJSONString(payQueryReqBean);
		logger.info("连连代扣查询请求：{}",reqJson);
		//发送请求
		String resJson = null;
		HttpRequestSimplePay httpclent = new HttpRequestSimplePay();
		try {
			resJson = httpclent.postSendHttp(paramFactory.getOrderQueryUrl(), reqJson);
		} catch (Exception e) {
			logger.error("连连代付请求异常:{}", e);
		}
		logger.info("连连代扣查询结果报文:{}",resJson);
		PayQueryResBean resBean = JSON.parseObject(resJson, PayQueryResBean.class);
		//订单状态更新
		if(resBean.getRet_code().equals("0000")){//交易成功
//			LlCutOrder cutOrder = em.find(LlCutOrder.class, Integer.valueOf(resBean.getNo_order()));
//			if(cutOrder != null){
//				cutOrder.setOidPaybill(resBean.getOid_paybill());
//				cutOrder.setResultPay(resBean.getResult_pay());
//				cutOrder.setSettleDate(resBean.getSettle_date());
				if(resBean.getResult_pay().equals("SUCCESS")){//成功
//					cutOrder.setTransStatus(TransStatusDef.S);
				}else if(resBean.getResult_pay().equals("WAITING")){//等待支付
//					cutOrder.setTransStatus(TransStatusDef.U);
				}else if(resBean.getResult_pay().equals("PROCESSING")){//银行支付处理中 
//					cutOrder.setTransStatus(TransStatusDef.U);
				}else if(resBean.getResult_pay().equals("REFUND")){//退款 
//					cutOrder.setTransStatus(TransStatusDef.F);
				}else if(resBean.getResult_pay().equals("FAILURE")){//失败
//					cutOrder.setTransStatus(TransStatusDef.F);
				}
//			}
		}
		return resBean;
	}

	/**
	 * 根据连连支付风控部门要求的参数进行构造风控参数
	 * 
	 * @return
	 */
	private String createRiskItem(String userFullname, String userId, String userDtregister, String idNo) {
		JSONObject riskItemObj = new JSONObject();
		riskItemObj.put("user_info_full_name", userFullname);
		riskItemObj.put("user_info_mercht_userno", userId);
		riskItemObj.put("user_info_dt_register", userDtregister);
		riskItemObj.put("user_info_id_no", idNo);
		riskItemObj.put("user_info_identify_state", "1");
		riskItemObj.put("user_info_identify_type", "1");
		riskItemObj.put("frms_ware_category", "2009");
		return riskItemObj.toString();
	}

	/**
	 * 支付结果异步通知接收服务
	 * 
	 * @param req
	 * @return
	 */
	public RetBean onNotify(String reqStr) {
		RetBean retBean = new RetBean();
		if (LLPayUtil.isnull(reqStr)) {
			retBean.setRet_code("9999");
			retBean.setRet_msg("交易失败");
			return retBean;
		}
		logger.info("接收支付异步通知数据：【" + reqStr + "】");
		try {
			if (!LLPayUtil.checkSign(reqStr, paramFactory.getyTPubKey(), paramFactory.getMd5Key())) {
				retBean.setRet_code("9999");
				retBean.setRet_msg("交易失败");
				logger.info("支付异步通知验签失败");
				return retBean;
			}
		} catch (Exception e) {
			logger.error("异步通知报文解析异常,{}", e);
			retBean.setRet_code("9999");
			retBean.setRet_msg("交易失败");
			return retBean;
		}
		retBean.setRet_code("0000");
		retBean.setRet_msg("交易成功");
		// 解析异步通知对象
		PayDataBean payDataBean = JSON.parseObject(reqStr, PayDataBean.class);
		String orderNo = payDataBean.getNo_order();
		String result_pay = payDataBean.getResult_pay();
		// 更新订单状态
//		LlCutOrder cutOrder = em.find(LlCutOrder.class, Integer.valueOf(orderNo));
//		cutOrder.setOidPaybill(payDataBean.getOid_paybill());
//		cutOrder.setResultPay(payDataBean.getResult_pay());
//		cutOrder.setSettleDate(payDataBean.getSettle_date());
		if (result_pay.equals("SUCCESS")) {
//			cutOrder.setTransStatus(TransStatusDef.S);
		} else if (result_pay.equals("FAILURE")) {
//			cutOrder.setTransStatus(TransStatusDef.F);
		} else if (result_pay.equals("PROCESSING")) {// 支付处理中
//			cutOrder.setTransStatus(TransStatusDef.U);
		} else {// 已退款
//			cutOrder.setTransStatus(TransStatusDef.F);
		}
		retBean.setAmt(payDataBean.getMoney_order());
//		retBean.setuOrderNo(cutOrder.getUcutOrderNo());UcutOrderNo???
		retBean.setResultPay(result_pay);
		// channel在核心那边通过coretransid可查到
		return retBean;
	}

}
