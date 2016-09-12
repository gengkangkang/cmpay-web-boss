package com.cmpay.common.cmsecure;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.cmpay.common.util.Constants;


/**
 * 
 * @author gengkangkang
 *
 */
public class test {
	
	public  String testgkk(){
		return "gkk test secure";
	}
	

    private Cipher encryptCipher;

    private Cipher decryptCipher;

    /**
     * KeyFactory
     */
    private SecretKeyFactory keyFactory;

    public test() {
        try {
            encryptCipher = Cipher.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");
            keyFactory = SecretKeyFactory.getInstance("DES");
        } catch (GeneralSecurityException ex) {
            System.out.println("I don't think this will happen...");
        }
    }

    public void init(String salt) {
        try {
            SecretKey sk = keyFactory.generateSecret(new DESKeySpec(salt.getBytes()));
            encryptCipher.init(Cipher.ENCRYPT_MODE, sk);
            decryptCipher.init(Cipher.DECRYPT_MODE, sk);
        } catch (InvalidKeyException | InvalidKeySpecException ex) {
            System.out.println("Can't init Cipher.[salt={}]");
        }
    }

    public String encrypt(String value) throws GeneralSecurityException {
        return new String(Base64.encodeBase64(encryptCipher.doFinal(value.getBytes())));
    }

  
    public String decrypt(String value) throws GeneralSecurityException {
        return new String(decryptCipher.doFinal(Base64.decodeBase64(value.getBytes())));
    }
    
    
    ///////////////////////////////////////////////rsa
    

    public static byte[] getRSAPrivateKey(Map<String,Object> keyMap) throws Exception{
    	Key key=(Key)keyMap.get(Constants.RSA_PRIVATE_KEY);
    	return key.getEncoded();
    }
 
    public static byte[] getRSAPublicKey(Map<String,Object> keyMap) throws Exception{
    	Key key=(Key)keyMap.get(Constants.RSA_PUBLIC_KEY);
    	return key.getEncoded();
    } 
   
    public static Map<String,Object> initRSAKey() throws Exception{
    	KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance(Constants.RSA_KEY_ALGORITHM);
    	keyPairGen.initialize(Constants.RSA_KEY_SIZE);
    	KeyPair keyPair=keyPairGen.generateKeyPair();
    	RSAPublicKey publicKey=(RSAPublicKey)keyPair.getPublic();
    	RSAPrivateKey privateKey=(RSAPrivateKey)keyPair.getPrivate();
    	Map<String,Object> keyMap=new HashMap<String,Object>(2);
    	keyMap.put(Constants.RSA_PUBLIC_KEY, publicKey);
    	keyMap.put(Constants.RSA_PRIVATE_KEY, privateKey);
		return keyMap;
    	
    }
    
}
