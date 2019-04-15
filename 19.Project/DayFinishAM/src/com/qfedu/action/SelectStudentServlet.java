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
		// 接收前端数据
		String pageSize = req.getParameter("pageSize");
		String thispage = req.getParameter("thisPage");
		System.out.println(thispage + "   " + pageSize);
//		第一次进来的时候pageSize不为空，需要session存储
		if(pageSize!=null) {
			req.getSession().setAttribute("pageSize", pageSize);
		}else {
			pageSize=(String)(req.getSession().getAttribute("pageSize"));
		}
		// 判断处理接收到的值
		if (thispage == null) {
			thispage = "1";
		}
		// 调用service层的方法
		StudentManagerServiceImp smsi = new StudentManagerServiceImp();
		Page page = smsi.buildPage(Integer.parseInt(thispage), Integer.parseInt(pageSize));
		//设置域对象的值，
		req.getSession().setAttribute("page", page);
//		页面效率
		req.getRequestDispatcher("/showStudents.jsp").forward(req, resp);
	}

}
