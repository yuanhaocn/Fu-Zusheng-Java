package com.syc.spring.lifecycle05;

public class Car {

	public Car(){
		System.out.println("1.构造方法...");
	}
	
	public void initCar(){
		System.out.println("2.初始化方法...");
	}
	
	public void move(){
		System.out.println("3.汽车动了...懒加载");
	}
	
	public void destroyCar(){
		System.out.println("4.销毁方法...");
	}
}
