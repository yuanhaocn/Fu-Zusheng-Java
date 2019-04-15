package com.syc.book.service.impl;

import java.sql.SQLException;

import com.syc.book.dao.IUserDao;
import com.syc.book.dao.impl.UserDaoImpl;
import com.syc.book.domain.User;
import com.syc.book.exception.UserException;
import com.syc.book.service.IUserService;
import com.syc.book.utils.SendMailUtil;

/**
 * 实现User的service接口
 * 
 * @类名称:UserServiceImpl
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:49:52
 */
public class UserServiceImpl implements IUserService {

	private IUserDao dao = new UserDaoImpl();

	// 注册--->发激活邮件--->点击邮件中的"激活"进行激活--->dao层将state=1--->登陆:user!=null&&state!=0.
	@Override
	public void registerUser(User user) throws UserException {
		try {
			dao.addUser(user);

			// 邮件内容
			String emailMsg = "注册成功,请去<a href='http://localhost:8080/Day30_BookStore/activeUser?activeCode="
					+ user.getActiveCode() + "'>激活</a>";

			// 发送邮件
			SendMailUtil.sendMail(user.getEmail(), emailMsg);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("注册失败!");
		}
	}

	@Override
	public User login(String name, String pass) throws UserException {
		User user = null;
		try {
			user = dao.findByNameAndPass(name, pass);
			if (user == null) {
				throw new UserException("用户名密码错误!");
			} else if (user != null && user.getState() == 0) {
				throw new UserException("尚未激活,无法登陆!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户名密码错误!");
		}
		return user;
	}

	// 激活用户
	@Override
	public void activeUser(String activeCode) throws UserException {
		try {
			User user = dao.findUserByActiveCode(activeCode);
			if (user != null) {
				// 更新用户状态
				dao.updateUserState(activeCode);
			} else {
				throw new UserException("激活失败!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("激活失败!");
		}
	}

	// 根据id查找User对象
	@Override
	public User findUser(String id) throws UserException {
		try {
			return dao.findUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("不存在该用户!");
		}
	}

	//修改用户
	@Override
	public void modifyUser(User user) throws UserException {
		try {
			dao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户信息修改失败!");
		}
	}

}
