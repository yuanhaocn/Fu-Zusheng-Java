package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.UserManagerServiceImp;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//��������
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//�����жϷ���
		UserManagerServiceImp umsi = new UserManagerServiceImp();
		UserExt ue = umsi.userLogin(username, password);
		//���ue����null������session���ֵ
		req.getSession().setAttribute("currentUser",ue);
		//�ض���
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}
