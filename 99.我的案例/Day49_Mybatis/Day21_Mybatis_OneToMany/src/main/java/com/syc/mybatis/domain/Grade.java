package com.syc.mybatis.domain;

import java.util.List;

/*
 * 一对多关系中的一.
 */
public class Grade {

	private Integer id;
	private String name;
	private List<Person> persons;//关联维护的person对象

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

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
