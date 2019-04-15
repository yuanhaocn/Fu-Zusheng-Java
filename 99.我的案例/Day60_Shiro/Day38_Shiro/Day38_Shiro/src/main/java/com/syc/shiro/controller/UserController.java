package com.syc.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping("/user")
public class UserController {

	// @RequestMapping("/toTest")
	// public String toTest(){
	// return "test";
	// }

	// 处理登陆请求
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpServletRequest request) {

		// 处理验证码,判断输入的验证码与以前生成的验证码是否一致!
		// Shiro提供的快速获取请求参数的工具方法.
		String captcha = WebUtils.getCleanParam(request, "captcha");

		// 从Session中获取保存的验证码信息
		String randCode = (String) request.getSession().getAttribute("rand");

		if (!StringUtils.equals(captcha, randCode)) {
			request.setAttribute("msg", "验证码不正确!");
			// 重定向到"/"
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
		}

		// 得到主题对象---->当前登陆的用户对象!
		Subject subject = SecurityUtils.getSubject();

		// 用来封装用户名和密码的令牌
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 清空token令牌中的用户名和密码信息.
		// token.clear();
		// setRememberMe(flag);方法中的参数应该和login登陆页面中checkbox勾选的值相关!
		// token.setRememberMe(true);
		System.out.println("token=" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));

		// AuthenticationException
		try {
			// 进行登陆验证
			
			System.out.println("1.即将开始认证!");
			
			subject.login(token);
			
			System.out.println("3.认证结束....");
		} catch (UnknownAccountException e) {
			System.out.println("未知账户");
			request.setAttribute("msg", "未知账户");
		} catch (IncorrectCredentialsException e) {
			System.out.println("密码错误");
			request.setAttribute("msg", "密码错误");
		} catch (LockedAccountException e) {
			System.out.println("账户被锁定!");
			request.setAttribute("msg", "账号被锁定");
		} catch (ExcessiveAttemptsException e) {
			System.out.println("密码错误次数过多!");
			request.setAttribute("msg", "密码错误次数过多!");
		} catch (AuthenticationException e) {
			System.out.println("用户名或密码错误!");
			request.setAttribute("msg", "用户名或密码错误!");
		}
		
		//进行授权操作
		if(subject.isAuthenticated()){//当Subject.login(token)成功执行后,算是经过了认证!
			System.out.println("4.用户["+username+"]已经过了认证!");
			//经过登陆认证之后,跳转到home页面
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/home.jsp";
		}else{
			//清空以前的登陆信息.
			//当调用clear()方法的时候,会清空掉用户名,密码,remember等信息.
			//尤其是会将密码置为0x00.
			//Shiro中密码类型为什么是char[],而不是String类?
			//String pass=null;
			//char[] pass=0x00;
			//原因就是为了更安全!
			token.clear();
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/";	
		}
	}
	
	//处理退出登陆请求
	@RequestMapping("/logout")
	public String logout(){
		
		//session.invalidate();
		//经过退出之后,用户的session及已授权信息,就会被失效或者移除!
		SecurityUtils.getSubject().logout();
		
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/";
	}

}
