package com.syc.spring.car02;

public class InstanceCarFactory {

	//实例工厂中的方法是非静态的!
	public Car createCar() {
		return new Car();
	}
}
