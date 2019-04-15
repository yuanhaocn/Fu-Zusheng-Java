package com.syc.freemarker;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Integer age;
	private Float height;
	private Date birthday;

	public User() {}

	public User(Integer id, String name, Integer age, Float height, Date birthday) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
