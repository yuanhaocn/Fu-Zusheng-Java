package com.syc.pool.bonecp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jolbox.bonecp.BoneCPDataSource;

public class BoneCPDemo {

	@Test
	public void demo1() {
		/*
		 * source.setPartitionCount(3);
		 * source.setMaxConnectionsPerPartition(10);
		 * source.setAcquireIncrement(5); source.setIdleMaxAge(60);
		 * source.setReleaseHelperThreads(releaseHelperThreads);
		 */
		try {
			BoneCPDataSource source = new BoneCPDataSource();
			// 通过该方法去加载bonecp-config.xml文件.
			source.getConfigFile();

			long startTime = System.currentTimeMillis();

			Connection conn = source.getConnection();

			long endTime = System.currentTimeMillis();
			System.out.println("执行时间:" + (endTime - startTime));

			String sql = "select * from person";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("pname");
				System.out.println("name=" + name);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
