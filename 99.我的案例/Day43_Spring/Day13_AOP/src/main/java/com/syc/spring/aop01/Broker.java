package com.syc.spring.aop01;

/*
 * 切面类---->做一些辅助性的工作.
 */
public class Broker {

	//放在目标方法前面的增强方法被称为"前置通知".
	public void prepareSing(){
		System.out.println("为歌星准备演唱会...");
	}
	
	//放在目标方法后面的增强方法被称为"后置/最终通知".
	public void afterSing(){
		System.out.println("为演唱会进行善后...");
	}
}
