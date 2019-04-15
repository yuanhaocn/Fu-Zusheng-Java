package com.syc.hibernate.domain;

import java.util.Set;

/*
 * 多对多关系.
 * 一门课程对应多个学生
 */
public class Course {

	private int cid;
	private String name;
	private Set<Student> students;//体现与学生之间的关系

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
