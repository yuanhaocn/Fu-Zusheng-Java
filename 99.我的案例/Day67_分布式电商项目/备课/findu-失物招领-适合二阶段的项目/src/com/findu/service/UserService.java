package com.findu.service;

import java.sql.SQLException;

import com.findu.dao.UserDao;
import com.findu.entity.User;
import com.findu.exception.ChangeUserException;
import com.findu.exception.RegisterException;
import com.findu.exception.UserExistsException;
import com.findu.utils.Judge;

public class UserService {
	
	private UserDao dao = new UserDao();
	
	/**
	 * ��¼����
	 * @param name
	 * @param password
	 * @return
	 * @throws UserExistsException
	 */
	public User login(String name,String password) throws UserExistsException{
		User user=null;
		try {
			
			//�ж�������ֻ���¼
			if (Judge.isEmail(name))
				user = UserDao.findUserByEmail(name);
			else if (Judge.isPhone(name)) {
				user = UserDao.findUserByPhone(name);
			}

			if (user != null) {
				// ������ȷ
				if (user.getPassword().equals(password)) {
					return user;
				}
				throw new UserExistsException("���벻��ȷ�����������룡");		
			}
			throw new UserExistsException("�ֻ��Ż����䲻���ڣ����������룡");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserExistsException("��¼ʧ��");
		}
	}
	
	/**
	 * ע��
	 * @param user
	 * @throws UserExistsException
	 */
	public void register(User user,String checkbox,String password) throws RegisterException {
		try {
			//�ж��Ƿ�ע��
			User newUser = dao.findUserByPhone(user.getPhone());
			User newUser2 = dao.findUserByPhone(user.getEmail());
			User newUser3 = dao.findUserByName(user.getName());
			
			if ((newUser != null) || (newUser2 != null)) {
				throw new RegisterException("�ֻ��Ż������ѱ�ע��!");
			}else if((checkbox == null) || ("".equals(checkbox))){
				throw new RegisterException("��δͬ�⹴ѡ����վʹ��Э��!");
			}else if(Judge.isName(user.getName())){
				throw new RegisterException("�û������ú������ַ�!");
			}else if(!Judge.isPhone(user.getPhone())){
				throw new RegisterException("��������ȷ���ֻ���!");
			}else if(!user.getPassword().equals(password)){
				throw new RegisterException("������������벻һ��!");
			}else if((user.getPassword().length() < 6) || (user.getPassword().length() > 16)){
				throw new RegisterException("���볤��Ϊ6-16λ!");
			}else if(newUser3 != null){
				throw new RegisterException("�û�������!");
			}else{
				dao.save(user);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RegisterException("ע��ʧ��");
		}
		
	}

	public User findUserById(int userid) throws UserExistsException, SQLException {
		return dao.findUserById(userid);
	}

	public User findUserByName(String username) throws UserExistsException, SQLException {
		return dao.findUserByName(username);
	}
	
	/**
	 * �޸��û�����
	 * @param user
	 * @throws Exception
	 */
	public void changeUserData(User user) throws ChangeUserException {
		
		try {	
			dao.changeUserData(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ChangeUserException("�޸�ʧ��");
		}	
	}
	
	/**
	 * �޸�����
	 * @param newpass
	 * @param userid
	 * @throws Exception
	 */
	public void changePass(User user,String oldpass,String newpass,String renewpass) throws ChangeUserException {
		
		try {	
			if(user.getPassword().equals(oldpass)){
		    	if(newpass.length()<6){
		    		throw new ChangeUserException("������������볤�Ȳ���С��6λ!");
		    	}else{
			    	if(newpass.equals(renewpass)){
			    		dao.changePass(newpass, user.getId());
			    	}else{
			    		throw new ChangeUserException("����������������벻һ��!");
			    	}
		    	}
		    }else{
		    	throw new ChangeUserException("������ľ����벻��ȷ!");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ChangeUserException("�޸�ʧ��");
		}	
	}
}