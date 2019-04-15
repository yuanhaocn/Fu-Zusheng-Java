package com.syc.spring.annotation02;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 切面类三
 */
public class Privilege {

	private String access;

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	//JoinPoint
	public void isAccess(ProceedingJoinPoint point) throws Throwable {
		if("admin".equals(access)){
			point.proceed();
		}else{
			System.out.println("你无权查看薪资!");
		}
	}
}
