package com.qfedu.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qfedu.daoimp.StudentHandleImp;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.ManagerStudentImp;
import com.qfedu.util.DButil;

@WebServlet("/selectStudentByAjaxServlet")
public class SelectStudentByAjaxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	resp.setContentType("text/html; charset=UTF-8");
		// 接收前端传过来的数据
		String number = req.getParameter("number");
		
		
		Connection connection = DButil.getConnection();// 选择连接池
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);
		
		
		Student student = managerStudentImp.getStudentByNumber(number);
		//构建gson对象
		Gson gson = new Gson();
		//把对象转为json字符串
		String jsonStr = gson.toJson(student);
		//只能通过response的getwriter的write的方法把数据写回前段
		resp.getWriter().write(jsonStr);
	}

}






