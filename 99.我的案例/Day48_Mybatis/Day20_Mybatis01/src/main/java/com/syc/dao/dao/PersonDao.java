package com.syc.dao.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.syc.dao.domain.Person;
import com.syc.dao.utils.MybatisUtil;

public class PersonDao {

	public int insertPerson() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// Mybatis中默认自动开启了事务.
			// 命名空间+某个标签的id!
			// return session.insert("com.syc.dao.domain.Person.insertPerson");

			// 简化id的引用
			return session.insert(Person.class.getName() + ".insertPerson");
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return 0;
	}

	// 带参数的添加操作
	public int insertPersonWithParams(Person person) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// 简化id的引用
			return session.insert(Person.class.getName() + ".insertPersonWithParams", person);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return 0;
	}

	// 查询全部
	public List<Person> findAll() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// 简化id的引用
			return session.selectList(Person.class.getName() + ".findAll");
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return null;
	}

	public Person findById(int pid) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// 简化id的引用
			return session.selectOne(Person.class.getName() + ".findById", pid);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return null;
	}

	public int updateById(Person person) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// 简化id的引用
			return session.update(Person.class.getName() + ".updateById", person);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return 0;
	}

	public int deleteById(Person person) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// 简化id的引用
			return session.delete(Person.class.getName() + ".deleteById", person);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return 0;
	}
	
	public int insertWithDeleteTag(Person person) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			
			// 简化id的引用
			return session.insert(Person.class.getName() + ".insertWithDeleteTag", person);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			// 提交事务
			session.commit();
			MybatisUtil.closeSession();
		}
		return 0;
	}
}
