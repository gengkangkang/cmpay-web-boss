package org.pay.service.jytpay.service;

import org.pay.service.jytpay.model.CpJYTRespDef;

public interface JinYuntongPayService {
	/**
	 *  - 单笔代手交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef setCollection(String bankName,String accountNo,String accountName,String accountType,String brachBankProvince,String brachBankCity,
			String brachBankName,String tranAmt,String currency,String bsnCode,String certType,String certNo,String mobile,String remark,String transId,String custId,String orderId,String payChanndelCode);
	
	/**
	 *  - 查询单笔代收交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef queryCollection(String ori_tran_flowid,String payChanndelCode);
	
	/**
	 *  - 单笔代付交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef setPayment(String bankName,String accountNo,String accountName,String accountType,String brach_bank_province,String brach_bank_city,
			String brach_bank_name,String tran_amt,String currency,String bsn_code,String cert_type,String cert_no,String mobile,String remark,String trans_id,String cust_id,String order_id,String sinpayChanndelCode);
	
	/**
	 *  - 查询单笔代付交易 
	 * @param transInf
	 * @return
	 */
	public CpJYTRespDef queryPayment(String oriTranFlowId,String sinpayChanndelCode);
	
	/**
	 * 金运通四要素后台认证
	 * 
	 * @param bankCardNo
	 * @param bankCode
	 * @param idNum
	 * @param id_name
	 * @param terminal_type 认证请求终端类型 商户使用验证接口的终端类型：01 APP，02 WAP，03 WEB，04 SIM卡，05 VI-POS，06 SD卡
	 * @param bank_card_type
	 * @param phone_no
	 * @return
	 * @throws Exception
	 */
	public CpJYTRespDef JYTAuth(String bankCardNo, String bankCode,
    		String idNum, String idName, String terminalType, String bankCardType, String phoneNo);
}
