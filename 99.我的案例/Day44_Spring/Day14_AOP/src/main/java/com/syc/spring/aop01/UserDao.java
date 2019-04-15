package com.syc.spring.aop01;

public class UserDao {

	public void insert(){
		int a=10;
		int b=a/0;
		
		System.out.println("dao....添加..."+b);
	}
}
