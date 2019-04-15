package com.qfedu.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.daoimp.StudentHandleImp;
import com.qfedu.serviceImp.ManagerStudentImp;
import com.qfedu.util.DButil;

@WebServlet("/addStudentServlet ")
public class AddStudentServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// 接收前端数据
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// 调用Util层获取连接
		Connection connection = DButil.getConnection();
		//调用service层即可
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		//构建dao层对象
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		//添加连接池
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);
		//调用添加方法
		managerStudentImp.addStudent(number,name,new Integer(age));	 
	}
}
