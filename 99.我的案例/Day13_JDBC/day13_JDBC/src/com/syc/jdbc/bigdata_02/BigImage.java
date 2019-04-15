package com.syc.jdbc.bigdata_02;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.syc.jdbc.JdbcUtil;

public class BigImage {

	@Test
	public void insertImage() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into bigData (img) values(?)";
			stmt = conn.prepareStatement(sql);
			// 将图片以输入流的形式来返回
			InputStream stream = BigImage.class.getResourceAsStream("mn.jpg");
			// 存储二进制类型
			stmt.setBinaryStream(1, stream);
			stmt.executeUpdate();
			stream.close();
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
	public void queryImage() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select img from bigData where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 3);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				InputStream stream = rs.getBinaryStream("img");
				File file = new File("C://NewJava/mn.jpg");
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				int len = 0;
				byte[] buffer = new byte[1024];
				while ((len = stream.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
				}
				bos.close();
				stream.close();
			}
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
}
