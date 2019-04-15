package com.syc.spring.aop02;

/*
 * 目标类
 */
public class UserDao {

	//目标方法
	public int insert() {//SQLException
		//int a=10;
		//int b=a/0;
		//System.out.println("数据添加..."+b);
		System.out.println("3.目标方法---->数据添加...");
		
		return 10;
	}

}
