package com.syc.spring.annotation03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//默认情况下,一旦某个类添加了@Component注解,Spring框架会自动以当前的类名为该bean的id值.
//但是该名称首字母会小写,例如audiCar!
//如果@Component注解赋值了,那么此时赋的值就是该类的id.
@Component("audi")
public class AudiCar {

	// 给字符串属性注入值!
	@Value("奥迪")
	private String logo;

	public String getLogo() {
		return logo;
	}

}
