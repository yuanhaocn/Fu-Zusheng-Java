package com.syc.spring.annotation02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {

	//@Resource:该注解是JDK1.8之后提供的,用来给引用类型(非String类型)对象赋值的注解.
	//它是根据name的值,然后去beans.xml文件中去找id等于该值的bean,然后把该bean赋值给这个对象!
	//①.Java自带;②.根据name赋值.
	// 引用id=audi的类,然后把该类对象赋值给car对象!
	//@SuppressWarnings("restriction")
	//@Resource(name = "audi")
	
	//@Resource与@Autowired的区别:
	//@Resource是根据name名称去匹配对象;JDK1.8自带;
	//@Autowired是根据类型去匹配对象;Spring框架自带.
	
	//自动装配---->@Autowired不是根据name来匹配对应的bean,而是根据类型来匹配!
	//当我们配置了<context:annotation-config />这个属性,然后在给car属性添加@Autowired注解,
	//此时,Spring框架会自动去当前包中找所有与car类型一致的类!如果找到了该类,
	//就会将该类的一个对象赋值给这个car属性!
	//如果找不到,就会产生空指针异常!
	@Autowired
	@Qualifier("audi2")//如果既想使用Spring框架的注解,又想根据名称来注入值,就可以使用该注解!
	private AudiCar car;

	public AudiCar getCar() {
		return car;
	}

	public void setCar(AudiCar car) {
		this.car = car;
	}

}
