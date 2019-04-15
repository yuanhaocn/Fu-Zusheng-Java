package com.qfedu.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

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

@WebServlet("/selectStudentsAjaxServlet")
public class SelectStudentsAjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setCharacterEncoding("text/html charset=UTF-8");
		Connection connection = DButil.getConnection();
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);

		List<Student> lists = managerStudentImp.getAllStduent();
		//构建Gson对象
		Gson gson = new Gson();
		//转换为json字符串
		String json = gson.toJson(lists);
		//把字符串写回前段
		resp.getWriter().write(json);
	}
}
