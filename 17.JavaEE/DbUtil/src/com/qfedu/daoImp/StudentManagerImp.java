package com.qfedu.daoImp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qfedu.domain.Student;
import com.qfedu.util.C3P0Util;

public class StudentManagerImp {
	private Connection connection = C3P0Util.getConnection();
	public void handleAge() {
		QueryRunner queryRunner = new QueryRunner();
		String sql1="select max(age) from student";
		String sql2="select min(age) from student";
		String sql3="select avg(age) from student";
		try {
			//注意ScalarHandler在处理不同问题上泛型是不一样的
			Integer max = queryRunner.query(connection, sql1, new ScalarHandler<Integer>());
			System.out.println("最大的年龄是"+max);
		
			Integer min = queryRunner.query(connection, sql2, new ScalarHandler<Integer>());
			System.out.println("最小的年龄是"+min);		
			
			BigDecimal avg = queryRunner.query(connection, sql3, new ScalarHandler<BigDecimal>());
			System.out.println("平均的年龄是"+avg);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	  
	SELECT *		FROM student 	WHERE sname LIKE '_i%';
	SELECT *		FROM student 	WHERE sname LIKE '___';
	 */
	public List<Map<String, Object>> mohuSelectStudent(String name){
		QueryRunner queryRunner = new QueryRunner();
		//构建SQL语句
		String sql="select * from student where name like ?";
		//执行sql语句
		List<Map<String, Object>> query=null;
		try {
			//每条记录封装到map集合里面，因为有多条记录，所有外面是list集合
			query = queryRunner.query(connection, sql, new MapListHandler(),"%"+name+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return query;
	}
	
}








