package com.syc.ssm.dao.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.syc.ssm.dao.UserDao;
import com.syc.ssm.domain.User;
import javax.annotation.*;

//注意:继承SqlSessionDaoSupport类,必须添加Spring-JDBC的依赖包!

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport 
	implements UserDao {

	//private SqlSessionFactory sqlSessionFactory;
	
	// 必须复写该方法!
	@SuppressWarnings("restriction")
	@Resource //注意:必须添加该注解,否则会导致异常!
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public User selectByNameAndPass(User user) throws SQLException {
		return getSqlSession().selectOne(User.class.getName() + ".selectByNameAndPass", user);
	}

	public int insertUser(User user) throws SQLException {
		return getSqlSession().insert(User.class.getName() + ".insertUser", user);
	}

}
