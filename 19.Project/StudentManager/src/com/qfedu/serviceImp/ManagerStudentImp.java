package com.qfedu.serviceImp;

import java.util.List;

import com.qfedu.dao.StudentHandle;
import com.qfedu.domain.Student;
import com.qfedu.service.ManagerStudent;
public class ManagerStudentImp implements ManagerStudent {
	// ��ҪdaoImp�Ķ���
	private StudentHandle sh;
	//��action�㴫������ʵ�֣�������̬
	public StudentHandle getSh() {return sh;}
	public void setSh(StudentHandle sh) {this.sh = sh;}

	@Override
	public void addStudent(String number,String name,Integer age) {
		Student student = new Student();
		student.setName(name);
		student.setNumber(number);
		student.setAge(age);
		sh.insertStudent(student);
	}

	@Override
	public Student getStudentByNumber(String number) {
		Student student = sh.selectStudentByNumber(number);
		return student;
	}

	@Override
	public List<Student> getAllStduent() {
		List<Student> list = sh.selectStduents();
		return list;
	}



}
