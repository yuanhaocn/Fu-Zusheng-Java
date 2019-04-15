package com.syc.spring.annotation01;

//需要手动导入
import javax.annotation.*;

public class Car {

	//@Resource:该注解是JDK1.8之后提供的,用来给引用类型(非String类型)对象赋值的注解.
	//它是根据name的值,然后去beans.xml文件中去找id等于该值的bean,然后把该bean赋值给这个对象!
	//①.Java自带;②.根据name赋值.
	// 引用id=audi的类,然后把该类对象赋值给car对象!
	@SuppressWarnings("restriction")
	@Resource(name = "audi")
	private AudiCar car;

	public AudiCar getCar() {
		return car;
	}

	public void setCar(AudiCar car) {
		this.car = car;
	}

}
