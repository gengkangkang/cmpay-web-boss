package com.cmpay.common.security;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.cmpay.common.security.util.Constants;
import com.cmpay.common.security.util.baseObject;

/**
 * 加密工具类
 *
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月23日 下午5:51:46
 *
 */
public class Tools {




    public static String encrypt(String data) throws Exception{
    	byte[] endata=baseObject.des_encrypt(data.getBytes(Constants.UTF8),Constants.key.getBytes());
    	return Base64.encodeBase64String(endata);
    }


    public static String decrypt(String data) throws Exception{
    	byte[] debyte=Base64.decodeBase64(data);
    	byte[] dedata=baseObject.des_decrypt(debyte,Constants.key.getBytes());
    	return new String(dedata,Constants.UTF8);
    }


    public static String rsasign(String data) throws Exception{
    	byte[] debyte=Base64.decodeBase64(data);
    	byte[] endata=baseObject.rsa_sign(debyte,Base64.decodeBase64(Constants.PRIKEY));
    	return Base64.encodeBase64String(endata);
    }

    public static boolean rsaverify(String data,String sign) throws Exception{
    	byte[] debyte=Base64.decodeBase64(data);
    	byte[] design=Base64.decodeBase64(sign);

    	boolean flag=baseObject.rsa_verify(debyte, Base64.decodeBase64(Constants.PUBKEY), design);
    	return flag;
    }


    public static String  encodeBase64(String data) throws Exception{
        return Base64.encodeBase64String(data.getBytes());
     }

     public static  String decodeBase64(String data) throws Exception{
     	return new String(Base64.decodeBase64(data.getBytes()));
     }

	public static void main(String[] args) throws Exception {
//    	String key="efiKLwiMTK0CAu89pKI95ThPDi8HZAgC";
//    	String key="efiKLwiMTK0CAu89pKI95ThPDi8HZgkk";
//    	byte[] dkey=key.getBytes();
//		String inputStr="����iͶ";
//		byte[] inputData=inputStr.getBytes();
//		System.out.println("ԭ�ģ�  "+inputStr);
//
//		//����
//		inputData=des_encrypt(inputData, dkey);
//		System.out.println("���ܺ���ݣ�"+inputData);
//		//����
//		byte[] outputdata=des_decrypt(inputData, dkey);
//		String outstr=new String(outputdata);
//		System.out.println("���ܺ����:"+outputdata);
//		System.out.println("���ܺ����2��"+outstr);

//		String str="{\"username\":\"gkk\",\"password\":\"123456\"}";
//		System.out.println("Ҫ���ܵ��ַ�=="+str);
//		String enstr=encrypt(str);
//		System.out.println("���ܺ���ַ�=="+enstr);
//		String sign=rsasign(enstr);
//		System.out.println("rsaǩ��"+sign);
//
//		boolean flag=rsaverify(enstr,sign);
//		System.out.println("rsaǩ����"+flag);


		 Map<String,String> mapdata=new HashMap<String,String>();
         mapdata.put("mobile", "18721359161");
         mapdata.put("inchannel", "1000");
         String str=JSON.toJSONString(mapdata);

	System.out.println("Ҫ���ܵ��ַ�=="+str);
	String enstr=encrypt(str);
	System.out.println("���ܺ���ַ�=="+enstr);
	String sign=rsasign(enstr);
	System.out.println("rsaǩ��:"+sign);
	Map<String,String> map=new HashMap<String,String>();
           map.put("data", enstr);
           map.put("sign", sign);
           String backjson=JSON.toJSONString(map);
           System.out.println("backjson:"+backjson);
           String base64=encodeBase64(backjson);

	 System.out.println("base64:"+base64);


//		String destr=decrypt(enstr);
//		System.out.println("���ܺ���ַ�=="+destr);


	}

}
