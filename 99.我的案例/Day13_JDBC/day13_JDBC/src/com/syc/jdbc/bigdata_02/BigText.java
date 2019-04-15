package com.syc.jdbc.bigdata_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.syc.jdbc.JdbcUtil;

public class BigText {

	@Test
	public void insertText() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into bigData (msg) values(?)";
			stmt = conn.prepareStatement(sql);
			// 获取指定的资源路径
			String path = BigText.class.getResource("info.txt").getPath();
			Reader reader = new FileReader(new File(path));
			// 指定参数
			stmt.setCharacterStream(1, reader);

			stmt.executeUpdate();

			reader.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

	@Test
	public void queryText() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select msg from bigData where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//获取大文本的方式2种:
				//Reader reader = rs.getCharacterStream("msg");
				String msg = rs.getString("msg");
				System.out.println(msg);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

}
