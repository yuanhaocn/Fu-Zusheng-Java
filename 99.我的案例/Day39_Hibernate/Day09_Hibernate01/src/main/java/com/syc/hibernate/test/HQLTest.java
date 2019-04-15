package com.syc.hibernate.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.syc.hibernate.domain.Employee;
import com.syc.hibernate.utils.HibernateUtil;

public class HQLTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		// 全部查询empl表
		// SQL语句:select * from empl;
		// Query query = session.createQuery("from Employee");
		// java.lang.IllegalArgumentException:
		// org.hibernate.hql.internal.ast.QuerySyntaxException: unexpected
		// token: * near line 1, column 8 [select * from
		// com.syc.hibernate.domain.Employee]
		// QuerySyntaxException: unexpected token: * [select * from
		// com.syc.hibernate.domain.Employee]
		// 注意:HQL语法中根本没有*!
		// Query query = session.createQuery("select * from Employee");
		// Query query = session.createQuery("select e from Employee e");
		Query query = session.createQuery("select e.name,e.job from Employee e");
		// List<Employee> list = query.list();
		// List<Employee> list = query.getResultList();
		List<Object[]> list = query.getResultList();

		for (Object[] objs : list) {
			System.out.println(Arrays.toString(objs));
		}

		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();

		// 分页2种方式:
		// 1.前端负责分页:----->后端服务器直接把所有的查询结果输出给前端页面;
		// 2.后端负责分页:----->后端服务器一页一页的往外输出数据.
		Query query = session.createQuery("from Employee");
		// 起始分页地址
		query.setFirstResult(0);// 该值一般都是一个变量!
		// 每页最多有多少条目
		query.setMaxResults(5);// 该值一般都是一个变量!

		List<Employee> list = query.list();
		for (Employee empl : list) {
			System.out.println("name=" + empl.getName());
		}

		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();

		// 这种写法就相当于是调用无参的构造方法来查询!
		// Query query = session.createQuery("select e from Employee e");

		// 注意:直接明确的调用无参的构造方法来进行查询会查询异常!
		// Caused by:QuerySyntaxException: unexpected token: )
		// near line 1, column 21 [select new Employee() from
		// com.syc.hibernate.domain.Employee e]
		// Query query = session.createQuery("select new Employee() from
		// Employee e");

		Query query = session.createQuery("select new Employee(id,name,job,salery) from Employee e");
		List<Employee> list = query.list();
		for (Employee empl : list) {
			System.out.println("name=" + empl.getName());
		}

		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();

		// 第一种写法:根据id进行查询
		// session.get(Employee.class, 1);
		// session.load(Employee.class, 1);

		// 第二种写法:根据条件来进行查询,指明条件的位置.
		// Query query = session.createQuery("from Employee e where e.name=?");
		// 设置条件
		// query.setString(0, "武松");
		// query.setParameter(0, "武松");

		// 条件查询的第三种写法:根据自定义的key来赋值
		Query query = session.createQuery("from Employee e where e.name=:name and e.job=:job");
		// query.setString("name", "武松");
		query.setParameter("name", "武松");
		query.setParameter("job", "和尚");

		List<Employee> list = query.list();
		for (Employee empl : list) {
			System.out.println("name=" + empl.getName());
		}

		session.close();
	}

	@SuppressWarnings({ "rawtypes" })
	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();

		// 查询最高薪资,max(),min()
		// Query query = session.createQuery("select max(salery) from
		// Employee");
		// List<Double> list = query.list();

		// 统计薪资之和,sum(),avg()
		// Query query = session.createQuery("select sum(salery) from
		// Employee");
		// List<Double> list = query.list();

		// 统计员工的数量,count()
		Query query = session.createQuery("select count(id) from Employee");
		// List<Long> list = query.list();
		int parseInt = Integer.parseInt(query.uniqueResult().toString());
		System.out.println("数量=" + parseInt);

		// for(Long salery:list){
		// System.out.println("数量="+salery);
		// }

		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test6() {
		Session session = HibernateUtil.openSession();

		// SQL数据库:查询语句的执行顺序.
		// (1) FROM <left_table>
		// (3) <join_type> JOIN <right_table>
		// (2) ON <join_condition>
		// (4) WHERE <where_condition>
		// (5) GROUP BY <group_by_list>
		// (6) WITH {CUBE | ROLLUP}
		// (7) HAVING <having_condition>
		// (8) SELECT
		// (9) DISTINCT
		// (9) ORDER BY <order_by_list>
		// (10) <TOP_specification> <select_list>
		// 完整的sql查询语句,可以包含几部分(几个查询关键词-----11个!)?
		// 统计员工的数量,count(),asc:默认升序;desc:降序
		Query query = session.createQuery("from Employee e order by e.salery desc");
		List<Employee> list = query.list();

		for (Employee empl : list) {
			System.out.println("name=" + empl.getName() + ",salery=" + empl.getSalery());
		}

		session.close();
	}

	// 按照薪资分组,并且把薪资>=30000的人过滤出来.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test7() {
		Session session = HibernateUtil.openSession();

		Query query = session.createQuery("from Employee e group by e.salery having e.salery>=30000");
		List<Employee> list = query.list();

		for (Employee empl : list) {
			System.out.println("name=" + empl.getName() + ",salery=" + empl.getSalery());
		}

		session.close();
	}

	// 修改功能
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void test8() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		// SQL:update 表名 set 列名=新值 where 列名=条件值
		Query query = session.createQuery("update Employee e set e.job=? where e.name=?");
		// query.setString(0, "勾搭小媳妇");
		// query.setString(1, "燕青");
		query.setParameter(0, "勾搭小媳妇");
		query.setParameter(1, "燕青");

		// 修改和删除的时候,必须执行该方法.
		query.executeUpdate();

		transaction.commit();
		session.close();
	}

	// 删除功能
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void test9() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("delete Employee e where e.name=:name");
		query.setParameter("name", "武松");

		// 修改和删除的时候,必须执行该方法.
		query.executeUpdate();

		transaction.commit();
		session.close();
	}

}
