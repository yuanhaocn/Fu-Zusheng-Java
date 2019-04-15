package com.syc.struts;

/*
 * Model指的就是JavaBean
 * pojo类型的JavaBean
 * pojo:简单java对象.
 */
public class User {

	private String username;
	private String password;

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
