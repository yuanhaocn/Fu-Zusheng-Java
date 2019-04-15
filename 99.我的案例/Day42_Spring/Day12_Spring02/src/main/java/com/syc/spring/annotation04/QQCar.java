package com.syc.spring.annotation04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Component("qq")
@Service("qq")
public class QQCar implements Car {

	@Value("qq")
	private String logo;
	
	public void move() {
		System.out.println("QQ开动了...");
	}

	public void showLogo() {
		System.out.println(logo);
	}

}
