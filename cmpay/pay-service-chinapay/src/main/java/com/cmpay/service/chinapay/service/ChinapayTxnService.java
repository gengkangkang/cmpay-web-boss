package com.cmpay.service.chinapay.service;

import java.math.BigDecimal;

import com.cmpay.service.chinapay.model.CpSinCutQueryRespDef;
import com.cmpay.service.chinapay.model.CpSinCutRespDef;
import com.cmpay.service.chinapay.model.CpSinPayQueryRespDef;
import com.cmpay.service.chinapay.model.CpSinPayRespDef;

public interface ChinapayTxnService {

	/**
	 * chinapay支付捷 - 单笔代扣交易
	 * 
	 * @param transInf
	 * @return
	 */
	public CpSinCutRespDef sinCut(Integer cutOrderNo,String transId, String cardNo, String custId, String bankId, BigDecimal transAmt, String custName, String idNo, String description);

	/**
	 * chinapay支付捷 - 单笔代扣交易查询 transDate 固定格式'yyyyMMdd'
	 * 
	 * @return
	 */
	public CpSinCutQueryRespDef sinCutQuery(Integer orderNo,String transDate);

	/**
	 * chinapay支付捷 - 单笔代付交易 ResponseCode : 0000-成功
	 * 
	 * @param transInf
	 * @return
	 */
	public CpSinPayRespDef sinPay(Integer payOrderNo,String transId, String cardNo, String custId, String bankId, BigDecimal transAmt, String purpose, String custName, String province, String city, String subBank);

	/**
	 * chinapay支付捷 - 单笔代付交易查询 merDate 固定格式'yyyyMMdd'
	 * 
	 * @return
	 */
	public CpSinPayQueryRespDef sinPayQuery(Integer orderNo,String transDate);

}
