package com.qfedu.action;

import java.io.IOException;
import java.util.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.UserManagerServiceImp;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��������
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		// ��������
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		 
		if (code.equals("6982")) {
			// �����жϷ���
			UserManagerServiceImp umsi = new UserManagerServiceImp();
			UserExt ue = umsi.userLogin(username, password);
			if (ue != null) {
				// ���ue����null������session���ֵ
				HttpSession session = req.getSession();
				session.setAttribute("currentUser", ue);
				 
				// �ض���
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}

		} else {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
