package com.syc.spring.lazyinit04;

public class Car {

	public Car(){
		System.out.println("构造方法...");
	}
	
	public void move(){
		System.out.println("汽车动了...懒加载");
	}
}
