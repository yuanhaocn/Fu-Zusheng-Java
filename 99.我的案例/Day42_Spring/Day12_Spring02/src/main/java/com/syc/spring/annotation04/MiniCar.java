package com.syc.spring.annotation04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

//@Controller:web层的注解
//@Component("mini")
@Controller("mini")
public class MiniCar implements Car {

	@Value("mini")
	private String logo;
	
	public void move() {
		System.out.println("Mini开动了...");
	}

	public void showLogo() {
		System.out.println(logo);
	}

}
