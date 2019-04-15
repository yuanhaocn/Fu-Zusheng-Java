package com.syc.spring.jdbc01;

import java.beans.PropertyVetoException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcTemplateTest {

	@Test
	public void test1() {

		// 数据源连接池:DBCP,C3P0,Druid,BoneCP
		// C3P0--->CombopooledDataSource
		// DBCP--->BasicDataSource
		// BoneCP-->BoneCPDataSource
		// Druid--->DruidDataSource.
		//DriverManagerDataSource

		try {
			// 创建数据源:
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sql01");
			dataSource.setUser("root");
			dataSource.setPassword("syc");

			// 创建模板对象
			JdbcTemplate template = new JdbcTemplate();
			template.setDataSource(dataSource);

			// 利用模板对象直接进行CRUD操作
			// String sql="insert into empl (name,job,salery)
			// values('Tom','抓老鼠','30')";
			// int result = template.update(sql);

			// 防止SQL注入攻击
			String sql = "insert into empl (name,job,salery) values(?,?,?)";
			int result = template.update(sql, "Jim", "装老鼠", "15");

			if (result > 0) {
				System.out.println("添加成功!");
			}

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test2() {
		try {
			// 创建数据源:
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sql01");
			dataSource.setUser("root");
			dataSource.setPassword("syc");

			// 创建模板对象
			JdbcTemplate template = new JdbcTemplate();
			template.setDataSource(dataSource);

			// 修改
			// String sql = "update empl set name=? where name=?";
			// int result = template.update(sql, "NewJim", "Jim");

			// 删除
			String sql = "delete from empl where name=?";
			int result = template.update(sql, "NewJim");

			if (result > 0) {
				System.out.println("更新成功!");
			}

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test3() {
		try {
			// 创建数据源:
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sql01");
			dataSource.setUser("root");
			dataSource.setPassword("syc");

			// 创建模板对象
			JdbcTemplate template = new JdbcTemplate();
			template.setDataSource(dataSource);

			// String sql = "select * from person";
			// RowMapper
			// List<Person> persons = template.query(sql, new Person());
			// for (Person p : persons) {
			// System.out.println("id=" + p.getId() + ",name=" + p.getName());
			// }

			// 得到List<Map<String, Object>>
			// List<Map<String, Object>> maps = template.queryForList(sql);
			// for(Map<String,Object> map : maps){
			// for(Map.Entry<String, Object> entry : map.entrySet()){
			// String key = entry.getKey();
			// Object value = entry.getValue();
			// System.out.println("key="+key);
			// System.out.println("value="+value);
			// }
			// }

			// IncorrectResultSetColumnCountException:
			// Incorrect column count: expected 1, actual 2

			String sql = "select name from person";
			List<String> persons = template.queryForList(sql, String.class);
			for (String msg : persons) {
				System.out.println("mame=" + msg);
			}

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}
}
