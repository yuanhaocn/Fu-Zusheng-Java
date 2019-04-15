package com.syc.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.syc.shiro.domain.User;

@Controller
public class UserController {

	//@Autowired
	//private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user) {

		/*
		 * User usr = service.findUserByName(user.getUsername()); if (usr ==
		 * null) { return "error"; }
		 * 
		 * if (!usr.getPassword().equals(user.getPassword())) { return "error";
		 * }
		 */

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		// token.setRememberMe(true);
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			return "error";
		}

		if (subject.isAuthenticated()) {
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/home";
		} else {
			token.clear();
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
		}

	}

	@RequestMapping(value = "/logout")
	public String logout() {

		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			subject.logout();
		}

		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
	}
}
