package com.syc.spring.aop02;

import com.syc.spring.aop02.annotation.PrivilegeAnnotation;

/*
 * 目标类.
 */
public class ShowSalery{

	@PrivilegeAnnotation(privilege="admin")
	public void showSalery(){
		System.out.println("你的薪资是:300000$");
	}
	
}
