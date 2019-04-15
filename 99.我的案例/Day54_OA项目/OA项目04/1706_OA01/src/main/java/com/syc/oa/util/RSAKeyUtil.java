package com.syc.oa.util;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 用来创建密钥对的工具类
 * 
 * @类名称:RSAKeyUtil
 * @创建人:一一哥
 * @创建时间:2018年3月2日 上午10:37:52
 */
@SuppressWarnings("restriction")
public class RSAKeyUtil {

	// RSA算法
	private static final String RSA_ALGORITHM = "RSA";

	private static final String RSA_PUBLIC = "RSAPublicKey";
	private static final String RSA_PRIVATE = "RSAPrivateKey";

	public static Map<String, Object> createKeyPair() {
		try {
			Map<String, Object> map = new HashMap<>(2);
			// 得到密钥对的生成器
			KeyPairGenerator generator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
			// 表示初始化密文的长度
			generator.initialize(1024);
			// 生成密钥对
			KeyPair keyPair = generator.generateKeyPair();
			// 得到公钥和私钥
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			map.put(RSA_PUBLIC, publicKey);
			map.put(RSA_PRIVATE, privateKey);
			return map;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Base64进行编码的方法
	 */
	public static String encodeBase64(byte[] key){
		//Encoder encoder = Base64.getEncoder();
		BASE64Encoder encoder=new BASE64Encoder();
		return encoder.encodeBuffer(key);
	}
	
	/**
	 * Base64进行解码的方法
	 */
	public static byte[] decodeBase64(String key){
		try {
			//Decoder decoder = Base64.getDecoder();
			BASE64Decoder decoder=new BASE64Decoder();
			return decoder.decodeBuffer(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = createKeyPair();
		Key pubKey = (Key) map.get(RSA_PUBLIC);
		Key priKey = (Key) map.get(RSA_PRIVATE);
		
		String pubStr = encodeBase64(pubKey.getEncoded());
		String priStr = encodeBase64(priKey.getEncoded());
		System.out.println("公钥="+pubStr);
		System.out.println("私钥="+priStr);
	}
}
