package com.syc.spring.transaction01.dao;

import java.sql.SQLException;

public interface IAccoutDao {

	//减钱的操作
	public void out(double money,String name) throws SQLException;
	
	//加钱的操作
	public void in(double money,String name) throws SQLException;
}
