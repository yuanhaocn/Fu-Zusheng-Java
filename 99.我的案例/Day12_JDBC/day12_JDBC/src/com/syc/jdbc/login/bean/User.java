package com.syc.jdbc.login.bean;

/**
 * JavaBean
 * @类名称:User
 * @创建人:SYC
 * @创建时间:2017年7月12日 上午9:49:45
 */
public class User {
	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
