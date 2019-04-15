package com.syc.annotation;

/**
 * ORM映射:
 * O:Person类的对象
 * R:通过注解来配置关系表和里面的列
 */
@Table(value = "person")
public class Person {

	@ID(isAutoIncrement = true)
	@Column("id")
	private int id;

	@Column("name")
	private String name;
	@Column("gender")
	private String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
