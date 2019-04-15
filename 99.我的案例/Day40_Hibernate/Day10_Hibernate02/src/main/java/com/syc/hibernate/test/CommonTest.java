package com.syc.hibernate.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.syc.hibernate.dao.EmployeeDaoImpl;
import com.syc.hibernate.domain.Employee;

public class CommonTest {

	@Test
	public void test1() {
		EmployeeDaoImpl impl = new EmployeeDaoImpl();
		List<Employee> empls = impl.queryAll();
		for (Employee empl : empls) {
			System.out.println("name=" + empl.getName());
		}
	}

	@Test
	public void test2() {
		EmployeeDaoImpl impl = new EmployeeDaoImpl();
		Long count = impl.getCount();
		System.out.println("count=" + count);
	}

	@Test
	public void test3() {
		EmployeeDaoImpl impl = new EmployeeDaoImpl();
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("name", "阮小八");
		// conditions.put("id", "阮小八");
		// conditions.put("job", "阮小八");
		List<Employee> empls = impl.queryByCondition(conditions);
		for (Employee empl : empls) {
			System.out.println("name=" + empl.getName() + ",job=" + empl.getJob());
		}
	}

	@Test
	public void test4() {
		EmployeeDaoImpl impl = new EmployeeDaoImpl();
		// 设置要查询的列名
		List<String> columns = new ArrayList<String>();
		columns.add("name");
		columns.add("job");
		// 设置要查询的条件
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("name", "阮小八");
		List<Object[]> list = impl.queryByCondition(columns, conditions);
		for (Object[] objs : list) {
			for (Object obj : objs) {
				System.out.println(obj.toString());
			}
		}
	}
}
