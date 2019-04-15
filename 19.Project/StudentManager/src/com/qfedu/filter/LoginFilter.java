package com.qfedu.filter;

/**
 * �Զ���¼�Ĺ�����
 * �������е���Դ�����жϷ��У��ж��Ƿ����û���Ϣ�����û���Ϣ�Ļ��͵�ס  û�оַ��е�login.jsp
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.daoimp.UserHandleImp;
import com.qfedu.domain.User;
import com.qfedu.serviceImp.ManagerUserImp;
import com.qfedu.util.CookieUtil;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1.���������Ӧ����תΪ��׼���������Ӧ����,��Ϊservlet���������Ӧ������ȫ
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 2.��ȡsession��������������ֵ
		User user = (User) req.getSession().getAttribute("user"); 
		// 3.�жϸö����Ƿ����
		if (user == null) {
			// 4.�ж�cookie���Ƿ����û���������Ĵ���
			// 5.��ȡcookie����
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtil.getCookie(cookies, "userInfo");
			// 6.�жϸö����Ƿ�Ϊ��,û�е�¼��Ϊ��
			if (cookie == null) {
				chain.doFilter(req, resp);
			} else {
				// 7.��ȡcookie��������洢��number��password��Ϣ
				String value = cookie.getValue();
				String number = value.split("_")[0];
				String password = value.split("_")[1];
				// 8.����service��ĵ�¼�߼����ж��û����������Ƿ���ȷ
				ManagerUserImp managerUserImp = new ManagerUserImp();
				managerUserImp.setUh(new UserHandleImp());
				boolean b = managerUserImp.login(number, password);
				// 9.�����ȷ���ͰѸ��û��������빹��use������session
				if (b) {
					User trueUser = new User();
					trueUser.setNumber(number);
					trueUser.setPassword(password);
					req.getSession().setAttribute("user", trueUser);
				}
				// 10.������ζ�����
				chain.doFilter(req, resp);
			}
		} else {
			// 11.���session�����user��Ϊ�գ�����
			chain.doFilter(req, resp);
		}
	}

}
