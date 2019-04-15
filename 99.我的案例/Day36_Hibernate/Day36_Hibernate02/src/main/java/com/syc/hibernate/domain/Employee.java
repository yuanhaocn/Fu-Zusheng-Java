package com.syc.hibernate.domain;

import java.io.Serializable;

/**
 * Employee是ORM中的O;
 * empl表示ORM中R.
 * @类名称:Employee
 * @创建人:SYC
 * @创建时间:2017年8月17日 上午10:32:29
 */
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//private long id;
	private String id;
	private String name;
	private String job;
	private double salery;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
