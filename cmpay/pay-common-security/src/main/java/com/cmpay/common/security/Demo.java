package com.cmpay.common.security;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cmpay.common.security.util.DESHelper;
import com.cmpay.common.security.util.RSAHelper;

/**
 * 加解密工具类
 *
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月27日 上午10:37:02
 *
 */
public class Demo {

         public static void main(String[] args){
        	 RSAHelper rsaHelper=new RSAHelper();
        	 //初始化秘钥
        	 try {
				rsaHelper.initKey("D:/zmcf/cmpay/cmpay.pfx", "gkk@cmpay", "D:/zmcf/cmpay/cmpay.cer");
			} catch (Exception e) {
				System.out.println("初始化秘钥失败");
				e.printStackTrace();
			}

           String msg="{'name':'张三','sex':'man'}";
			try {

				//2.生成随机DES密码
				byte[] des_key = DESHelper.generateDesKey() ;
                //3.用随机密码对报文msg进行加密
                String encHex=DESHelper.desEncryptToHex(msg, des_key);
                System.out.println("生成十六进制密文为："+encHex);
                String encBase64=DESHelper.desEncryptToBase64(msg, des_key);
                System.out.println("生成base64密文为："+encBase64);

                //4.对DES秘钥进行加密
                byte[] enc_key = rsaHelper.encryptRSA(des_key, false, "UTF-8") ;
                String enc_key_base64=Base64.encodeBase64String(enc_key);
                System.out.println("生成base64密文key为："+enc_key_base64);

                //5.对密文报文签名
				byte[] sign = rsaHelper.signRSA(Base64.decodeBase64(encBase64), false, "UTF-8") ;
				String signHex=Hex.encodeHexString(sign);
				System.out.println("生成十六进制签名为："+signHex);
				String signBase64=Base64.encodeBase64String(sign);
				System.out.println("生成base64签名为："+signBase64);

				Map<String,String> encmap=new HashMap<String,String>();
                 encmap.put("encMsg", encBase64);
                 encmap.put("encKey", enc_key_base64);
                 encmap.put("sign", signBase64);
                 encmap.put("merchantid", "0001");

                 String encstrJson=JSON.toJSONString(encmap);
                 System.out.println("json="+encstrJson);
                 String encstrJsonToBase64=Base64.encodeBase64String(encstrJson.getBytes("UTF-8"));
                 System.out.println("base64json="+encstrJsonToBase64);


                ////////////////////////////////////////////////////////////////////////////////////

                 //验签解密
                 System.out.println("/////////////////////////////////////////////解密验签///////////////////////////////////////////////////////");
                 String decjson=new String(Base64.decodeBase64(encstrJsonToBase64),"UTF-8");
                 System.out.println("decjson="+decjson);
                 JSONObject json=JSONObject.parseObject(decjson);
                 byte[] decsign=Base64.decodeBase64(json.getString("sign"));
                 String decmsg=json.getString("encMsg");
                 String deckey=json.getString("encKey");

                //1.校验签名
                   boolean signFlag=rsaHelper.verifyRSA(Base64.decodeBase64(decmsg), decsign, false, "UTF-8");
                   System.out.println("验证签名结果："+signFlag);
                //2.解密des秘钥
                   byte[] dec_key=rsaHelper.decryptRSA(Base64.decodeBase64(deckey), false, "UTF-8");
                   System.out.println("解除的DES秘钥为："+Base64.encodeBase64String(dec_key));

                   //3.解密报文
                   String str=DESHelper.desDecryptFromBase64(decmsg, dec_key);
                    System.out.println("解密的报文为："+str);

			}  catch (Exception e) {
				System.out.println("签名失败");
				e.printStackTrace();
			}


         }


}
