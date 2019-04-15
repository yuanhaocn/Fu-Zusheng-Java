package com.syc.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.syc.mybatis.domain.Grade;
import com.syc.mybatis.domain.Person;
import com.syc.mybatis.utils.MybatisUtil;

public class PersonDao {

	// 根据id进行查询
	public List<Person> findPesonsByGradeName(String name) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.selectList(Person.class.getName() + ".findPesonsByGradeName", name);
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

	public Grade findGradeByPersonName(String name) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.selectOne(Grade.class.getName() + ".findGradeByPersonName", name);
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
