package com.syc.manager.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordUtil {

	/**
	 * source:要加密的内容;
	 * salt:盐,用来增强加密后内容的安全性;
	 * hashIterations:加密的次数.
	 */
	public static String md5(String source,Object salt,int hashIterations){
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		return md5Hash.toString();
	}
	
	public static String md5(String source,Object salt){
		Md5Hash md5Hash = new Md5Hash(source, salt, 1024);
		return md5Hash.toString();
	}
	
	public static String md5(String source){
		Md5Hash md5Hash = new Md5Hash(source);
		return md5Hash.toString();
	}
}
