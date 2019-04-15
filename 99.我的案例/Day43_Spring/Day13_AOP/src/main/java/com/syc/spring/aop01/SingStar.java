package com.syc.spring.aop01;

/*
 * 目标类--->目标方法.
 */
public class SingStar {
	
	//将辅助性的代码添加到目标类上的过程,被称为织入!
	//被织入的这些代码,就是一些增强性的代码.

	public void sing() {
		System.out.println("歌星开始唱歌了...");
	}

}
