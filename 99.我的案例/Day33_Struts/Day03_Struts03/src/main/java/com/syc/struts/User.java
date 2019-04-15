package com.syc.struts;

import java.util.Date;

public class User {

	private String username;
	private String password;
	private String sex;
	private Date birthday;//注意:util.Date需要进行类型转换,sql.Date一般不需要!

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
