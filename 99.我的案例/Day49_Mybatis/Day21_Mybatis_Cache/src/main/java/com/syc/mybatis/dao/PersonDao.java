package com.syc.mybatis.dao;

import org.apache.ibatis.session.SqlSession;

import com.syc.mybatis.domain.Card;
import com.syc.mybatis.domain.Person;
import com.syc.mybatis.utils.MybatisUtil;

public class PersonDao {

	// 根据id进行查询
	public Person findById(int id) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.selectOne(Person.class.getName() + ".findById", id);
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

	public Person findByName(String name) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.selectOne(Person.class.getName() + ".findByName", name);
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
	
	public Card findByNum(String num) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			
			return session.selectOne(Card.class.getName() + ".findByNum", num);
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
}
