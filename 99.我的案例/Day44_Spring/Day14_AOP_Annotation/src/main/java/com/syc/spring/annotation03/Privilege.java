package com.syc.spring.annotation03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * 切面类三
 */
@Component
@Aspect
public class Privilege {

	@Value("admin")
	private String access;

	@Pointcut("execution(* com.syc.spring.annotation03.ShowSalery.*(..))")
	public void perform(){}
	
	//对于异常通知和后置通知,要特别注意!
	//@AfterThrowing(value="perform()",throwing="ex")
	//@AfterReturning(value="perform()",returning="value")
	
	// JoinPoint
	@Around("perform()")
	public void isAccess(ProceedingJoinPoint point) throws Throwable {
		if ("admin".equals(access)) {
			point.proceed();
		} else {
			System.out.println("你无权查看薪资!");
		}
	}
}
