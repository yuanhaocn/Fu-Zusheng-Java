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
		// ����ǰ������
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// ����Util���ȡ����
		Connection connection = DButil.getConnection();
		//����service�㼴��
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		//����dao�����
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		//������ӳ�
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);
		//������ӷ���
		managerStudentImp.addStudent(number,name,new Integer(age));	 
	}
}
