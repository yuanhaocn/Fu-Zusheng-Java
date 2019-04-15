package cn.itheima.c_cache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

//测试一级缓存
public class Demo {

	@Test
	//证明一级缓存存在
	public void fun1(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
//		当数据库记录存在的时候就会只执行一次，如果没有记录就会执行5次
		Customer c1 = session.get(Customer.class, 1l);
		Customer c2 = session.get(Customer.class, 1l);
		Customer c3 = session.get(Customer.class, 1l);
		Customer c4 = session.get(Customer.class, 1l);
		Customer c5 = session.get(Customer.class, 1l);
		
		System.out.println(c3==c5);//true
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
	}
	
	@Test
	//一级缓存之快照的验证
	public void fun2(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		
		Customer c1 = session.get(Customer.class, 1l);
		//比较快照中的数据，迂回修改就没有变换，所以不存在update操作，就一条查询操作
		c1.setCust_name("哈哈");
		c1.setCust_name("传智播客");
		
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
	
	@Test
	//持久化状态对象其实就是放入session缓存中的对象
	public void fun3(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		
		Customer c1 = new Customer();
		c1.setCust_id(1l);//托管|游离
		
		session.update(c1);//c1被放入session缓存了
		
		
		Customer c2 = session.get(Customer.class, 1l);
		
		//4提交事务.关闭资源---》》》不用save就可以了，因为save是将瞬时态转为持久态，本身就是持久态就不需要了
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
	}
}
