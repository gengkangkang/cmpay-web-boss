package com.cmpay.common.cmsecure;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.cmpay.common.util.Constants;
import com.cmpay.common.util.BaseObject;

/**
 * 加密工具类
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年8月10日 下午5:12:13
 *
 */

public class Des {
	



    public static String encrypt(String data) throws Exception{
    	byte[] endata=BaseObject.des_encrypt(data.getBytes(Constants.UTF8),Constants.key.getBytes());
    	return Base64.encodeBase64String(endata);
    }
    

    public static String decrypt(String data) throws Exception{
    	byte[] debyte=Base64.decodeBase64(data);
    	byte[] dedata=BaseObject.des_decrypt(debyte,Constants.key.getBytes());
    	return new String(dedata,Constants.UTF8);
    }
    

    public static String rsasign(String data) throws Exception{
    	byte[] debyte=Base64.decodeBase64(data);
    	byte[] endata=BaseObject.rsa_sign(debyte,Base64.decodeBase64(Constants.PRIKEY));
    	return Base64.encodeBase64String(endata);
    }
    
    public static boolean rsaverify(String data,String sign) throws Exception{
    	byte[] debyte=Base64.decodeBase64(data);
    	byte[] design=Base64.decodeBase64(sign);

    	boolean flag=BaseObject.rsa_verify(debyte, Base64.decodeBase64(Constants.PUBKEY), design);
    	return flag;
    }
    
    
    public static String  encodeBase64(String data) throws Exception{  	
        return Base64.encodeBase64String(data.getBytes());   		
     }
    
     public static  String decodeBase64(String data) throws Exception{
     	return new String(Base64.decodeBase64(data.getBytes()));
     }

	public static void main(String[] args) throws Exception {
		
		 Map<String,String> mapdata=new HashMap<String,String>();
         mapdata.put("mobile", "18721359161");
         mapdata.put("inchannel", "1000");
         String str=JSON.toJSONString(mapdata);

	System.out.println("需要加密的字符串=="+str);
	String enstr=encrypt(str);
	System.out.println("加密后=="+enstr);
	String sign=rsasign(enstr);
	System.out.println("签名:"+sign);
	Map<String,String> map=new HashMap<String,String>();
           map.put("data", enstr);
           map.put("sign", sign);
           String backjson=JSON.toJSONString(map);
           System.out.println("backjson:"+backjson);
           String base64=encodeBase64(backjson);
           
	 System.out.println("base64:"+base64);
		
	


	}

}
