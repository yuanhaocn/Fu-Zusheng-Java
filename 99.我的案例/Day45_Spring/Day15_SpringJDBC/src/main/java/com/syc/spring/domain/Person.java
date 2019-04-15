package com.syc.spring.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Person implements RowMapper<Person> {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 遍历结果集,将结果集的每一行数据取出来,封装为一个对象!
	// 返回封装好的每个对象!
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p=new Person();

		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));

		return p;
	}

}
