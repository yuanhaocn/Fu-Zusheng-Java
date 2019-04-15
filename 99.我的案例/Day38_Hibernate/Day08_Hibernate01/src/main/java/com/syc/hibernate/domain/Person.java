package com.syc.hibernate.domain;

public class Person {

	private int id;
	private String name;

	private Card card;// 体现与Card类的一对一关系

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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
