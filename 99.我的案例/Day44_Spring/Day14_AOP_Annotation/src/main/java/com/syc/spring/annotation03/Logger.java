package com.syc.spring.annotation03;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/*
 * 切面类一.
 */
//改变通知执行顺序的第二种方式:给切面类或者切面类中的方法,添加@Order(1)注解.
@Component
@Aspect
//@Order(1)
public class Logger implements Ordered{

	//注意:该方法,一般都是pubilc,void,无参,并且该方法没有具体实现!
	@Pointcut("execution(* com.syc.spring.annotation03.ShowSalery.*(..))")
	public void perform(){}
	
	//注意:当有多个前置通知时,通知的执行顺序,默认情况下,与该类的类名首字母先后顺序有关系!
	@Before("perform()")
	
	public void logger(){
		System.out.println("日志记录...");
	}

	public int getOrder() {
		return 1;
	}
}
