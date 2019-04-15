package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

@WebServlet("/addStudentFastIsonServlet ")
public class AddStudentFastIsonServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// 接收前端数据
		String jsonStr = req.getParameter("stuJson");
		//把JSON字符创转为java对象
		Object parse = JSON.parse(jsonStr);
		 
	}
}
