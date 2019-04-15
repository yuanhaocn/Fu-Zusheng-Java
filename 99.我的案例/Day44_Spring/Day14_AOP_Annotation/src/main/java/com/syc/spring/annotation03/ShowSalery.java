package com.syc.spring.annotation03;

import org.springframework.stereotype.Component;

/*
 * 目标类
 */
@Component
public class ShowSalery {

	public void showSalery(){
		System.out.println("你的薪资为4999");
	}
}
