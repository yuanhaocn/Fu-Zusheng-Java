package com.syc.spring.aop02;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.syc.spring.aop02.annotation.AnnotationParse;

/*
 * 切面类
 */
public class PrivilegeAspect {

	//private List<Privilege> privileges = new ArrayList<Privilege>();
	private List<Privilege> privileges;

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	// 环绕通知方法.
	public void isAccess(ProceedingJoinPoint point) throws Throwable {

		// 遍历集合,取出集合中Privilege的access的值

		boolean flag = false;

		// 如何获取目标类的字节码?
		Class<? extends Object> clazz = point.getTarget().getClass();
		// 获取目标方法名称
		String methodName = point.getSignature().getName();
		// 注解的值
		String value = AnnotationParse.parse(clazz, methodName);

		for (Privilege privilege : privileges) {
			String access = privilege.getAccess();
			if (access.equals(value)) {
				flag = true;
			}
		}

		//进行权限检查
		if (flag) {
			point.proceed();
		} else {
			// 不调用proceed();
			System.out.println("你无权查看薪资!");
		}

	}
}
