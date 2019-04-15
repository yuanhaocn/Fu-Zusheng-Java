package com.digesterdemo;
import java.util.ArrayList;
/**
 * 因为第一个是Users标签，所以创造一个Users类
 */
import java.util.List;

public class Users {
	//创建User对象的集合
	private List<User> users= new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Users [users=" + users + "]";
	}
	
	//创建添加元素的方法
	public void addUser(User user) {
		users.add(user);
	}
	
}
