package com.syc.utils.queryrunner04;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.syc.utils.bean.User;

public interface ResultSetHandlerDemo {

	public User handle(ResultSet rs) throws SQLException;
}
