package com.qfedu.util;

import javax.servlet.http.Cookie;

public class  CookieUtil {
	public static Cookie getCookie(Cookie[] cookies,String name) {
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if(cookies[i].getName().equals(name)) {
				return cookies[i];
			}
		}
		return null;
	}
}
