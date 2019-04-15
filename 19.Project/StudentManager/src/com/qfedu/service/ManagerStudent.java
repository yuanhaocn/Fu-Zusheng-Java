package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Student;

public interface ManagerStudent {
	public void addStudent(String number,String name,Integer age);
	
	public Student getStudentByNumber(String number);
	
	public List<Student> getAllStduent();
}
