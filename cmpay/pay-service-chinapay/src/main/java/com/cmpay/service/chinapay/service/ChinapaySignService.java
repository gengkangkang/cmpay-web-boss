package com.cmpay.service.chinapay.service;

import com.cmpay.service.chinapay.model.CpAuthBgRespDef;
import com.cmpay.service.chinapay.model.IdType;
import com.cmpay.service.chinapay.model.SignCardTypeDef;

/**
 * 银联认证交易
 * 
 * @author zy
 *
 */
public interface ChinapaySignService {

	/**
	 * 银联后台认证
	 * 
	 * @param cardNo
	 * @param idNo
	 * @param cardType
	 * @param custName
	 * @return
	 * @throws Exception
	 */
	public CpAuthBgRespDef bgAuth(String cardNo, IdType idType, String idNo,
			SignCardTypeDef cardType, String custName, String cardPhone)
			throws Exception;

}
