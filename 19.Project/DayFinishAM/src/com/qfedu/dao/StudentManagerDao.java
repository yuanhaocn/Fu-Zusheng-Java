package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Student;

public interface StudentManagerDao {
//��ѯ��¼��
	public List<Student> selectAllStudents(int thisPage,int pageSize);
	public int selectNumberOfStudents();
}
