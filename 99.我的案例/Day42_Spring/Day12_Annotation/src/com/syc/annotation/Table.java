package com.syc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义的注解,必须添加元注解!
//元注解:作用在注解上的注解.
//@Retention:保留策略,也就是注解的生命周期.
//SOURCE:表示该注解只能存留在java的源文件中.预编译
//CLASS:表示该注解能存活到编译阶段.
//RUNTIME:表示该注解能存活到运行阶段.
//获取注解的值的一般是在运行时,通过反射来获取,但是反射效率低,所以可能会影响用户体验.
//所以此时把获取注解值的时机提前,提前到java代码的编译阶段,source阶段,
//对于程序员来说,编译速度会降低,但是能够提高后期的运行速度.

//@Target:作用范围,表明该注解是作用哪个地方.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {

	//长得像方法,但是功能类似于属性!
	String value() default "";
	
}
