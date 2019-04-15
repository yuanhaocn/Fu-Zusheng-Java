package com.syc.oa.utils;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 生成公钥与私钥的工具类
 * @类名称:RSAKeysUtil
 * @创建人:SYC
 * @创建时间:2017年11月1日 下午4:52:46
 */
@SuppressWarnings("restriction")
public class RSAKeysUtil {
	
	//MD5(message d...)信息摘要:
	//对称加密算法:加密密钥和解密密钥是同一个密钥的算法!
	//非对称加密算法:加密和解密用的密钥是不一样.公钥(解密)和私钥(加密)
	//大质数不可分解!
    //所使用的算法
	public static final String KEY_ALGORITHM = "RSA";
    //public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    //alibaba提供了自己的公钥和私钥
    //ConfigTools tools;
   
    public static void main(String[] args) {
        Map<String, Object> keyMap;
        try {
            keyMap = initKey();
            String publicKey = getPublicKey(keyMap);
            System.out.println(publicKey);
            String privateKey = getPrivateKey(keyMap);
            System.out.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化生成公钥和私钥
    public static Map<String, Object> initKey() throws Exception {
        //秘钥对生成器
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //为提高保密强度，RSA密钥至少为500位长，一般推荐使用1024位.
        //初始化秘钥长度
        keyPairGen.initialize(1024);
        //生成秘钥对
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    //对公钥进行Base64加密
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //byte[] publicKey = key.getEncoded();
        return encryptBASE64(key.getEncoded());
    }

    //对私钥进行Base64加密
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //byte[] privateKey = key.getEncoded();
        return encryptBASE64(key.getEncoded());
    }

    //Base64加密
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //Base64解密
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }
}
