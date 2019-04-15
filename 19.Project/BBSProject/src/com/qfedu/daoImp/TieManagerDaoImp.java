package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qfedu.dao.TieManagerDao;
import com.qfedu.domain.ReplayTie;
import com.qfedu.domain.SendTie;
import com.qfedu.util.C3P0Util;

public class TieManagerDaoImp implements TieManagerDao{
	private Connection connection = C3P0Util.getConnection();
 	@Override
	public void insertTie(SendTie sendTie) {
		//������
 		String sql1 = "insert into send_tie(theme,sendcontent,senduser,sendtime,updatetime) VALUES(?,?,?,?,?)";
		//�޸����
 		String sql2 = "update user_info set sendnumber = sendnumber+1 where username=?";
 		//��ȡqr����
 		QueryRunner queryRunner = new QueryRunner();
 		try {
 			//��������
			connection.setAutoCommit(false);
			//ִ������sql
			queryRunner.update(connection,sql1,sendTie.getTheme(),sendTie.getSendContent(),sendTie.getSendUser(),sendTie.getSendTime(),sendTie.getUpdateTime());
			queryRunner.update(connection,sql2,sendTie.getSendUser());
			//�ύ����
			connection.commit();
 		} catch (SQLException e) {
			try {
				//����ع�
				connection.rollback();
			} catch (SQLException e1) {
				
			}
		}
 		
	}
	@Override
	public List<SendTie> selectTiesByUsername(String username) {
		String sql = "select * from send_tie where senduser = ?";
		QueryRunner queryRunner = new QueryRunner();
		List<SendTie> tieList = null;
		try {
			tieList = queryRunner.query(connection, sql, new BeanListHandler<SendTie>(SendTie.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tieList;
	}
	
	
	
	@Override
	public void deleteTieByTieId(Integer tieId,String username) {
		String sql1 = "delete from send_tie where tieId = ?";
		String sql2 = "update user_info set sendnumber=sendnumber-1 where username=?";
		QueryRunner queryRunner = new QueryRunner();
		try {
			connection.setAutoCommit(false);
			queryRunner.update(connection, sql1,tieId);
			queryRunner.update(connection, sql2,username);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	@Override
	public void updateTieFzs(SendTie sendTie) {
//	��sendTie������µ����ݿ�`send_tie`��
		String sql="update send_tie set theme=?,sendcontent=?,updatetime=? where tieid=?";
		QueryRunner queryRunner = new QueryRunner();
	/*	System.out.println(sendTie);
		System.out.println(queryRunner);
		System.out.println(connection);*/
		try {
			queryRunner.update(connection, sql,sendTie.getTheme(),sendTie.getSendContent(),sendTie.getUpdateTime(),sendTie.getTieId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<ReplayTie> selectReplayTiesByUsername(String username) {
		String sql = "SELECT `reply_tie`.* , `send_tie`.`theme` FROM `reply_tie` INNER JOIN `send_tie`  ON (`reply_tie`.`tieid` = `send_tie`.`tieid`) WHERE  `reply_tie`.`replyuser`=?";
		QueryRunner queryRunner = new QueryRunner();
		List<ReplayTie> tieList = null;
		try {
			tieList = queryRunner.query(connection, sql, new BeanListHandler<ReplayTie>(ReplayTie.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tieList;
	}

}
