package com.syc.hibernate.domain;

import java.util.Set;

/*
 * 多对多关系.
 * 一个学生对应多门课程.
 */
public class Student {

	private int sid;
	private String name;
	private Set<Course> courses;//体现与课程之间的关系

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
