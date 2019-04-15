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
			//ע��ScalarHandler�ڴ���ͬ�����Ϸ����ǲ�һ����
			Integer max = queryRunner.query(connection, sql1, new ScalarHandler<Integer>());
			System.out.println("����������"+max);
		
			Integer min = queryRunner.query(connection, sql2, new ScalarHandler<Integer>());
			System.out.println("��С��������"+min);		
			
			BigDecimal avg = queryRunner.query(connection, sql3, new ScalarHandler<BigDecimal>());
			System.out.println("ƽ����������"+avg);		
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
		//����SQL���
		String sql="select * from student where name like ?";
		//ִ��sql���
		List<Map<String, Object>> query=null;
		try {
			//ÿ����¼��װ��map�������棬��Ϊ�ж�����¼������������list����
			query = queryRunner.query(connection, sql, new MapListHandler(),"%"+name+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return query;
	}
	
}








