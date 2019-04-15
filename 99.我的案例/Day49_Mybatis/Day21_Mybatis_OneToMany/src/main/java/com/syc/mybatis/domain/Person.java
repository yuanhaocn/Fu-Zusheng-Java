package com.syc.mybatis.domain;

/*
 * Person类属于一对多中的多!
 */
public class Person {

	private Integer id;
	private String name;
	private String nickname;
	//private Grade grade;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
