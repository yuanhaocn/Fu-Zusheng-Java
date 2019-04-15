package com.syc.jdbc.generalkey_03;

import org.junit.Test;

public class EmploeeTest {

	@Test
	public void saveTest(){
		
		//创建部门对象
		Dept dept=new Dept();
		dept.setDname("企业合作部");
		
		//创建员工对象
		Emploee emp=new Emploee();
		emp.setEname("三呆子");
		emp.setDept(dept);
		
		//进行员工信息的保存
		EmploeeDao dao=new EmploeeDao();
		dao.save(emp);
	}
}
