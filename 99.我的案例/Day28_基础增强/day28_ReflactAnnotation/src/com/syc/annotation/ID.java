package com.syc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
//作用范围:@Target
//生命周期(保留策略):@Retention
//@Target,@Retention是元注解.元注解是作用在注解上面的注解.

//保留策略3种:
//RetentionPolicy.SOURCE--->该注解只保留在.java文件;
//RetentionPolicy.CLASS--->该注解可以保留到.class文件中;
//RetentionPolicy.RUNTIME-->该注解可以保留到运行时.
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ID {
	
	boolean isAutoIncrement() default true;
}
