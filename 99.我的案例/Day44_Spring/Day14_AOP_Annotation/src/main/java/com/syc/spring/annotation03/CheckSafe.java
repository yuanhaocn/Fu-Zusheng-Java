package com.syc.spring.annotation03;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/*
 * 切面类二
 */
//改变通知执行顺序的第三种方式:实现Ordered接口,复写getOrder()方法.
@Component
@Aspect
//@Order(2)
public class CheckSafe implements Ordered{
	
	@Pointcut("execution(* com.syc.spring.annotation03.ShowSalery.*(..))")
	public void perform(){}

	@Before("perform()")
	
	public void check(){
		System.out.println("环境监测...");
	}

	public int getOrder() {
		return 2;
	}
}
