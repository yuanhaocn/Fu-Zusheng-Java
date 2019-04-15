package com.qfedu.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.daoimp.StudentHandleImp;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.ManagerStudentImp;
import com.qfedu.util.DButil;

@WebServlet("/selectStudentByNumberServlet")
public class SelectStudentByNumberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收前端传过来的数据
		String number = req.getParameter("number");
		
		
		Connection connection = DButil.getConnection();// 选择连接池
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);
		
		
		Student student = managerStudentImp.getStudentByNumber(number);
		req.getSession().setAttribute("student", student);
		resp.sendRedirect("/StudentManager/show.jsp");
	}

}






