package com.syc.spring.construct09;

public class Car {

	private String name;
	private AudiCar audi;

	//通过构造方法传参来给属性赋值----依赖注入
	public Car(String name, AudiCar audi) {
		this.name = name;
		this.audi = audi;
	}

	public Car() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AudiCar getAudi() {
		return audi;
	}

	public void setAudi(AudiCar audi) {
		this.audi = audi;
	}

}
