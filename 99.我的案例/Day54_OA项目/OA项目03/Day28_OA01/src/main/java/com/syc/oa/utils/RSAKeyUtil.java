package com.syc.oa.utils;

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
 * 创建密钥对的工具类.
 */
@SuppressWarnings("restriction")
public class RSAKeyUtil {
	
	//public="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCs7SwJJzfJwEm2LzBw/QmJvqjwvQdC1YE1z7HokG2yR7AHt04QQv/ztc/C4hpgS4dWovVLDwh1OjVonBsW37abGV0wCxjJzeR+AuMVL3zCPZF73aSbuXn42/xpEAz3enF/Q7sawzhBlsPs9EmRBwqge927FNDhAz60FPc2fdyaxQIDAQAB"
	//private="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKztLAknN8nASbYvMHD9CYm+qPC9B0LVgTXPseiQbbJHsAe3ThBC//O1z8LiGmBLh1ai9UsPCHU6NWicGxbftpsZXTALGMnN5H4C4xUvfMI9kXvdpJu5efjb/GkQDPd6cX9DuxrDOEGWw+z0SZEHCqB73bsU0OEDPrQU9zZ93JrFAgMBAAECgYBgHSreo4ekgVX3Bt97zYihoPExbT897IF2sUwHIU93SdUTVNT0wOiWQrWJcjaK0zAT/VstLtvanFHXJP0Bh7JsNJOaVxk6PJ/ece9+tw0M04IUk1sCPpFEtq1YO+E1vhlEj+5clAsPNs+pdt0UCJ9Qfvjw3YzU3JyNoc3z9o9z+QJBANSexhz09tf+lwgfoJMDN1x5pYW8zgv7AGOto7uSc3/3dj2AXSEHIU7ruClR5ErOgoIkRZ12hg/6W+9l4XB3mi8CQQDQNS39sFTaIw1MGvocOv6gKZ4NsXrvA5CcgE+60s2i2/VA2aAAOnbk21a4VvB1bQJ66od0ThFJiDfxMsele8FLAkEAw4/SGto5nMt/MSqd7/paVkVROGRDhIN2hTg1zBXVBFOhPsotXm6HdWacOe0ntKKjKX6hRUa54kJdgyFLLL3lYwJARJsxY2WmIBbqu8gr3/+EhYwRG5v+0SFQlnElVH8/6UknYE4Vjd217aVkxutG4rqf1ZbQOX+77InpPR4pcRr9TwJBAL+Z0W8eJtLf3n3JPux20QZNsRN2pOEFU2jYITk62a5nTMsTrSLrW6MjiRPk2bqhJBS6fJZXpxY5/ZhRrSYNEt0="
	
	// 非对称加密算法包含RSA算法.
	private static final String KEY_ALGORITHM = "RSA";
	// private static final String KEY_AIGO="MD5WithRSA";

	// 获取公钥的key
	public static final String PUBLICKEY = "RSAPublicKey";
	// 获取私钥的key
	public static final String PRIVATEKEY = "RSAPirvateKey";

	// 创建密钥对
	public static Map<String, Object> initKey() {
		Map<String, Object> map = new HashMap<String, Object>(2);
		try {
			// 生成指定算法的密钥对
			// 获取密钥对生成器
			KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
			// 限定生成的密钥的长度为1024,最低是512.
			generator.initialize(1024);
			// 生成密钥对
			KeyPair keyPair = generator.generateKeyPair();
			// 得到公钥
			PublicKey publicKey = keyPair.getPublic();
			// 得到私钥
			PrivateKey privateKey = keyPair.getPrivate();

			// 将公钥与私钥存储到集合中
			map.put(PUBLICKEY, publicKey);
			map.put(PRIVATEKEY, privateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return map;
	}

	// 利用Base64编码进行加密的方法
	public static String encryptBase64(byte[] key) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encodeBuffer(key);
	}

	// 利用Base64编码进行解密的方法
	public static byte[] decryptBase64(String key) {
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			return decoder.decodeBuffer(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		
		Map<String, Object> map = initKey();
		
		//从集合中获取公钥
		Key pubKey= (Key) map.get(PUBLICKEY);
		Key priKey= (Key) map.get(PRIVATEKEY);
		
		//进过base64重新编码后得到的公钥
		String pub = encryptBase64(pubKey.getEncoded());
		//进过base64重新编码后得到的私钥
		String pri = encryptBase64(priKey.getEncoded());
		System.out.println("公钥="+pub);
		System.out.println("私钥="+pri);
	}
}
