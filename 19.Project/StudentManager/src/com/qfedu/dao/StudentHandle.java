package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Student;

public interface StudentHandle {
	//����ķ�������һ���sqlһ��
		public void insertStudent(Student student);
		
		public Student selectStudentByNumber(String number);
		
		public List<Student> selectStduents();
}
