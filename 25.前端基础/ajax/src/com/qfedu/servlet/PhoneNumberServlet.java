package com.qfedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/phoneNumberServlet")
public class PhoneNumberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ǰ������
		String number = req.getParameter("number");
		//����һ��Stirng���ͣ���Ϊjs�������� 
		String b="true";
		//�򵥵�У��
		if(number.equals("1266666666")) {
			b="false";
		}
		//��bд��ǰ��
		resp.getWriter().println(b);
	}

}
