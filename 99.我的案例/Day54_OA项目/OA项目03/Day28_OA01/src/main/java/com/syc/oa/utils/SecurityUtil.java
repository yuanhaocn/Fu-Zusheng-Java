package com.syc.oa.utils;

import com.alibaba.druid.filter.config.ConfigTools;

/*
 * 利用私钥对明文进行加密的工具类
 */
public class SecurityUtil {

	// 私钥.此处私钥用来进行加密.
	private static final String PRIVATEKEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKztLAknN8nASbYvMHD9CYm+qPC9B0LVgTXPseiQbbJHsAe3ThBC//O1z8LiGmBLh1ai9UsPCHU6NWicGxbftpsZXTALGMnN5H4C4xUvfMI9kXvdpJu5efjb/GkQDPd6cX9DuxrDOEGWw+z0SZEHCqB73bsU0OEDPrQU9zZ93JrFAgMBAAECgYBgHSreo4ekgVX3Bt97zYihoPExbT897IF2sUwHIU93SdUTVNT0wOiWQrWJcjaK0zAT/VstLtvanFHXJP0Bh7JsNJOaVxk6PJ/ece9+tw0M04IUk1sCPpFEtq1YO+E1vhlEj+5clAsPNs+pdt0UCJ9Qfvjw3YzU3JyNoc3z9o9z+QJBANSexhz09tf+lwgfoJMDN1x5pYW8zgv7AGOto7uSc3/3dj2AXSEHIU7ruClR5ErOgoIkRZ12hg/6W+9l4XB3mi8CQQDQNS39sFTaIw1MGvocOv6gKZ4NsXrvA5CcgE+60s2i2/VA2aAAOnbk21a4VvB1bQJ66od0ThFJiDfxMsele8FLAkEAw4/SGto5nMt/MSqd7/paVkVROGRDhIN2hTg1zBXVBFOhPsotXm6HdWacOe0ntKKjKX6hRUa54kJdgyFLLL3lYwJARJsxY2WmIBbqu8gr3/+EhYwRG5v+0SFQlnElVH8/6UknYE4Vjd217aVkxutG4rqf1ZbQOX+77InpPR4pcRr9TwJBAL+Z0W8eJtLf3n3JPux20QZNsRN2pOEFU2jYITk62a5nTMsTrSLrW6MjiRPk2bqhJBS6fJZXpxY5/ZhRrSYNEt0=";

	// msg:是待加密的明文
	public static String encryptDes(String msg) {
		// 注意:在Druid中,Druid实现加解密利用的IBM提供的算法,在这个算法中,是利用的
		// 私钥进行加密,公钥进行解密,也就是与正常的RSA算法相反.
		try {
			return ConfigTools.encrypt(PRIVATEKEY, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//syc字符串是明文
		String encryptDes = encryptDes("syc");
		System.out.println("密文:"+encryptDes);
	}
}
