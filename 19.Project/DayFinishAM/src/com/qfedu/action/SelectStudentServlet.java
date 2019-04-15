package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.Page;
import com.qfedu.serviceImp.StudentManagerServiceImp;

@WebServlet("/selectStudentServlet")
public class SelectStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����ǰ������
		String pageSize = req.getParameter("pageSize");
		String thispage = req.getParameter("thisPage");
		System.out.println(thispage + "   " + pageSize);
//		��һ�ν�����ʱ��pageSize��Ϊ�գ���Ҫsession�洢
		if(pageSize!=null) {
			req.getSession().setAttribute("pageSize", pageSize);
		}else {
			pageSize=(String)(req.getSession().getAttribute("pageSize"));
		}
		// �жϴ�����յ���ֵ
		if (thispage == null) {
			thispage = "1";
		}
		// ����service��ķ���
		StudentManagerServiceImp smsi = new StudentManagerServiceImp();
		Page page = smsi.buildPage(Integer.parseInt(thispage), Integer.parseInt(pageSize));
		//����������ֵ��
		req.getSession().setAttribute("page", page);
//		ҳ��Ч��
		req.getRequestDispatcher("/showStudents.jsp").forward(req, resp);
	}

}
