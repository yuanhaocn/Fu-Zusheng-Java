package com.qfedu.test;

import java.util.List;

import org.junit.Test;

import com.qfedu.daoImp.UserManagerImp;
import com.qfedu.domain.User;

public class UserManagerTest {
	@Test
	public void insertTest() {
		UserManagerImp userManagerImp = new UserManagerImp();
		User user = new User();
		user.setNumber("007");
		user.setPassword("fzs");
		userManagerImp.insertUser(user);
	}
	@Test
	public void updateTest() {
		UserManagerImp userManagerImp = new UserManagerImp();
		User user = new User();
		user.setNumber("007");
		user.setPassword("fzs1393637533");
		userManagerImp.updateUser(user);
	}
	@Test
	public void deleteTest() {
		UserManagerImp userManagerImp = new UserManagerImp();
		User user = new User();
		user.setNumber("007");
		//user.setPassword("fzs1393637533");
		userManagerImp.deleteUser(user);
	}
	@Test
	public void selectAllTest() {
		UserManagerImp userManagerImp = new UserManagerImp();
		List<User> users = userManagerImp.selectAllUsers();
		System.out.println(users);
	}
	@Test
	public void countUsersTest() {
		UserManagerImp userManagerImp = new UserManagerImp();
		int countUsers = userManagerImp.countUsers();
		System.out.println(countUsers);
	}
}
