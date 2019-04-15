package com.syc.annotation;

//ORM:对象关系模型,Hibernate,MyBatis等数据库框架都是ORM框架.
//O:Object------->new Person()---P:对象
//R:Relation----->关系表,person表.
//M:Model------>Person类与person表之间的映射关系模型.

@TableName(value = "person")
public class Person {

	@ID(isAutoIncrement = true)
	@Column("id")
	private int id;
	@Column("name")
	private String name;
	@Column("sex")
	private String sex;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
