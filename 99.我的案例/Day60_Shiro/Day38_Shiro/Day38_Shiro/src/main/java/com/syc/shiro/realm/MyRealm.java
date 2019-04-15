package com.syc.shiro.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class MyRealm extends AuthorizingRealm {

	/**
	 * 用来进行登陆认证的方法. Authentication:认证 注意:该方法中的参数来自于Subject的login(token)方法!
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tk) throws AuthenticationException {
		System.out.println("2.开始认证.....");
		UsernamePasswordToken token = (UsernamePasswordToken) tk;

		// 在真实的开发过程中,此处应该和数据库关联---->调用Service层封装好的相关方法!

		// token.getUsername();
		// token.getPassword();
		// token.getPrincipal();//身份
		// token.getCredentials();//密码/数字证书

		// 模拟admin账户
		if ("admin".equals(token.getUsername())) {
			// 封装一个简单的认证信息对象
			// 时机开发中,此处的用户名和密码,应该是从数据库中查询出来的信息!
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("admin", "admin", getName());

			setAuthenticationSession("admin");

			return info;
		}

		// 模拟普通用户
		if ("syc".equals(token.getUsername())) {
			// 封装一个简单的认证信息对象
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("syc", "syc", getName());

			setAuthenticationSession("syc");

			return info;
		}

		// 如果返回一个null,则会抛出一个UnknownAccountException异常!
		return null;
	}

	// 保存当前用户的方法
	private void setAuthenticationSession(String value) {
		// 获取Shiro框架中的Session
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			Session session = subject.getSession();
			session.setAttribute("currentUser", value);
		}
	}

	/**
	 * 用来进行授权的方法 Authorization:授权 Principal:身份---->用户名/邮箱地址/电话号码等.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		System.out.println("5.开始进行授权...");
		
		if (!principals.isEmpty()) {
			// 第一种获取用户身份的方式
			// Iterator iterator = principals.iterator();
			// while(iterator.hasNext()){
			// String username = (String) iterator.next();
			// }

			// 第二种获取用户身份的方法
			// 从当前集合中,获取第一个可用的用户身份
			String username = (String) super.getAvailablePrincipal(principals);

			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			//admin用户
			if (!StringUtils.isEmpty(username) && "admin".equals(username)) {
				// 添加用户角色
				info.addRole("admin");
				// info.addRoles(roles);

				// 添加用户权限
				info.addStringPermission("admin:manager");
				// info.addStringPermissions(permissions);
				System.out.println("为["+username+"]分配了role角色和manager权限!");
				return info;
			}
			
			//普通用户
			if (!StringUtils.isEmpty(username) && "syc".equals(username)) {
				System.out.println("当前用户未授权!");
				return info;
			}
		}

		//如果整个方法直接返回null,表示未进行授权,就跳转到unauthorizedUrl这个指定的url中!
		return null;
	}

}
