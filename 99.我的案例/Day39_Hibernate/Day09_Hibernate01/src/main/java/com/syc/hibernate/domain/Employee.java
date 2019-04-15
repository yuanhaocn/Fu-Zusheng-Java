package com.syc.hibernate.domain;

/**
 * Employee与empl表相匹配. Employee类中的属性与empl表中的列相匹配. Employee类的每一个对象,对应着empl表的每一行.
 */
public class Employee {

	//注意:在Hibernate或者Mybatis框架中,JavaBean中的属性类型,最好都是包装类型.
	private long id;//Long
	private String name;
	private String job;
	private double salery;//Double

	public Employee() {
	}

	public Employee(long id, String name, String job, double salery) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.salery = salery;
	}

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
