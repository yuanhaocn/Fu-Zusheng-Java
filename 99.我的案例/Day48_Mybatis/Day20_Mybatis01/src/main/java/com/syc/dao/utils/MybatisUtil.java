package com.syc.dao.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static SqlSessionFactory factory;
	// 解决资源争抢问题.
	private static ThreadLocal<SqlSession> localSessions = new ThreadLocal<SqlSession>();

	static {
		Reader reader = null;
		try {
			// 加载Mybatis的配置文件
			reader = Resources.getResourceAsReader("mybatis.xml");
			// 创建SqlSessionFactory对象.
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 获取Session对象
	public static SqlSession getSession() {
		SqlSession session = localSessions.get();
		if (session == null) {
			session = factory.openSession();
			localSessions.set(session);
		}
		return session;
	}

	// 关闭session的方法
	public static void closeSession() {
		SqlSession session = localSessions.get();
		if (session != null) {
			session.close();
			localSessions.remove();
		}
	}
}
