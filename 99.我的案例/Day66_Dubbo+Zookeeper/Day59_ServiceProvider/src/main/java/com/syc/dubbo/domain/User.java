package com.syc.dubbo.domain;

import java.io.Serializable;

/**
 * JavaBean必须实现序列化,否则会产生异常!
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String sex;

	public User() {
	}

	public User(Integer id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}

}
