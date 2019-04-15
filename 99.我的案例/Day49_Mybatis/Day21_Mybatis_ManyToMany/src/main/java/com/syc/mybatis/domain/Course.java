package com.syc.mybatis.domain;

/*
 * Course类,多对多中的多!
 */
public class Course {

	private Integer id;
	private String name;
	//private List<Student> students;// 关联维护的person对象

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

	// public List<Student> getStudents() {
	// return students;
	// }
	//
	// public void setStudents(List<Student> students) {
	// this.students = students;
	// }

}
