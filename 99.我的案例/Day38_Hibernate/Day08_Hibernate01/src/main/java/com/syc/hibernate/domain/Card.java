package com.syc.hibernate.domain;

/*
 * 双向的一对一关系
 */
public class Card {

	private int cid;
	private String num;

	private Person person;//体现与Person类的一对一关系

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
