package com.syc.shiro.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.syc.shiro.domain.User;
import com.syc.shiro.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService service;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tk) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) tk;
		String username = token.getUsername();
		User user = service.findUserByName(username);
		if (user == null) {
			return null;
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		saveSession(user);
		return info;
	}

	private void saveSession(User user) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			subject.getSession().setAttribute("user", user);
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) super.getAvailablePrincipal(principals);
		if (username != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<String> roles = service.findRolesByName(username);
			info.addRoles(roles);

			List<String> permissions = service.findPermissionsByName(username);
			info.addStringPermissions(permissions);
			
			return info;
		}else{
			//return null;
			throw new UnknownAccountException("请检查你的用户名或密码!");
		}
	}

}
