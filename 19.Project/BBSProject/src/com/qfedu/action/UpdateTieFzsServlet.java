package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.serviceImp.TieManagerServiceImp;

@WebServlet("/updateTieFzsServlet")
public class UpdateTieFzsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String updateTieId = req.getParameter("tieId");
		String newTieTheme = req.getParameter("title");
		String newContext = req.getParameter("context");
//		�Ѿ���ǰ�˰����ݻ�ȡ���� 
		System.out.println("��ȡ������������");
		System.out.println(updateTieId);
		System.out.println(newTieTheme);
		System.out.println(newContext);
//		����serviceImp�㣬������д�����ݿ�
		TieManagerServiceImp updateTMSI = new TieManagerServiceImp();
		 updateTMSI.updateTieFze(Integer.parseInt(updateTieId), newTieTheme, newContext);
	req.getRequestDispatcher("/mySendTieList.jsp").forward(req, resp);
	}
	

}
