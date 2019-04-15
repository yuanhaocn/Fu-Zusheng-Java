package cn.itheima.b_state;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

//测试对象的三种状态
public class Demo {

	@Test
	//查看三种状态
	public void fun1(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Customer c = new Customer(); // 没有id, 没有与session关联 => 瞬时状态
		
		c.setCust_name("联想"); // 瞬时状态
		
		session.save(c); // 持久化状态, 有id,有关联
		
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
	
	@Test
	//三种状态特点
	//save方法: 其实不能理解成保存.理解成将瞬时状态转换成持久状态的方法
	//主键自增 : 执行save方法时,为了将对象转换为持久化状态.必须生成id值.所以需要执行insert语句生成.
	//increment: 执行save方法,为了生成id.会执行查询id最大值的sql语句.
	public void fun2(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Customer c = new Customer(); // 没有id, 没有与session关联 => 瞬时状态
		
		c.setCust_name("联想"); // 瞬时状态
		/*
		 * save的作用：瞬时状态--》》持久化状态
		 * 这一步会执行sql语句，但是执行sql语句的目的不是为了持久化数据，是为了生成一个主键的值，相当于试着插进取数据
		 * 再取回主键的值过程
		 */
		session.save(c); // 持久化状态, 有id,有关联
		
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
	
	@Test
	//三种状态特点
	// 持久化状态特点: 持久化状态对象的任何变化都会自动同步到数据库中.就是说不用update方法
	//update方法的作用：将游离|托管状态--》》持久化状态
	public void fun3(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		
		Customer c = session.get(Customer.class, 1l);//持久化状态对象
		
		c.setCust_name("微软公司");
		
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
	}
}
