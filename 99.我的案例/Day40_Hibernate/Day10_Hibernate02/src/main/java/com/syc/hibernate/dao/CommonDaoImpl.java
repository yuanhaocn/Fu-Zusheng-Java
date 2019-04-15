package com.syc.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.query.Query;

import com.syc.hibernate.utils.HibernateUtil;

/*
 * 通用的类
 */
public class CommonDaoImpl<T> implements CommonDao<T> {

	// 字节码
	private Class<T> mClazz;
	// 得到某个字节码所代表的实体类的一系列信息
	private ClassMetadata metadata;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public CommonDaoImpl() {
		// 1.Class.forName("包名+类名");
		// 2.对象.getClass();
		// 3.类名.class

		// 获取当前类的字节码:this.getClass();
		// this.getClass();
		// 获取当前类的泛型类
		Type generic = getClass().getGenericSuperclass();
		if (generic instanceof ParameterizedType) {
			ParameterizedType p = (ParameterizedType) generic;
			// 获取泛型T所代表的真正的类型
			Type[] actualTypeArguments = p.getActualTypeArguments();
			// 得到了真正类的字节码
			mClazz = (Class<T>) actualTypeArguments[0];

			// 得到类的元数据
			metadata = HibernateUtil.factory.getClassMetadata(mClazz);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> queryAll() {
		Session session = HibernateUtil.openSession();

		Query query = session.createQuery("from " + mClazz.getName());
		query.setCacheable(true);
		List<T> list = query.list();

		session.close();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> queryByCondition(Map<String, Object> conditions) {

		Session session = HibernateUtil.openSession();

		// select * from empl where 1=1 and name=? and job=?
		// select * from empl where 1=1
		StringBuilder sb = new StringBuilder();
		sb.append("from " + mClazz.getName());
		// 1=1只是为了保证select语法正确!
		sb.append(" where 1=1 ");

		for (Map.Entry<String, Object> entry : conditions.entrySet()) {
			// where 1=1 and name=:name
			sb.append("and " + entry.getKey() + "=:" + entry.getKey());
		}

		// 执行查询:from Employee where 1=1 and name=:name
		Query query = session.createQuery(sb.toString());

		//给参数赋值
		for (Map.Entry<String, Object> entry : conditions.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setCacheable(true);

		List<T> list = query.list();

		session.close();

		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object[]> queryByCondition(List<String> columns,Map<String, Object> conditions) {

		Session session = HibernateUtil.openSession();

		// select * from empl where 1=1 and name=? and job=?
		// select * from empl where 1=1
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		for(int i=0;i<columns.size();i++){
			String column = columns.get(i);
			//select name,job,salery from empl;
			if(i==columns.size()-1){
				sb.append(column);
			}else{
				sb.append(column+",");
			}
		}
		
		sb.append(" from " + mClazz.getName());
		// 1=1只是为了保证select语法正确!
		sb.append(" where 1=1 ");

		for (Map.Entry<String, Object> entry : conditions.entrySet()) {
			// where 1=1 and name=:name
			sb.append("and " + entry.getKey() + "=:" + entry.getKey());
		}

		// 执行查询:from Employee where 1=1 and name=:name
		Query query = session.createQuery(sb.toString());

		//给参数赋值
		for (Map.Entry<String, Object> entry : conditions.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setCacheable(true);

		List<Object[]> list = query.list();

		session.close();

		return list;
	}

	@SuppressWarnings("rawtypes")
	public Long getCount() {
		Session session = HibernateUtil.openSession();
		Query query = session
				.createQuery("select count(" + metadata.getIdentifierPropertyName() + ") from " + mClazz.getName());
		Long count = (Long) query.uniqueResult();
		session.close();
		return count;
	}

}
