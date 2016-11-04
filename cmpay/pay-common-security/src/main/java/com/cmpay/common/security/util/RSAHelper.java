package com.cmpay.common.security.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * RSA签名/验签 & 加密/解密算法
 * 对RSA 签名&验签/分段加密&分段解密 的包装 签名算法: "SHA1withRSA", 私钥进行签名; 公钥进行验签.
 * 加密算法: "RSA/ECB/PKCS1Padding", 公钥进行加密; 私钥进行解密.
 * @author gengkangkang
 * @E-mail gengkangkang@cm-inv.com
 *
 * 2016年9月27日 上午9:29:49
 *
 */
public class RSAHelper {

	private Logger logger=Logger.getLogger(this.getClass());

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding"; // 加密block需要预留11字节
	public static final int KEYBIT = 2048;
	public static final int RESERVEBYTES = 11;

	private PrivateKey localPrivKey;
	private PublicKey peerPubKey;

	/**
	 * 初始化自己的私钥,对方的公钥以及密钥长度.
	 *
	 * @param localPrivKeyBase64Str
	 *            Base64编码的私钥,PKCS#8编码. (去掉pem文件中的头尾标识)
	 * @param peerPubKeyBase64Str
	 *            Base64编码的公钥. (去掉pem文件中的头尾标识)
	 * @param keysize
	 *            密钥长度, 一般2048
	 */
	public void initKey(String pfxPath,
			String pfxPasswd, String cerPath) throws Exception {
		try {
			System.out.println("-------初始化统一支付平台秘钥----------");
			localPrivKey = this.getPrivateKeyFromPfx(pfxPath, pfxPasswd);
			peerPubKey = this.getPublicKeyFromCer(cerPath);
		} catch (InvalidKeySpecException e) {
			logger.error("初始化统一支付平台秘钥异常！");
			e.printStackTrace();
		}
	}

	/**
	 * 初始化自己的私钥,对方的公钥以及密钥长度.
	 * @param rzlocalPrivKey
	 * @param rzpeerPubKey
	 */
	public void initKey( PrivateKey localPrivKey, PublicKey peerPubKey){
		this.localPrivKey = localPrivKey ;
		this.peerPubKey = peerPubKey ;
	}


	 /**
     * 获取 私钥key
     * @param pfxPath
     * @param pfxPasswd
     * @return
     * @throws Exception
     */
    public PrivateKey getPrivateKeyFromPfx(String pfxPath ,String pfxPasswd) throws Exception{
        //替换为自己的客户端私钥路径
        try {
            FileInputStream fis2 = new FileInputStream(pfxPath);
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] keypwd = pfxPasswd.toCharArray(); // 证书密码
            ks.load(fis2, keypwd);
            String alias;
            alias = ks.aliases().nextElement();
            PrivateKey prikey = (PrivateKey) ks.getKey(alias,keypwd);
            fis2.close();
            return prikey;
        } catch (FileNotFoundException e) {
            throw new Exception("找不到私钥文件");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (CertificateException e) {
            throw new Exception("证书加载异常");
        } catch (KeyStoreException e) {
            throw new Exception("证书加载异常");
        } catch (UnrecoverableKeyException e) {
            throw new Exception("无此算法");
        } catch (IOException e) {
            throw new Exception("文件IO异常");
        }// 加载证书

    }

    /**
     * 获取公钥key
     * @param cerPath
     * @return
     * @throws Exception
     */
    public PublicKey getPublicKeyFromCer(String cerPath) throws Exception {
        try{
            CertificateFactory certificate_factory = CertificateFactory.getInstance("X.509");
            //替换生产环境的金运通公钥证书
            FileInputStream file_inputstream = new FileInputStream(cerPath);
            X509Certificate x509certificate = (X509Certificate) certificate_factory.generateCertificate(file_inputstream);
            PublicKey pk = x509certificate.getPublicKey();
            return pk;
        } catch(CertificateException e){
            throw new Exception("证书加载异常");
        } catch(FileNotFoundException e){
            throw new Exception("找不到公钥文件");
        }
    }

	/**
	 * RAS加密
	 *
	 * @param peerPubKey
	 *            公钥
	 * @param data
	 *            待加密信息
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] encryptRSA(byte[] plainBytes, boolean useBase64Code, String charset)
			throws Exception {

		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		int decryptBlock = KEYBIT / 8; // 256 bytes
		int encryptBlock = decryptBlock - RESERVEBYTES; // 245 bytes
		// 计算分段加密的block数 (向上取整)
		int nBlock = (plainBytes.length / encryptBlock);
		if ((plainBytes.length % encryptBlock) != 0) { // 余数非0，block数再加1
			nBlock += 1;
		}
		// 输出buffer, 大小为nBlock个decryptBlock
		ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock
				* decryptBlock);
		cipher.init(Cipher.ENCRYPT_MODE, peerPubKey);
		// 分段加密
		for (int offset = 0; offset < plainBytes.length; offset += encryptBlock) {
			// block大小: encryptBlock 或 剩余字节数
			int inputLen = (plainBytes.length - offset);
			if (inputLen > encryptBlock) {
				inputLen = encryptBlock;
			}
			// 得到分段加密结果
			byte[] encryptedBlock = cipher.doFinal(plainBytes, offset, inputLen);
			// 追加结果到输出buffer中
			outbuf.write(encryptedBlock);
		}
		// 如果是Base64编码，则返回Base64编码后的数组
		if (useBase64Code) {
			return Base64.encodeBase64String(outbuf.toByteArray()).getBytes(
					charset);
		} else {
			return outbuf.toByteArray(); // ciphertext
		}
	}

	/**
	 * RSA解密
	 *
	 * @param localPrivKey
	 *            私钥
	 * @param cryptedBytes
	 *            待解密信息
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] decryptRSA(byte[] cryptedBytes, boolean useBase64Code,
			String charset) throws Exception {
		byte[] data = null;

		// 如果是Base64编码的话，则要Base64解码
		if (useBase64Code) {
			data = Base64.decodeBase64(new String(cryptedBytes, charset));
		} else {
			data = cryptedBytes;
		}

		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		int decryptBlock = KEYBIT / 8; // 256 bytes
		int encryptBlock = decryptBlock - RESERVEBYTES; // 245 bytes
		// 计算分段解密的block数 (理论上应该能整除)
		int nBlock = (data.length / decryptBlock);
		// 输出buffer, , 大小为nBlock个encryptBlock
		ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock
				* encryptBlock);
		cipher.init(Cipher.DECRYPT_MODE, localPrivKey);
		// 分段解密
		for (int offset = 0; offset < data.length; offset += decryptBlock) {
			// block大小: decryptBlock 或 剩余字节数
			int inputLen = (data.length - offset);
			if (inputLen > decryptBlock) {
				inputLen = decryptBlock;
			}

			// 得到分段解密结果
			byte[] decryptedBlock = cipher.doFinal(data, offset, inputLen);
			// 追加结果到输出buffer中
			outbuf.write(decryptedBlock);
		}
		outbuf.flush();
		outbuf.close();
		return outbuf.toByteArray();
	}

	/**
	 * RSA签名
	 *
	 * @param localPrivKey
	 *            私钥
	 * @param plaintext
	 *            需要签名的信息
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] signRSA(byte[] plainBytes, boolean useBase64Code,
			String charset) throws Exception {
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(localPrivKey);
		signature.update(plainBytes);

		// 如果是Base64编码的话，需要对签名后的数组以Base64编码
		if (useBase64Code) {
			return Base64.encodeBase64String(signature.sign())
					.getBytes(charset);
		} else {
			return signature.sign();
		}
	}

	/**
	 * 验签操作
	 *
	 * @param peerPubKey
	 *            公钥
	 * @param plainBytes
	 *            需要验签的信息
	 * @param signBytes
	 *            签名信息
	 * @return boolean
	 */
	public boolean verifyRSA(byte[] plainBytes, byte[] signBytes,
			boolean useBase64Code, String charset) throws Exception {
		boolean isValid = false;
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(peerPubKey);
		signature.update(plainBytes);

		// 如果是Base64编码的话，需要对验签的数组以Base64解码
		if (useBase64Code) {
			isValid = signature.verify(Base64.decodeBase64(new String(
					signBytes, charset)));
		} else {
			isValid = signature.verify(signBytes);
		}
		return isValid;
	}

}
