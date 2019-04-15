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
//		���÷�����ȡ����������
		List<Student> student = smdi.selectAllStudents(thisPage, pageSize);
		 int number = smdi.selectNumberOfStudents();
//		��װ��Դ��dao�������
		 page.setStudentList(student);
		 page.setCountNumber(number);
//		 ��װ��ǰҳ��Ϣ��ҳ���С
		 page.setThisPage(thisPage);
		 page.setPageSize(pageSize);
		return page;
	}
}
