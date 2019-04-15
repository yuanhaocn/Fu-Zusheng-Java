package com.syc.spring.annotation02;

import org.springframework.beans.factory.annotation.Value;

public class AudiCar {

	//@Value是Spring框架提供的,用来给String类型赋值的一个注解!
	@Value("奥迪222")
	private String logo;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
