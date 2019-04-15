package com.syc.spring.annotation04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//@Repository:仓库,代表dao层的注解
//@Component("ben")
@Repository("ben")
public class BenBenCar implements Car {

	@Value("奔奔")
	private String logo;

	public void move() {
		System.out.println("奔奔开动了...");
	}

	public void showLogo() {
		System.out.println(logo);
	}

}
