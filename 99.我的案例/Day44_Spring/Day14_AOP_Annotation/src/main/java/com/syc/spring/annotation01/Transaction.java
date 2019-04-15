package com.syc.spring.annotation01;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类
 * @Aspect:表明该类是一个切面类.
 */
@Component("transaction")
@Aspect
public class Transaction {
	
	//配置切入点表达式
	@Pointcut("execution(* com.syc.spring.annotation01.UserDao.*(..))")
	public void perform(){}//没有任何实现的空方法体,它只是一个目标方法的签名.等同于切入点表达式的id.
	
	//@Around
	//@AfterThrowing
	//@AfterReturning
	
	//前置通知方法
	@Before("perform()")
	public void beginTransaction(){
		System.out.println("开启事务...");
	}
	
	//最终通知方法
	@After("perform()")
	public void commit(){
		System.out.println("提交事务...");
	}
}
