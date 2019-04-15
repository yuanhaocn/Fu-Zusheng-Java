package com.syc.layer.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * JavaBean的一种:BO-->业务对象,在一个普通的Java对象中加入一些简单的业务判断方法.
 * 
 * @类名称:UserForm
 * @创建人:SYC
 * @创建时间:2017年7月31日 下午3:30:35
 */
public class UserForm {

	private String username;
	private String password;
	private String confirmPwd;
	private String email;
	private String birthday;

	//注意:该集合对象,也必须提供get和set方法.否则BeanUtils无法给该对象赋值.
	private Map<String, String> infos = new HashMap<>();

	// 验证表单数据格式是否正确
	public boolean checkForm() {
		if ("".equals(username) || username == null) {
			infos.put("username", "用户名不能为空!");
		} else if (!username.matches("\\w{3,8}")) {//注意:matches()方法中的参数必须是一个正则表达式.
			infos.put("username", "用户名由3-8位组成!");
		}

		if ("".equals(password) || password == null) {
			infos.put("password", "密码不能为空!");
		} else if (!password.matches("\\d{3,8}")) {
			infos.put("password", "密码由3-8位组成!");
		}

		if ("".equals(confirmPwd) || confirmPwd == null) {
			infos.put("confirmPwd", "确认密码不能为空!");
		} else if (!confirmPwd.equals(password)) {
			infos.put("confirmPwd", "确认密码和密码不一致!");
		}

		if ("".equals(email) || email == null) {
			infos.put("email", "Email不能为空!");
		} else if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
			infos.put("email", "Email格式不正确!");
		}

		if ("".equals(birthday) || birthday == null) {
			infos.put("birthday", "出生日期不能为空!");
		} else {
			try {
				// 09年09月88
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
				infos.put("birthday", "日期格式不正确!");
			}
		}

		return infos.isEmpty();
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

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Map<String, String> getInfos() {
		return infos;
	}

	public void setInfos(Map<String, String> infos) {
		this.infos = infos;
	}
	
	

}
