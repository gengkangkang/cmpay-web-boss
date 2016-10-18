package com.cmpay.service.chinapay.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpay.service.chinapay.model.CpAuthBgRespDef;
import com.cmpay.service.chinapay.model.IdType;
import com.cmpay.service.chinapay.model.SignCardTypeDef;
import com.cmpay.service.chinapay.service.ChinapaySignService;
import com.cmpay.service.chinapay.util.ChinapayUtil;
import com.cmpay.service.chinapay.util.CpAuthSignUtil;
import com.cmpay.service.chinapay.util.HttpClient;

/**
 * 签约交易
 * 
 * @author shenxw
 */
@Service
@Transactional
public class ChinapaySignServiceImpl implements ChinapaySignService {

	// public static String encoding = "UTF-8";

	private ChinaPayParamFactory paramFactory;

	private Logger logger = LoggerFactory.getLogger(getClass());

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
	public CpAuthBgRespDef bgAuth(String cardNo, IdType idType, String idNo, SignCardTypeDef cardType, String custName, String cardPhone) {
		CpAuthBgRespDef authBgRespDef = new CpAuthBgRespDef();
		Map<String, String> paramMap = new HashMap<String, String>();
		// 系统编号
		paramMap.put("appSysId", paramFactory.getAppSysId());
		// paramMap.put("serviceType", "1028"); // shenxw 该字段没有在接口文档里
		paramMap.put("signMethod", "MD5");
		paramMap.put("save", "false");
		paramMap.put("cardNo", cardNo);
		String cpIdType = getCpIdType(idType);
		paramMap.put("certType", cpIdType);
		paramMap.put("certNo", idNo);
		paramMap.put("usrName", custName);
		paramMap.put("cardPhone", cardPhone);

		// FIXME:Tiger
		String dcType = "";
		if (SignCardTypeDef.DEBIT == cardType) {
			dcType = "0";
		} else if (SignCardTypeDef.CREDIT == cardType) {
			dcType = "1";
		}
		paramMap.put("dcType", dcType);

		// 不参与签名的参数
		Set<String> removeKey = new HashSet<String>();
		removeKey.add("signMethod");
		removeKey.add("signature");
		String signedMsg = CpAuthSignUtil.getURLParam(paramMap, true, removeKey);
		// 测试密钥88888888
		paramMap.put("signature", CpAuthSignUtil.sign(signedMsg, paramFactory.getAuthPrivateKey()));

		// String usrName = (String) paramMap.get("usrName");

		logger.info("请求信息Map:{}" + paramMap);
		Map<String, String> resMap = submitUrl(paramMap, paramFactory.getBackgroudAuthReqUrl());
		logger.info("返回信息Map:" + resMap);

		String signedMsgResp = CpAuthSignUtil.getURLParam(resMap, true, removeKey);
		// 测试密钥88888888
		String verify = CpAuthSignUtil.sign(signedMsgResp, paramFactory.getAuthPrivateKey());
		if (verify.equalsIgnoreCase((String) resMap.get("signature"))) {
			logger.info("验签通过");
			authBgRespDef.setSignVerified(true);
		} else {
			logger.error("验签失败");
			authBgRespDef.setSignVerified(false);
		}
		if ("0000".equals((String) resMap.get("respcode"))) {
			logger.info("认证成功");
		} else {
			logger.info("认证失败; respcode:{}; respmsg:{}", resMap.get("respcode"), resMap.get("respmsg"));
		}
		
		authBgRespDef.setRespCode(resMap.get("respcode"));
		authBgRespDef.setRespMsg(resMap.get("respmsg"));
		
		return authBgRespDef;
	}

	/**
	 * 映射到银联代扣的证件类型编号[ 01:身份证; 02:军官证; 03:护照; 04:回乡证; 05:台胞证; 06:警官证; 07:士兵证;
	 * 99:其他证件; ]
	 * 
	 * @param idType
	 * @return
	 */
	private String getCpIdType(IdType idType) {
		String cpIdType = "01";
		if (IdType.I == idType) {
			cpIdType = "01";
		} else if (IdType.B == idType) {
			cpIdType = "02";
		} else if (IdType.P == idType) {
			cpIdType = "03";
		} else if (IdType.H == idType) {
			cpIdType = "04";
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

	private Map<String, String> submitUrl(Map<String, String> submitFromData, String requestUrl) {
		String resultString = "";
		logger.info("requestUrl=[{}]", requestUrl);
		/**
		 * 发送
		 */
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
		try {
			int status = hc.send(submitFromData, paramFactory.getAuthEncoding());
			if (200 == status) {
				resultString = hc.getResult();
			}
			logger.info("resultString=[{}]", resultString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> resData = new HashMap<String, String>();

		if (null != resultString && !"".equals(resultString)) {
			// 将返回结果转换为map
			resData = ChinapayUtil.convertResultStringToMap(resultString);

		}
		return resData;
	}

	public ChinaPayParamFactory getParamFactory() {
		return paramFactory;
	}

	public void setParamFactory(ChinaPayParamFactory paramFactory) {
		this.paramFactory = paramFactory;
	}

}
