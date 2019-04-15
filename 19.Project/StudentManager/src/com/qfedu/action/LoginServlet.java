package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.daoimp.UserHandleImp;
import com.qfedu.serviceImp.ManagerUserImp;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.addHeader("Content-type", "text/html;charset=UTF-8");
		String number = req.getParameter("number");
		String password = req.getParameter("password");
		
		//����service��
		ManagerUserImp userImp = new ManagerUserImp();
		userImp.setUh(new UserHandleImp());
		boolean b = userImp.login(number, password);
		
		if (b) {
			// �ж϶�ѡ���Ƿ�ѡ��
			if (req.getParameter("remeber") != null && req.getParameter("remeber").equals("yes")) {
				// ����Cookie����
				Cookie cookie = new Cookie("number_password", number + "_" + password);
				// ������������
				cookie.setMaxAge(60 * 60 * 24 * 30);
				resp.addCookie(cookie);
			}
			// ҳ����ת
			req.getRequestDispatcher("/addStudent.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}	}
	
}
