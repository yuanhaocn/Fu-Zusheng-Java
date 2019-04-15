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
		//接收前端数据
		String number = req.getParameter("number");
		//构建一个Stirng类型，因为js是弱类型 
		String b="true";
		//简单的校验
		if(number.equals("1266666666")) {
			b="false";
		}
		//把b写回前段
		resp.getWriter().println(b);
	}

}
