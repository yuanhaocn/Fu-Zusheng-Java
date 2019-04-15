package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Student;

public interface StudentHandle {
	//这里的方法名字一般和sql一致
		public void insertStudent(Student student);
		
		public Student selectStudentByNumber(String number);
		
		public List<Student> selectStduents();
}
