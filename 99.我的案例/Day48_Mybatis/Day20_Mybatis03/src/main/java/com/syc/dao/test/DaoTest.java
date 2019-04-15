package com.syc.dao.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.syc.dao.domain.Person;
import com.syc.dao.mapper.PersonMapper;
import com.syc.dao.utils.MybatisUtil;

public class DaoTest {

	@Test
	public void findByIdTest() {
		SqlSession session = MybatisUtil.getSession();

		// 利用动态代理,来创建一个PersonMapper对象,
		// PersonMapper对象=代理类+目标类
		PersonMapper mapper = session.getMapper(PersonMapper.class);

		Person person = mapper.findById(30);

		System.out.println("person=" + person.getName());
		session.close();

		// PersonMapper mapper = getMapper(PersonMapper.class);
	}

	/*
	 * public PersonMapper getMapper(Class<?> clazz) { return
	 * (PersonMapper)Proxy.newProxyInstance(clazz.getClassLoader(),
	 * clazz.getInterfaces(), new InvocationHandler() {
	 * 
	 * public Object invoke(Object proxy, Method method, Object[] args) throws
	 * Throwable {
	 * 
	 * // xxx处理
	 * 
	 * return null; } }); }
	 */
	
	@Test
	public void findByNameTest(){
		SqlSession session = MybatisUtil.getSession();
		
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		
		Person person = mapper.findByName("马林");
		System.out.println("name="+person.getName());
		
		session.close();
	}
	
	@Test
	public void findAllTest(){
		SqlSession session = MybatisUtil.getSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Person> persons = mapper.findAll();
		for(Person person : persons){
			System.out.println("name="+person.getName());
		}
		session.close();
	}
}
