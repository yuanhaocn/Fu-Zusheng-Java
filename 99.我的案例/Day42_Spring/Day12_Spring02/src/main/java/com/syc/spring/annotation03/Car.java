package com.syc.spring.annotation03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//该类的id是car
@Component
public class Car {

	@Autowired
	@Qualifier("audi")
	private AudiCar car;// 必须给car属性注入值!

	public AudiCar getCar() {
		return car;
	}

}
