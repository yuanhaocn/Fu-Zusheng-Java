package com.digesterdemo;
import java.util.ArrayList;
/**
 * ��Ϊ��һ����Users��ǩ�����Դ���һ��Users��
 */
import java.util.List;

public class Users {
	//����User����ļ���
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
	
	//�������Ԫ�صķ���
	public void addUser(User user) {
		users.add(user);
	}
	
}
