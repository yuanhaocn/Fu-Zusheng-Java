package com.syc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Driver;

public class Jdbc01 {
	
	//数据库的url地址
	private String url="jdbc:mysql://localhost:3306/db01";
	private String user="root";
	private String pass="syc";
	
	//该方式一般不用!
	//建立数据库驱动
	@Test //单元测试
	public void jdbc_conn() throws Exception{
		//之前的旧版本的Driver驱动程序.
		//Driver driver=new org.gjt.mm.mysql.Driver()
		//新版本的Driver
		//Driver driver=com.mysql.jdbc.Driver;
		//创建驱动对象
		//Driver:是MySQL包中的类.
		Driver driver=new Driver();
		//注册驱动程序
		//DriverManager:是JavaSE中自带的jdbc的包里的东西.
		//利用DriverManager.registerDriver()方法进行驱动程序注册的时候,会导致注册两次!
		//也就是说此时内存有2个Driver对象.
		DriverManager.registerDriver(driver);
		//建立数据库连接
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println(conn.toString());
	}
	
	//第二种建立驱动方式
	@Test
	public void jdbc_conn2() throws Exception{
		//建立驱动程序
		Driver driver=new Driver();
		//Properties本质上就是一个HashTable,就是一个集合
		//Properties是配置属性.
		Properties props=new Properties();
		//在HashTable中存储key-value
		props.setProperty("user", user);
		props.setProperty("password", pass);
		//建立连接
		Connection conn = driver.connect(url, props);
		System.out.println(conn.toString());
	}
	
	//第三种方式:最常用的方式
	@Test
	public void jdbc_conn3() throws Exception{
		//获取字节码的方式:
		//1.类.class,Person.class;
		//2.对象.getClass(),p.getClass();
		//3.Class.forName("类的完整路径");
		
		//通过反射的方式来进行驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println(conn.toString());
	}
}
