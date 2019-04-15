package com.syc.spring.iocdi08;

public class CarFactory {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void move() {
		car.move();
	}

	public void showLogo() {
		car.showLogo();
	}
}
