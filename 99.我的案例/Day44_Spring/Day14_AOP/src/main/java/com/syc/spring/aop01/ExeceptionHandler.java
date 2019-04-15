package com.syc.spring.aop01;

/*
 * 切面类
 */
public class ExeceptionHandler {

	//SQLException
	public void handleException(Throwable ex) {
		System.out.println("异常信息:" + ex.getMessage());
	}
}
