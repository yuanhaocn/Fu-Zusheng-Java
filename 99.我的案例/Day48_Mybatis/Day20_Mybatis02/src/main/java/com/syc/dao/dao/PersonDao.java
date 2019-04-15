package com.syc.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.syc.dao.domain.Person;
import com.syc.dao.utils.MybatisUtil;

public class PersonDao {

	public List<Person> findByPage(int start, int size) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			// 注意:该集合的key,应该与对应的标签中,相关的列名一致!
			map.put("start", start);
			map.put("size", size);
			return session.selectList(Person.class.getName() + ".findByPage", map);
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

	public List<Person> findByPageWithLike(String name, int start, int size) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			// 注意:该集合的key,应该与对应的标签中,相关的列名一致!
			map.put("name", name);
			map.put("start", start);
			map.put("size", size);
			return session.selectList(Person.class.getName() + ".findByPageWithLike", map);
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

	public List<Person> findByCondition(String name, String nickname) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("nickname", nickname);
			return session.selectList(Person.class.getName() + ".findByCondition", map);
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

	public int updateDynamic(String pid, String name, String nickname) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pid", pid);
			map.put("name", name);
			map.put("nickname", nickname);
			return session.update(Person.class.getName() + ".updateDynamic", map);
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

	public int deleteDynamic(Person person) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.delete(Person.class.getName() + ".deleteDynamic", person);
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

	// 批量删除
	public int deleteByArray(int... ids) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.delete(Person.class.getName() + ".deleteByArray", ids);
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

	public int deleteByList(List<Integer> ids) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();

			return session.delete(Person.class.getName() + ".deleteByList", ids);
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

	public int insertDynamic(String name, String nickname) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("nickname", nickname);
			return session.insert(Person.class.getName()+".insertDynamic", map);
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
