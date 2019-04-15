package com.findu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.findu.dao.GoodsDAO;
import com.findu.entity.G;
import com.findu.entity.U;

public class test {
	@Test
	public void test1() throws SQLException{
		/*Connection conn=null;
		PreparedStatement ps=null;
		
		conn=C3P0Utils.getConnection();
		
		System.out.println(conn);*/
		
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		List<U> list=qr.query("select * from user", new BeanListHandler<U>(U.class));
		
		System.out.println(list.size());
		
		for(U u:list){
			System.out.println(u);
		}
	}
	
	@Test
	public void test2() throws SQLException{
		
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		List<Object[]> list=qr.query("select * from user", new ArrayListHandler());
		
		System.out.println(list.size());
		
		for(Object[] u:list){
			for(Object o:u){
				System.out.println(o);
			}
		}
	}
	
	@Test
	public void test3() throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		List<G> list=qr.query("select * from good", new BeanListHandler<G>(G.class));
		
		System.out.println(list.size());
		
		for(G u:list){
			System.out.println(u);
		}
		
		System.out.println(GoodsDAO.count());
	}
	
	@Test
	public void test4() throws SQLException{
		GoodsDAO dao=new GoodsDAO();
		List<G> list=dao.searchGoodByName(1, 10, "1");
		
		System.out.println(list.size());
		
		for(G o:list){
			System.out.println(o);
		}
			
		System.out.println(GoodsDAO.searchCount("1"));
	}
	
	@Test
	public void test5() throws SQLException{
		GoodsDAO dao=new GoodsDAO();
		List<G> list=dao.searchGoodInType(1, 10, "1",6);
		
		System.out.println(list.size());
		
		for(G o:list){
			System.out.println(o);
		}
			
		System.out.println(GoodsDAO.searchTypeCount("1", 6));
	}
	
	@Test
	public void test6() throws ClassNotFoundException, SQLException{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/���ݿ���";
		String username="���ݿ��¼�� Ĭ��Ϊroot";
		String password="���ݿ���������";
		
		//��������
		Class.forName(driver);
		
		//�������
		Connection conn=DriverManager.getConnection(url,username,password);
		
		//����sql���
		PreparedStatement st=conn.prepareStatement("select * from ����");
		
		//ִ�в�ѯ ��ý����
		ResultSet rs=st.executeQuery();
		
		//���ݿ����������� ���������������
		//����ѭ����ò�ѯ�����������
		while(rs.next()){
			rs.getInt("id");//���id�ֶ�
		}
	}
}
