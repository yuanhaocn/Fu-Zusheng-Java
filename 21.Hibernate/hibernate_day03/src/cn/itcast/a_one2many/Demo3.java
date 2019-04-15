package cn.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.HibernateUtils;
/**
 * 操作进阶之关系维护
 */

public class Demo3 {
	@Test
	/*
	 * 保存客户 以及客户 下的联系人
	 * 
 customer的配置：
	  <!-- inverse属性: 配置关系是否维护. 
		  		true: customer不维护关系
		  		false(默认值): customer维护关系
		  		
		  	inverse属性: 性能优化.提高关系维护的性能.
		  	原则: 无论怎么放弃,总有一方必须要维护关系.
		  	一对多关系中: 一的一方放弃.也只能一的一方放弃.多的一方不能放弃.
		  -->
		<set name="linkMens" inverse="true" >
			<key column="lkm_cust_id" ></key>
			<one-to-many class="LinkMan" />
		</set>

LinkMan的配置
	<many-to-one name="customer" column="lkm_cust_id" class="Customer"  ></many-to-one>

解释：如果是customer来维护主键，则插入一条customer记录，两条LinkMan记录要维护两次主键，如果用了inverse则只要维护一次
主键，性能优化了
	 */
	public void fun1(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		Customer c = new Customer();
		c.setCust_name("传智播客");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黎活明");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("刘悦东");
		
		//表达一对多,客户下有多个联系人. 
		// 如果客户放弃维护与联系人的关系. 维护关系的代码可以省略
		//c.getLinkMens().add(lm1);
		//c.getLinkMens().add(lm2);
		
		//表达对对对,联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		
		session.save(c);
		session.save(lm1);
		session.save(lm2);
		
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	
	@Test
	/*
	 * 删除客户
	 * 
第一种配置：
customer配置
	 *<set name="linkMens" inverse="false" >
			<key column="lkm_cust_id" ></key>
			<one-to-many class="LinkMan" />
		</set>
LinkMan配置
		<many-to-one name="customer" column="lkm_cust_id" class="Customer"  ></many-to-one>
这种情况会将联系人表的外键设为空，客户表的记录删除

第二种配置：
customer配置
	 *<set name="linkMens" inverse="true" cascade="delete" >
			<key column="lkm_cust_id" ></key>
			<one-to-many class="LinkMan" />
		</set>
LinkMan配置
		<many-to-one name="customer" column="lkm_cust_id" class="Customer"  ></many-to-one>
这种情况会将客户和其联系人都一起删除
	 */
	public void fun2(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 开启事务
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3操作
		Customer customer = session.get(Customer.class, 1l);
		
		session.delete(customer);
		//-------------------------------------------------
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
		
}
