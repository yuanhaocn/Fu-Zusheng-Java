package com.syc.manager.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.manager.domain.User;
import com.syc.manager.service.UserService;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.util.MyLog;
import com.syc.manager.util.PasswordUtil;
import com.syc.manager.vo.BaseJSON;

/**
 * 实现登陆和退出
 * 
 * @类名称:LoginController
 * @创建人:一一哥
 * @创建时间:2018年3月13日 上午11:19:37
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userSerivce;

	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestBody User user) {

		String username = user.getUsername();
		String password = user.getPassword();
		//System.out.println("name="+username+",pass="+password);
		MyLog.log("name="+username+",pass="+password);
		
		User usr = userSerivce.findUserByUserName(username);
		if(usr==null){
			throw new UnknownAccountException("用户不存在!");
		}
		
		String md5 = PasswordUtil.md5(password, username);
		MyLog.log("加密后的内容="+md5);
		if(!md5.equals(usr.getPassword())){
			throw new IncorrectCredentialsException("密码不正确!");
		}
		
		return JSONUtil.objectToJson(BaseJSON.setOK("登陆成功!"));
	}
	
	@RequestMapping("/logout")
	public String logout(){
		
		MyLog.log("退出...");
		
		return null;
	}
}
