package com.syc.proxy.showsalery03;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibShowSaleryInterceptor implements MethodInterceptor {

	private Object target;
	private Privilage mPrivilage;
	private Logger logger;
	private CheckSafe mCheck;

	public CglibShowSaleryInterceptor(Object target, Privilage privilage, Logger logger, CheckSafe check) {
		this.target = target;
		this.mPrivilage = privilage;
		this.logger = logger;
		this.mCheck = check;
	}

	public Object createProxy() {
		Enhancer hancer = new Enhancer();

		Class<? extends Object> clazz = target.getClass();

		hancer.setCallback(this);

		hancer.setClassLoader(clazz.getClassLoader());
		hancer.setInterfaces(clazz.getInterfaces());

		// 指明父类
		hancer.setSuperclass(clazz);

		return hancer.create();
	}

	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy arg3) throws Throwable {

		// 无论该用户是否具有权限,只要登录薪资查看系统,都必须把当前操作记录下来!
		logger.log();
		mCheck.checkSafe();

		String methodName = method.getName();

		if ("showSalery".equals(methodName)) {

			// 对于查看薪资的方法,必须验证权限
			String access = mPrivilage.getAccess();

			if ("admin".equals(access)) {
				method.invoke(target, args);
			} else {
				System.out.println("你无权查看薪资!");
			}
		} else {
			// 对于其他方法,直接放行
			method.invoke(target, args);
		}

		return null;
	}

}
