package com.cmpay.gateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.cmpay.common.security.util.DESHelper;
import com.cmpay.common.security.util.RSAHelper;

/**
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月27日 下午2:22:54
 *
 */
public class BaseAction {

	private Logger logger = Logger.getLogger(this.getClass());
	private RSAHelper rsaHelper;

	@Value("#{env['PrivateKEY']}")
	private String PrivateKEY;

	@Value("#{env['PublicKEY']}")
	private String PublicKEY;

	@Value("#{env['pfxPasswd']}")
	private String pfxPasswd;

	@Value("#{env['capath']}")
	private String capath;

	@PostConstruct
	public void initRZRsaHelper() {
		rsaHelper = new RSAHelper();
		logger.info("统一支付平台初始化秘钥===================");
		try {
				rsaHelper.initKey(capath+PrivateKEY, pfxPasswd, capath+PublicKEY);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	//加密报文
	public String encMsg(Object obj){

		String result=null;

		try {
			String encMsg=JSON.toJSONString(obj);

			byte[] des_key = DESHelper.generateDesKey() ;
	        String encBase64=DESHelper.desEncryptToBase64(encMsg, des_key);

	         byte[] enc_key = rsaHelper.encryptRSA(des_key, false, "UTF-8");
	        String enc_key_base64=Base64.encodeBase64String(enc_key);

			byte[] sign = rsaHelper.signRSA(Base64.decodeBase64(encBase64), false, "UTF-8");
			String signBase64=Base64.encodeBase64String(sign);

			Map<String,String> encmap=new HashMap<String,String>();
            encmap.put("encMsg", encBase64);
            encmap.put("encKey", enc_key_base64);
            encmap.put("sign", signBase64);

            String encstrJson=JSON.toJSONString(encmap);
            String encstrJsonToBase64=Base64.encodeBase64String(encstrJson.getBytes("UTF-8"));
             result=encstrJsonToBase64;
		} catch (Exception e) {
			logger.error("加密报文失败");
			e.printStackTrace();
		}

		return result;
	}

   //验证签名
	public boolean verifySign(String sign,String msg){
		boolean signFlag=false;
        try {
			 signFlag=rsaHelper.verifyRSA(Base64.decodeBase64(msg), Base64.decodeBase64(sign), false, "UTF-8");
		} catch (Exception e) {
			logger.error("验证签名失败");
			e.printStackTrace();
		}

		return signFlag;
	}

	//解密报文
	public String decMsg(String encmsg,String enckey){

		String decmsg=null;
        try {
			byte[] dec_key=rsaHelper.decryptRSA(Base64.decodeBase64(enckey), false, "UTF-8");
			decmsg=DESHelper.desDecryptFromBase64(encmsg, dec_key);
		} catch (Exception e) {
			logger.error("解密报文异常！");
			e.printStackTrace();
		}
		return decmsg;
	}




}
