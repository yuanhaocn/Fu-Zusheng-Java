package com.syc.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.syc.manager.domain.User;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.util.MyLog;
import com.syc.manager.util.PasswordUtil;
import com.syc.manager.vo.BaseJSON;
import com.syc.manager.vo.ResponseStatus;

/**
 * 实现登陆和退出
 * 
 * @类名称:LoginController
 * @创建人:一一哥
 * @创建时间:2018年3月13日 上午11:19:37
 */
@Controller
public class LoginController {

	@ResponseBody
	//@RequestMapping("/login")
	@RequestMapping(value = "/login", produces = { "text/plain;charset=utf-8" }, method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		MyLog.log("name=" + username + ",pass=" + password);

		String md5 = PasswordUtil.md5(password, username);

		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, md5);
			SecurityUtils.getSubject().login(token);
		} catch (UnknownAccountException e) {
			MyLog.log("未知的账户:" + e.getMessage());
			e.printStackTrace();
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, e.getLocalizedMessage()));
		} catch (IncorrectCredentialsException e) {
			MyLog.log("密码错误:" + e.getMessage());
			e.printStackTrace();
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, e.getLocalizedMessage()));
		} catch (LockedAccountException e) {
			MyLog.log("账户被锁定:" + e.getMessage());
			e.printStackTrace();
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, e.getLocalizedMessage()));
		} catch (AuthenticationException e) {
			MyLog.log("认证异常:" + e.getMessage());
			e.printStackTrace();
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, e.getLocalizedMessage()));
		}

		if (SecurityUtils.getSubject().isAuthenticated()) {
			return JSONUtil.objectToJson(BaseJSON.setOK("登陆成功!"));
		} else {
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/login.html";
		}
	}

	@RequestMapping("/logout")
	public String logout() {

		SecurityUtils.getSubject().logout();

		return null;
	}
}
