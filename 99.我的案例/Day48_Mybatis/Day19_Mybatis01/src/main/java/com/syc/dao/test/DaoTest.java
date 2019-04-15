package com.syc.dao.test;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.syc.dao.dao.PersonDao;
import com.syc.dao.utils.MybatisUtil;

public class DaoTest {

	@Test
	public void test1(){
		SqlSession session = MybatisUtil.getSession();
		Connection conn = session.getConnection();
		//Mybatis中可以执行原生的SQL语句!
		if(conn!=null){
			System.out.println("数据库已建立连接!");
		}else{
			System.out.println("数据库未建立连接!");
		}
	}
	
	@Test
	public void test2(){
		PersonDao dao=new PersonDao();
		int result = dao.insertPerson();
		if(result>0){
			System.out.println("添加成功!");
		}
	}
}
