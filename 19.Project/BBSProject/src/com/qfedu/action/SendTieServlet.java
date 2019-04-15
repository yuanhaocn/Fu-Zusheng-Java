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
		//������������
		req.setCharacterEncoding("utf-8");
		//����ǰ������
		String theme = req.getParameter("theme");
		String sendContent = req.getParameter("sendcontent");
		//��session��ȡusername
		UserExt ue = (UserExt)req.getSession().getAttribute("currentUser");
		String username = ue.getUsername();
		//����service�����
		TieManagerServiceImp tmsi = new TieManagerServiceImp();
		tmsi.addTieAndUpdateUser(theme, sendContent, username);
		//ҳ����ת�������ɹ�����
		resp.sendRedirect("/BBSProject/sendSuccess.jsp");
	}
	

}
