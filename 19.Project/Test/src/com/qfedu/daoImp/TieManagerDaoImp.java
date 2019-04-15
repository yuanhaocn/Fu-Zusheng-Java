package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qfedu.dao.TieManagerDao;
import com.qfedu.domain.SendTie;
import com.qfedu.util.C3P0Util;

public class TieManagerDaoImp implements TieManagerDao {
 Connection conn=C3P0Util.getConnection();
	@Override
	public List<SendTie> selectAllTie() {
		String sql="select * from send_tie";
		QueryRunner queryRunner = new QueryRunner();
		List<SendTie> query=null;
		try {
			query = queryRunner.query(conn, sql, new BeanListHandler<SendTie>(SendTie.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return query;
	}
	
}
