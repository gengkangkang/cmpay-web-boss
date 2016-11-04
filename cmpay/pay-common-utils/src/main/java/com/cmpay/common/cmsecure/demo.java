package com.cmpay.common.cmsecure;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;

/**
 * 加解密报文demo
 * 
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 * 
 * 2016年8月10日 下午5:23:58
 *
 */
public class demo {

	public static final String DES_KEY_ALGORITHM = "DESede";
	public static final String DES_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";
	public static final String key = "efiKLwiMTK0CAu89pKI95ThPDi8HZgkk";
	public static final String UTF8 = "UTF-8";

	// RSA数字签名
	public static final String ENCODING = "UTF-8";
	public static final String RSA_KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	public static final String RSA_PUBLIC_KEY = "CMRSAPublicKey";
	public static final String RSA_PRIVATE_KEY = "CMRSAPrivateKey";
	public static final int RSA_KEY_SIZE = 512;

	public static final String PUBKEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI9uYbb3LDRvOQI1zbei2Doig7xfOmEmj8DvJNAG5xFHjbaXvieyOxM8Gs9bsg6Sqol61dSCnlLT8xNiFpIXJwsCAwEAAQ==";
	public static final String PRIKEY = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAj25htvcsNG85AjXNt6LYOiKDvF86YSaPwO8k0AbnEUeNtpe+J7I7Ezwaz1uyDpKqiXrV1IKeUtPzE2IWkhcnCwIDAQABAkA50KOgrddqt16Cbo+iswh3vovddYFBwdp2Sa9MD0w64UKha/IF50pDURzdrg+GK8uc+OlzqFuOEPMrbH8VnRNRAiEA0w8tWT+YFyCgF93ec5jbQy8gB0qjjrordK/idhYuVtMCIQCt+M1t2ke0YdOHJXEjZqxeOf4GDR1eyOw9Q2pwIsq76QIhALuFXJFTQ1opDpSl+CNUyFsk35wa4L7LAhkmvFqW0o0pAiBlsYs7zJ2flpOUa1GQNQNK7TFNDjt93YsiYJcGR4AkiQIgdPhkKsyDXOudv0WTu2JO65HRoSh0OhsIKia1e9Z46e4=";

	public String rsasign(String data) throws Exception {
		byte[] debyte = Base64.decodeBase64(data);
		byte[] endata = this.rsa_sign(debyte, Base64.decodeBase64(this.PRIKEY));
		return Base64.encodeBase64String(endata);
	}

	public boolean rsaverify(String data, String sign) throws Exception {
		byte[] debyte = Base64.decodeBase64(data);
		byte[] design = Base64.decodeBase64(sign);

		boolean flag = this.rsa_verify(debyte,
				Base64.decodeBase64(this.PUBKEY), design);
		return flag;
	}

	public String encrypt(String data) throws Exception {
		byte[] endata = this.des_encrypt(data.getBytes(UTF8), key.getBytes());
		return Base64.encodeBase64String(endata);
	}

	public String decrypt(String data) throws Exception {
		byte[] debyte = Base64.decodeBase64(data);
		byte[] dedata = this.des_decrypt(debyte, key.getBytes());
		return new String(dedata, UTF8);
	}

	private Key toKey(byte[] key) throws Exception {
		// ʵ��DES��Կ����
		DESedeKeySpec dks = new DESedeKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(DES_KEY_ALGORITHM);

		return keyFactory.generateSecret(dks);
	}

	public byte[] des_decrypt(byte[] data, byte[] key) throws Exception {

		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(DES_CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);

	}

	public byte[] des_encrypt(byte[] data, byte[] key) throws Exception {

		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(DES_CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);

	}


	public byte[] rsa_sign(byte[] data, byte[] privateKey) throws Exception {
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance(this.RSA_KEY_ALGORITHM);
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(this.SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(data);
		return signature.sign();

	}


	public boolean rsa_verify(byte[] data, byte[] publicKey, byte[] sign)
			throws Exception {
		X509EncodedKeySpec x509keySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance(this.RSA_KEY_ALGORITHM);
		PublicKey pubKey = keyFactory.generatePublic(x509keySpec);
		Signature signature = Signature.getInstance(this.SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);
		return signature.verify(sign);
	}


	public String encodeBase64(String data) throws Exception {
		return Base64.encodeBase64String(data.getBytes());
	}


	public String decodeBase64(String data) throws Exception {
		return new String(Base64.decodeBase64(data.getBytes()));
	}

	public static void main(String[] args) throws Exception {
		demo core = new demo();
		Map<String, String> mapdata = new HashMap<String, String>();

		mapdata.put("mobile", "18721359153");
		mapdata.put("status", "CLEARED");

		String str = JSON.toJSONString(mapdata);


		System.out.println("要加密的字符串：" + str);
		String enstr = core.encrypt(str);
		System.out.println("加密后的字符串：" + enstr);
		String sign = core.rsasign(enstr);
		System.out.println("rsa签名:" + sign);
		Map<String, String> map = new HashMap<String, String>();
		map.put("data", enstr);
		map.put("sign", sign);
		String backjson = JSON.toJSONString(map);
		System.out.println("backjson:" + backjson);
		String base64 = core.encodeBase64(backjson);

		System.out.println("base64:" + base64);

	}

}
