package com.qfedu.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.daoimp.StudentHandleImp;
import com.qfedu.domain.Student;
import com.qfedu.serviceImp.ManagerStudentImp;
import com.qfedu.util.DButil;

@WebServlet("/selectStudentsServlet")
public class SelectStudentsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = DButil.getConnection();
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);
		
		
		List<Student> lists = managerStudentImp.getAllStduent();
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/showStudentsEL.jsp").forward(req, resp);
	}

}
