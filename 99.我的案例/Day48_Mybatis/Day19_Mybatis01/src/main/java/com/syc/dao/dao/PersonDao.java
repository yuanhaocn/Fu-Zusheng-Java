package com.syc.dao.dao;

import org.apache.ibatis.session.SqlSession;

import com.syc.dao.utils.MybatisUtil;

public class PersonDao {

	public int insertPerson() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			// Mybatis中默认自动开启了事务
			return session.insert("com.syc.dao.domain.Person.insertPerson");
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
