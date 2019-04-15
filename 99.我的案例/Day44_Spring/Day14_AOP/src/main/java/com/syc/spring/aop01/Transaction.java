package com.syc.spring.aop01;

/*
 * 切面类
 */
public class Transaction {

	public void beginTransaction(){
		System.out.println("开启事务...");
	}
	
	public void commit(){
		System.out.println("提交事务...");
	}
}
