package com.qfedu.dao;

import java.util.List;

import com.qfedu.domain.Student;

public interface StudentManagerDao {
//²éÑ¯¼ÇÂ¼Êý
	public List<Student> selectAllStudents(int thisPage,int pageSize);
	public int selectNumberOfStudents();
}
