package com.syc.spring.annotation04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("factory")
public class CarFactory {

	@Autowired
	@Qualifier("ben")
	private Car car;

	public void move() {
		car.move();
	}

	public void showLogo() {
		car.showLogo();
	}
}
