package com.syc.spring.aop02.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {

	// 获取注解的值
	public static String parse(Class<?> clazz, String methodName) {
		String privilege = "";
		try {
			Method method = clazz.getDeclaredMethod(methodName);
			// 暴力反射---->"强暴"
			method.setAccessible(true);
			// 判断是否存在某个注解
			if (method.isAnnotationPresent(PrivilegeAnnotation.class)) {
				PrivilegeAnnotation annotation = method.getAnnotation(PrivilegeAnnotation.class);
				// 得到注解的值
				privilege = annotation.privilege();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return privilege;
	}
}
