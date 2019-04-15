package com.syc.utils.base03;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.syc.utils.bean.User;

/**
 * 整个项目:N多个模块,每个模块都有自己的表要操作. 比如用户登录注册模块----User表; 订单模块---->Order表;
 * 商品模块---->Product表; .....
 * 
 * @类名称:UserDaoTest
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午3:48:02
 */
public class UserDaoTest {

	@Test
	public void insertTest() {
		try {
			User user = new User();
			// 进行赋值
			// user.setUsername(username);
			BeanUtils.setProperty(user, "username", "三胖");
			BeanUtils.setProperty(user, "password", "111");

			// 进行user表的添加操作
			UserDao dao = new UserDao();
			int result = dao.insertUser(user);
			if (result > 0) {
				System.out.println("添加成功!");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateTest() {
		try {
			User user = new User();
			// 进行赋值
			// user.setUsername(username);
			BeanUtils.setProperty(user, "id", 1);
			BeanUtils.setProperty(user, "username", "土鳖1号");
			BeanUtils.setProperty(user, "password", "222");

			// 进行user表的添加操作
			UserDao dao = new UserDao();
			int result = dao.updateUser(user);
			if (result > 0) {
				System.out.println("修改成功!");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteTest() {
		try {
			User user = new User();
			// 进行赋值
			// user.setUsername(username);
			BeanUtils.setProperty(user, "id", 1);

			// 进行user表的添加操作
			UserDao dao = new UserDao();
			int result = dao.deleteUser(user);
			if (result > 0) {
				System.out.println("删除成功!");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findByIDTest() {
		UserDao dao = new UserDao();
		User user = dao.findUserByID(3);
		System.out.println("ID=" + user.getId());
		System.out.println("Name=" + user.getUsername());
		System.out.println("Pass=" + user.getPassword());
	}

	@Test
	public void findByIDTest2() {
		User user = new User();
		user.setId(2);
		UserDao dao = new UserDao();
		User user2 = dao.findUserByID(user);
		System.out.println("ID=" + user2.getId());
		System.out.println("Name=" + user2.getUsername());
		System.out.println("Pass=" + user2.getPassword());
	}

	@Test
	public void findAllTest() {
		UserDao dao = new UserDao();
		List<User> users = dao.findAllUsers();
		for (User user : users) {
			System.out.println("ID=" + user.getId());
			System.out.println("Name=" + user.getUsername());
			System.out.println("Pass=" + user.getPassword());
		}
	}
}
