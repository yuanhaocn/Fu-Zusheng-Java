package com.syc.hibernate.domain;

/**
 * Employee与empl表相匹配. Employee类中的属性与empl表中的列相匹配. Employee类的每一个对象,对应着empl表的每一行.
 */
public class Employee {

	private long id;
	private String name;
	private String job;
	private double salery;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalery() {
		return salery;
	}

	public void setSalery(double salery) {
		this.salery = salery;
	}

}
