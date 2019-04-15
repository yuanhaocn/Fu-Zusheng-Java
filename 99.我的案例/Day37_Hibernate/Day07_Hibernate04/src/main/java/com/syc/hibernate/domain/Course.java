package com.syc.hibernate.domain;

import java.util.Set;

/**
 * 一个学生只能选一门课; 一门课可以被多个学生来选修. Course:一 Student:多
 */
public class Course {

	private int cid;
	private String name;
	//该集合,用来体现与学生之间的关系.
	private Set<Student> students;

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
