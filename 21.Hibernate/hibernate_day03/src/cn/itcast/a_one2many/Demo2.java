package cn.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.HibernateUtils;

/**
 * 操作进阶之级联操作，
 * 级联操作:	cascade
		 		save-update: 级联保存更新
		 		delete:级联删除
		 		all:save-update+delete
		 	级联操作: 简化操作.目的就是为了少些两行代码.
 customer的配置：
 
 LinkMan的配置
 */
public class Demo2 {
	@Test
	/*
	 * 保存客户 以及客户 下的联系人
		cascade:save-update
 customer的配置：
 		<set name="linkMens"  cascade="save-update"  >
			<key column="lkm_cust_id" ></key>
			<one-to-many class="LinkMan" />
		</set>
LinkMan的配置
	<many-to-one name="customer" column="lkm_cust_id" class="Customer"  ></many-to-one>
		
	 */
	public void fun1() {
		// 1 获得session
		Session session = HibernateUtils.openSession();
		// 2 开启事务
		Transaction tx = session.beginTransaction();
		// -------------------------------------------------
		// 3操作
		Customer c = new Customer();
		c.setCust_name("传智播客");

		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黎活明");

		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("刘悦东");

		// 表达一对多,客户下有多个联系人
		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);

		// 表达对对对,联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);

		session.save(c);
		// session.save(lm1);
		// session.save(lm2);

		// -------------------------------------------------
		// 4提交事务
		tx.commit();
		// 5关闭资源
		session.close();
	}

	@Test
	/*
	 * 测试删除客户时,级联删除客户下的联系人
		cascade:delete
 customer的配置：
 		<set name="linkMens"  cascade="delete"  >
			<key column="lkm_cust_id" ></key>
			<one-to-many class="LinkMan" />
		</set>
LinkMan的配置
	<many-to-one name="customer" column="lkm_cust_id" class="Customer"  ></many-to-one>
		
	 */
	public void fun2() {
		// 1 获得session
		Session session = HibernateUtils.openSession();
		// 2 开启事务
		Transaction tx = session.beginTransaction();
		// -------------------------------------------------
		// 3操作
		// 1> 获得要操作的客户对象
		Customer c = session.get(Customer.class, 1l);
		// 2>调用delete删除客户
		session.delete(c);
		// -------------------------------------------------
		// 4提交事务
		tx.commit();
		// 5关闭资源
		session.close();
	}

	@Test
	/*
	 *  保存联系人以及联系人对应的客户
	  cascade:save-update
Customer的配置文件:
		<set name="linkMens" >
			<key column="lkm_cust_id" ></key>
			<one-to-many class="LinkMan" />
		</set>
LinkMan的配置
	<many-to-one name="customer" column="lkm_cust_id" class="Customer" cascade="save-update"></many-to-one>

	 */

	public void fun3() {
		// 1 获得session
		Session session = HibernateUtils.openSession();
		// 2 开启事务
		Transaction tx = session.beginTransaction();
		// -------------------------------------------------
		// 3操作
		Customer c = new Customer();
		c.setCust_name("北大青鸟");

		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("刘总");

		// 表达一对多,客户下有多个联系人
		c.getLinkMens().add(lm1);

		// 表达对对对,联系人属于哪个客户
		lm1.setCustomer(c);

		session.save(lm1);

		// -------------------------------------------------
		// 4提交事务
		tx.commit();
		// 5关闭资源
		session.close();
	}

}
