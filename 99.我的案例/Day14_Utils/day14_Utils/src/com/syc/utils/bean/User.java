package com.syc.utils.bean;

import java.util.Date;

/**
 * JavaBean的特征: 1.具有私有的属性; 2.具有公开的setXXX()和getXXX()方法; 3.具有构造方法.
 * 
 * @类名称:User
 * @创建人:SYC
 * @创建时间:2017年7月13日 上午10:30:41
 */
public class User {

	private int id;
	private String username;
	private String password;
	private Date birthDay;

	public User() {
	}

	public User(int id, String username, String password, Date birthDay) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthDay = birthDay;
	}

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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "[ID]=" + id + ",[Name]=" + username + ",[Pass]=" + password;
	}

}
