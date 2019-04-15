package com.syc.hibernate.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.syc.hibernate.domain.Customer;
import com.syc.hibernate.domain.Order;
import com.syc.hibernate.utils.HibernateUtil;

public class HQLTest {

	// 查询某个顾客及其订单信息
	// 写法一:SELECT * FROM orders o LEFT JOIN customer c ON c.id=o.cid WHERE
	// c.id=2;
	// 写法二:SELECT * FROM orders o, customer c WHERE o.cid=c.id AND c.id=1;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();

		// 会产生笛卡尔积,没有实际意义!
		// session.createQuery("from Customer c ,Order o");

		// Caused by: SQLGrammarException: could not extract ResultSet

		// Caused by: MySQLSyntaxErrorException: You
		// have an error in your SQL syntax;
		// check the manual that corresponds to your MySQL server version for
		// the right syntax to use
		// near 'order order1_ where customer0_.id=order1_.cid'

		Query query = session.createQuery("from Customer c ,Order o where c=o.customer");
		List<Object[]> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] objects = list.get(i);
			for (int j = 0; j < objects.length; j++) {
				Object obj = objects[j];
				if (obj instanceof Customer) {
					Customer c = (Customer) obj;
					System.out.println("c=" + c.getName());
				} else if (obj instanceof Order) {
					Order o = (Order) obj;
					System.out.println("o=" + o.getName());
				}

			}
		}

		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();

		// SELECT * FROM orders o LEFT JOIN customer c ON c.id=o.cid WHERE
		// 注意:默认就是内连接,所以不用去写inner join!
		// Query query = session.createQuery("from Customer c join Order o on
		// c=o.customer");
		// c与c自身关联的orders对象进行条件过滤
		Query query = session.createQuery("from Customer c join c.orders ");
		List<Object[]> list = query.list();

		for (int i = 0; i < list.size(); i++) {
			Object[] objects = list.get(i);
			for (int j = 0; j < objects.length; j++) {
				Object obj = objects[j];
				if (obj instanceof Customer) {
					Customer c = (Customer) obj;
					System.out.println("c=" + c.getName());
				} else if (obj instanceof Order) {
					Order o = (Order) obj;
					System.out.println("o=" + o.getName());
				}

			}
		}

		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();

		// SELECT * FROM orders o LEFT JOIN customer c ON c.id=o.cid WHERE
		// 注意:默认就是内连接,所以不用去写inner join!

		// Query query = session.createQuery("from Order o join Customer c on
		// c=o.customer");
		// c与c自身关联的orders对象进行条件过滤
		// Query query = session.createQuery("from Customer c join c.orders ");
		Query query = session.createQuery("from Order o join o.customer");

		List<Object[]> list = query.list();

		for (int i = 0; i < list.size(); i++) {
			Object[] objects = list.get(i);
			for (int j = 0; j < objects.length; j++) {
				Object obj = objects[j];
				if (obj instanceof Customer) {
					Customer c = (Customer) obj;
					System.out.println("c=" + c.getName());
				} else if (obj instanceof Order) {
					Order o = (Order) obj;
					System.out.println("o=" + o.getName());
				}

			}
		}

		session.close();
	}

	// 内连接的抓取策略
	// fetch(抓取)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();

		// fetch:可以将Object类型转换成某个具体的类型(该类型是from关键字后面的那个类!)
		Query query = session.createQuery("from Customer c join fetch c.orders ");

		List<Customer> list = query.list();

		for (Customer c : list) {
			System.out.println("name=" + c.getName() + ",订单=" + c.getOrders().size());
			Set<Order> orders = c.getOrders();
			Iterator<Order> iterator = orders.iterator();
			while (iterator.hasNext()) {
				Order order = iterator.next();
				System.out.println("order=" + order.getName());
			}
		}

		session.close();
	}

	// fetch(抓取)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();

		// fetch:可以将Object类型转换成某个具体的类型(该类型是from关键字后面的那个类!)
		Query query = session.createQuery("from Order o join fetch o.customer ");

		List<Order> list = query.list();

		for (Order o : list) {
			System.out.println("商品名称=" + o.getName() + ",客户名称=" + o.getCustomer().getName());
		}

		session.close();
	}
	
	//外连接:左外连接,右外连接
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test6() {
		Session session = HibernateUtil.openSession();

		//左外连接
		//Query query = session.createQuery("from Order o left outer join o.customer");
		//右外连接
		Query query = session.createQuery("from Order o right outer join o.customer");

		List<Object[]> list = query.list();

		for (int i = 0; i < list.size(); i++) {
			Object[] objects = list.get(i);
			for (int j = 0; j < objects.length; j++) {
				Object obj = objects[j];
				if (obj instanceof Customer) {
					Customer c = (Customer) obj;
					System.out.println("c=" + c.getName());
				} else if (obj instanceof Order) {
					Order o = (Order) obj;
					System.out.println("o=" + o.getName());
				}

			}
		}

		session.close();
	}
	
	//左,右外连接的抓取策略
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test7() {
		Session session = HibernateUtil.openSession();

		//左外连接
		//Query query = session.createQuery("from Order o left outer join fetch o.customer");
		//右外连接
		Query query = session.createQuery("from Order o right outer join fetch o.customer");

		List<Order> list = query.list();

		for(Order o: list){
			System.out.println("name="+o.getName()+",customer="+o.getCustomer().getName());
		}

		session.close();
	}
}
