package com.syc.manager.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.syc.manager.domain.User;
import com.syc.manager.service.MenuService;
import com.syc.manager.service.RoleService;
import com.syc.manager.service.UserService;

public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuSerivce;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tk) throws AuthenticationException {
		
		UsernamePasswordToken token=(UsernamePasswordToken) tk;
		String username = token.getUsername();
		User user = userService.findUserByUserName(username);
		if(user==null){
			throw new UnknownAccountException("账户不存在!");
		}
		
		String password=new String(token.getPassword());
		if(!password.equals(user.getPassword())){
			throw new IncorrectCredentialsException("密码错误!");
		}
		
		if(user.getStatus()==0){
			throw new LockedAccountException("账户被锁定!");
		}
		
		return new SimpleAuthenticationInfo(user, password, getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		
		User user = (User) principals.getPrimaryPrincipal();
		List<String> roles = roleService.getUserRoleList(user.getUserId());
		info.addRoles(roles);
		
		List<String> permissions = menuSerivce.getUserPermissionsList(user.getUserId());
		info.addStringPermissions(permissions);
		
		return info;
	}

}
