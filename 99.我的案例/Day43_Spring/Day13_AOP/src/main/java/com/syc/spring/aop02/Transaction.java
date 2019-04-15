package com.syc.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 切面类
 */
public class Transaction {

	//前置通知方法.
	public void beginTransaction(){
		System.out.println("1.前置通知---->开启事务...");
	}
	
	//环绕通知方法.----->该方法相当于是一个开关,能够决定下一个通知方法或者目标方法是否能够执行!
	public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
	
		System.out.println("2.环绕通知方法---->开关");
		// point.proceed():能够决定下一个通知方法或者目标方法是否能够执行!
		Object obj = point.proceed();
		System.out.println("环绕通知,obj="+obj.toString());
		
		return obj;
	}
	
	//异常通知方法:统计目标方法中出现的异常信息.
	//该方法是在目标方法执行过程中才会执行!
	public void exectionMethod(Throwable ex){
		System.out.println("3.5.目标方法出异常---->"+ex.getMessage());
		//TODO:记录异常信息...
		//Logger logger=Logger.getLogger();
		//logger.error(ex.getMessage());----->异常信息记录到了日志文件中---->将该日志文件上传到服务器.
	}
	
	//后置通知方法.
	public void afterMethod(Object value){
		System.out.println("4.后置通知方法--->返回值是:"+value);
	}
	
	//最终通知方法:无论目标方法执行过程中是否产生了异常,该方法都会执行!
	public void commit(){
		System.out.println("5.最终通知方法---->提交事务...");
	}
}
