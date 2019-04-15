package com.qfedu.serviceImp;

import java.util.List;

import com.qfedu.daoimp.StudentManagerDaoImp;
import com.qfedu.domain.Page;
import com.qfedu.domain.Student;
import com.qfedu.service.StudentManagerService;
import com.qfedu.util.DruidUtil;

public class StudentManagerServiceImp implements StudentManagerService {

	@Override
	public Page buildPage(int thisPage, int pageSize) {
		Page page = new Page();
		StudentManagerDaoImp smdi = new StudentManagerDaoImp();
		smdi.setConnection(DruidUtil.getConnection());
//		调用方法获取这两个参数
		List<Student> student = smdi.selectAllStudents(thisPage, pageSize);
		 int number = smdi.selectNumberOfStudents();
//		组装来源于dao层的数据
		 page.setStudentList(student);
		 page.setCountNumber(number);
//		 组装当前页信息和页面大小
		 page.setThisPage(thisPage);
		 page.setPageSize(pageSize);
		return page;
	}
}
