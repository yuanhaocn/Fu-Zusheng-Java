package com.syc.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

@SuppressWarnings({ "deprecation" })
public class QBCTest {

	// 执行原生的SQL语句.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		// 获取原生的Query对象.
		String sql = "select * from empl";
		// NativeQuery query = session.createSQLQuery(sql);
		SQLQuery query = session.createSQLQuery(sql);

		// List<Object> list = query.list();
		// 将默认的Object对象转换为Employee对象.
		query.addEntity(Employee.class);

		List<Employee> list = query.list();
		for (Employee empl : list) {
			System.out.println("name=" + empl.getName());
		}

		session.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();

		// Criteria createCriteria = session.createCriteria("");
		Criteria criteria = session.createCriteria(Employee.class);
		// Criteria,条件.add()方法用来添加条件.

		// 查询id=5的数据
		// criteria.add(Restrictions.idEq(5L));

		// 查询工资大于30000的人
		// gt:greater than
		// lt:less than
		// le:less equal
		// ge:greater equal
		// criteria.add(Restrictions.gt("salery", 3000.0));
		// eq:equal
		// criteria.add(Restrictions.eq("salery", 3000.0));
		// ne就是not equal
		// criteria.add(Restrictions.ne("salery", 3000.0));

		// 排序,降序
		// criteria.addOrder(Order.asc("salery"));
		// criteria.addOrder(Order.desc("salery"));

		// 模糊查询
		// criteria.add(Restrictions.like("name", "%宋%"));

		// 在某个范围内查询
		// criteria.add(Restrictions.between("salery", 1000.0, 5000.0));
		// criteria.add(Restrictions.in("id", new Long[]{2L,3L,5L,8L,9L,10L}));

		List<Employee> list = criteria.list();

		for (Employee empl : list) {
			System.out.println("name=" + empl.getName() + ",salery=" + empl.getSalery());
		}

		session.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();

		Criteria criteria = session.createCriteria(Employee.class);

		//方法链调用!
		//当我们要做很多设置的时候,就可以把我们的代码设计方法链的形式.
		List<Employee> list = criteria.add(Restrictions.gt("salery", 1000.0))
				.add(Restrictions.like("name", "%宋%"))
				.addOrder(Order.asc("salery")).list();

		for (Employee empl : list) {
			System.out.println("name=" + empl.getName() + ",salery=" + empl.getSalery());
		}

		session.close();
	}
}
