package com.syc.oa.util;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * 利用私钥进行加密的工具类
 * @类名称:SecuryUtil
 * @创建人:一一哥
 * @创建时间:2018年3月2日 上午11:01:42
 */
public class SecuryUtil {

	
	
	/**
	 * 在本案例中,利用私钥进行加密.
	 */
	private static final String PRIVATEKEY="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIBdYvSoZ3tVZ8F53NqcvLk94Z0ppkcLyVxAF5fLhqSzbuaI6gWNean5ZvCDZNW8wvg9LOVL4vY1Ct8PTgFLIlDTrnk/sMohW99Kbraee67XS/3jX3nTw6TpjF+bB2EdL/tY914XhGuq0A7LttnagoFkibtAFXqvexuGYF3rLb/nAgMBAAECgYAWJweizUU+hZioTQ2ONKplFYbQBpYJgME5SF5J9ffAiK7E3i/00VuDt+TJ8QL/19mV2Yjb8WKztqevowaFNqAvL+yCo+AkQ6ch76JGNbi+G32HaXdzPh+SB2UkExvRTbFh18iFUHrFvF6YC3sDQPOT3hKlmSYe1E+71/2WYnBTMQJBAMV9KrprApZrtYXmXqwjbUr4g572XTfaFz8l25ikU1ORQXSOqhuqWV036SRLZk8qS1ggoEl15w0X9dXUeqEY6NsCQQCmZWY7sRC/mbUXJR2vR1/UCp5Hg8JxBgZJlmCxfhIN0244YEIQCkdg6sE+gYa9TbCli9Wo/gJ9bzsQKzqGAJzlAkA+syGItAbLSQEFtQEjt8+wOLxZELDB1b0BsHxKtwk5g+l7HvxE8k2S+fhMLKAbzDrFjP42tHcZwhyrud0BHo53AkBSlbsS30PPxKsTbLF6ADO4mviJyARmcjYGqeMd1NODFy/6PRQsv91DZeA5dLH6HKgS0f9eW4vC08T9tmbagU1dAkB2hwo3RXAoGCO/9K3fS2mXt1/+uMCcTroVFUmOmlHDjjkGHDpjCAXfTc0DnEssxSXNllEPtvY1SG0kRkFvcvOa";
	
	/**
	 * 利用私钥进行加密,返回加密后的字符串
	 */
	public static String encryptMsg(String msg){
		try {
			//ConfigTools:Druid提供的工具类,内部采用了IBM的算法,所以利用RSA加解密的时候,和正常的加解密相反.
			return ConfigTools.encrypt(PRIVATEKEY,msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String encryptMsg = encryptMsg("syc");
		System.out.println("密文="+encryptMsg);
	}
	
}
