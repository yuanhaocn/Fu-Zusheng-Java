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
		// ����ǰ�˴�����������
		String number = req.getParameter("number");
		
		
		Connection connection = DButil.getConnection();// ѡ�����ӳ�
		StudentHandleImp studentHandleImp = new StudentHandleImp();
		ManagerStudentImp managerStudentImp = new ManagerStudentImp();
		studentHandleImp.setConnection(connection);
		managerStudentImp.setSh(studentHandleImp);
		
		
		Student student = managerStudentImp.getStudentByNumber(number);
		//����gson����
		Gson gson = new Gson();
		//�Ѷ���תΪjson�ַ���
		String jsonStr = gson.toJson(student);
		//ֻ��ͨ��response��getwriter��write�ķ���������д��ǰ��
		resp.getWriter().write(jsonStr);
	}

}






