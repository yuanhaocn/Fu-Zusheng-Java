package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.TieManagerServiceImp;

@WebServlet("/deleteTieServlet")
public class DeleteTieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tieId = req.getParameter("tieId");
		TieManagerServiceImp tmsi = new TieManagerServiceImp();
		//��Session��ȡusername
		UserExt ue = (UserExt)req.getSession().getAttribute("currentUser");
		//����ɾ������
		tmsi.removeTieByTieId(Integer.parseInt(tieId), ue.getUsername());
	}
	
}
