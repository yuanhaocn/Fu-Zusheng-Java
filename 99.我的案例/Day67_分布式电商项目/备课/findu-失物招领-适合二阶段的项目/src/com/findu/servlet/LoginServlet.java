package com.findu.servlet;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findu.entity.User;
import com.findu.exception.UserExistsException;
import com.findu.service.UserService;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//��ȡ�û���������
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");

		//����service��¼
		UserService service = new UserService();
		
		try {
			User user = service.login(name, password);
			
			//��¼�ɹ������û��洢��session��
			request.getSession().setAttribute("user", user);
			request.setAttribute("Msg", "��ϲ������½�ɹ�!");
			request.getRequestDispatcher("/html/index.jsp").forward(request,
					response);
		} catch (UserExistsException e) {
			//������Ϣ
			e.printStackTrace();
			//�����û�������
			request.setAttribute("tempname", name);
			
			request.setAttribute("Msg", e.getMessage());
			request.getRequestDispatcher("/html/signin.jsp").forward(request,
					response);
			return;
		}			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}