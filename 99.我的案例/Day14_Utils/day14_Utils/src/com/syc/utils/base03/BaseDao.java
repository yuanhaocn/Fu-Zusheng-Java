package com.syc.utils.base03;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.syc.utils.JdbcUtil;

/**
 * 进行数据库CRUD操作的通用的父类.
 * 
 * @类名称:BaseDao
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午3:26:27
 */
public class BaseDao {

	/**
	 * 通过的更新方法: insert,update,delete都可以通过调用这个方法来实现.
	 * 
	 * @方法名称:update
	 * @创建时间:2017年7月13日 下午3:29:26
	 * @返回类型:void
	 */
	public int update(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			// 参数元数据
			ParameterMetaData parameterMetaData = stmt.getParameterMetaData();
			// 获取参数数量
			int parameterCount = parameterMetaData.getParameterCount();

			if (params != null && params.length > 0) {
				for (int i = 0; i < parameterCount; i++) {
					// 参数的索引是从1开始的;
					// 数组的小标是从0开始的.
					stmt.setObject(i + 1, params[i]);
				}
			}

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

	// 通用的查询方法
	// 元数据;
	// 考虑返回值类型;
	// 考虑问题:
	// ①.返回值:List<Map<>>,List<Set<>>;List<T>...
	// ②.T t=new T();---->反射,clazz---->clazz.newInstance();
	// ③.元数据...
	public <T> List<T> query(String sql, Object[] params, Class<T> clazz) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			// 获取参数元数据
			ParameterMetaData parameterMetaData = stmt.getParameterMetaData();
			// 参数数量
			int parameterCount = parameterMetaData.getParameterCount();

			if (params != null && params.length > 0) {
				for (int i = 0; i < parameterCount; i++) {
					// 给参数赋值
					stmt.setObject(i + 1, params[i]);
				}
			}

			// 得到结果集
			rs = stmt.executeQuery();

			// 得到结果集元数据
			ResultSetMetaData metaData = rs.getMetaData();
			// 得到列的数量
			int columnCount = metaData.getColumnCount();

			List<T> list = new ArrayList<>();

			while (rs.next()) {
				// 利用反射,通过字节码创建该字节码的对象.
				// Object obj=new Object();
				//User usr=new User();
				T t = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {
					// 根据索引得到列名
					String columnName = metaData.getColumnName(i + 1);
					// 根据列名得到列号
					Object value = rs.getObject(columnName);

					// 对util.Date类型进行转换
					ConvertUtils.register(new DateLocaleConverter(), Date.class);

					// 将数据封装到T对象中.
					BeanUtils.copyProperty(t, columnName, value);
				}

				// 将对象添加到集合中.
				list.add(t);
			}

			return list;
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
