package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.TieManagerServiceImp;

@WebServlet("/sendTieServlet")
public class SendTieServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理乱码问题
		req.setCharacterEncoding("utf-8");
		//接收前端数据
		String theme = req.getParameter("theme");
		String sendContent = req.getParameter("sendcontent");
		//从session获取username
		UserExt ue = (UserExt)req.getSession().getAttribute("currentUser");
		String username = ue.getUsername();
		//调用service层操作
		TieManagerServiceImp tmsi = new TieManagerServiceImp();
		tmsi.addTieAndUpdateUser(theme, sendContent, username);
		//页面跳转到发帖成功界面
		resp.sendRedirect("/BBSProject/sendSuccess.jsp");
	}
	

}
