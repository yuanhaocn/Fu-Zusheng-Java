package com.syc.bookstore.service.impl;

import java.sql.SQLException;

import com.syc.bookstore.dao.IUserDao;
import com.syc.bookstore.dao.impl.UserDaoImpl;
import com.syc.bookstore.domain.User;
import com.syc.bookstore.exception.UserException;
import com.syc.bookstore.service.IUserService;
import com.syc.bookstore.utils.SendJUtil;

/**
 * 业务逻辑从,用户注册功能的实现
 * 
 * @类名称:UserServiceImpl
 * @创建人:SYC
 * @创建时间:2017年7月1日 下午11:23:22
 */
public class UserServiceImpl implements IUserService {

	private IUserDao dao = new UserDaoImpl();
	
	//注册用户
	@Override
	public void registerUser(User user) throws UserException {
		try {
			dao.addUser(user);
			// 注册成功后,在这里发送验证邮件
			/*String emailMsg="注册成功，请到<a href='http://www.book.com/activeServlet?activeCode=" + user.getActiveCode()
					+ "'>激活</a>";*/
			//发起激活用户请求
			String emailMsg="注册成功，请到<a href='http://localhost:8080/MyBookManager/activeUser?activeCode=" + user.getActiveCode()
			+ "'>激活</a>";
			SendJUtil.sendMail(user.getEmail(), emailMsg);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("注册失败!");
		}
	}

	@Override
	public void activeUser(String activeCode) throws UserException  {
		try {
			//根据激活码找到用户,有用户的时候才去更新用户状态.
			User user= dao.findUserByActiveCode(activeCode);
			if(user!=null){
				//更新激活状态
				dao.updateActiveState(activeCode);
				return;
			}else{
				throw new UserException("激活失败!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("激活失败!");
		}
	}

	@Override
	public User findUser(String id) throws UserException {
		try {
			return dao.findUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("未找到该用户!");
		}
	}

	@Override
	public User login(String username, String password) throws UserException {
		User user = null;
		try {
			//根据用户名密码查找用户
			user = dao.findUserByUserNameAndPassWord(username, password);
			if(user==null){
				throw new UserException("用户名或密码错误!");
			}else if(user!=null&&user.getState()==0){
				throw new UserException("尚未激活,无法登陆!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户名或密码错误!");
		}
		return user;
	}

	//修改用户信息
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
