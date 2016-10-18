package com.cmpay.service.llpay.service.impl;

import com.alibaba.fastjson.JSON;
import com.cmpay.service.llpay.conn.HttpRequestSimplePay;
import com.cmpay.service.llpay.model.PayQueryReqBean;
import com.cmpay.service.llpay.model.PayQueryResBean;
import com.cmpay.service.llpay.utils.LLPayUtil;

public class testLLpay {
	
	public static String testprikey="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMlGNh/WsyZSYnQcHd9t5qUkhcOhuQmozrAY9DM4+7fhpbJenmYee4chREW4RB3m95+vsz9DqCq61/dIOoLK940/XmhKkuVjfPqHJpoyHJsHcMYy2bXCd2fI++rERdXtYm0Yj2lFbq1aEAckciutyVZcAIHQoZsFwF8l6oS6DmZRAgMBAAECgYAApq1+JN+nfBS9c2nVUzGvzxJvs5I5qcYhY7NGhySpT52NmijBA9A6e60Q3Ku7vQeICLV3uuxMVxZjwmQOEEIEvXqauyYUYTPgqGGcwYXQFVI7raHa0fNMfVWLMHgtTScoKVXRoU3re6HaXB2z5nUR//NE2OLdGCv0ApaJWEJMwQJBAPWoD/Cm/2LpZdfh7oXkCH+JQ9LoSWGpBDEKkTTzIqU9USNHOKjth9vWagsR55aAn2ImG+EPS+wa9xFTVDk/+WUCQQDRv8B/lYZD43KPi8AJuQxUzibDhpzqUrAcu5Xr3KMvcM4Us7QVzXqP7sFc7FJjZSTWgn3mQqJg1X0pqpdkQSB9AkBFs2jKbGe8BeM6rMVDwh7TKPxQhE4F4rHoxEnND0t+PPafnt6pt7O7oYu3Fl5yao5Oh+eTJQbyt/fwN4eHMuqtAkBx/ob+UCNyjhDbFxa9sgaTqJ7EsUpix6HTW9f1IirGQ8ac1bXQC6bKxvXsLLvyLSxCMRV/qUNa4Wxu0roI0KR5AkAZqsY48Uf/XsacJqRgIvwODstC03fgbml890R0LIdhnwAvE4sGnC9LKySRKmEMo8PuDhI0dTzaV0AbvXnsfDfp";
	
	public static String testmd5key="201408071000001543test_20140812";
	
	public static void main(String[] args) {
		PayQueryReqBean payQueryReqBean = new PayQueryReqBean();
		payQueryReqBean.setOid_partner("201408071000001543");
		payQueryReqBean.setSign_type("MD5");
		payQueryReqBean.setNo_order("132792");//132791
		payQueryReqBean.setDt_order("20151023193104");//：YYYYMMDDH24MISS
		//加签名
		String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(payQueryReqBean)), testprikey, testmd5key);
		payQueryReqBean.setSign(sign);
		String reqJson = JSON.toJSONString(payQueryReqBean);
		System.out.println("连连代扣查询请求"+reqJson);
		//发送请求
		String resJson = null;
		HttpRequestSimplePay httpclent = new HttpRequestSimplePay();
		try {
			resJson = httpclent.postSendHttp("https://yintong.com.cn/traderapi/orderquery.htm", reqJson);
		} catch (Exception e) {
			System.out.println("连连代付请求异常:{}"+ e);
		}
		System.out.println(resJson);
		PayQueryResBean resBean = JSON.parseObject(resJson, PayQueryResBean.class);
		System.out.println(resBean.toString());
	}

}
