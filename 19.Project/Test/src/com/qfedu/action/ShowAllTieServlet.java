package com.qfedu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.SendTie;
import com.qfedu.serviceImp.TieManagerServiceImp;

@WebServlet("/showAllTie")
public class ShowAllTieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TieManagerServiceImp tmsi = new TieManagerServiceImp();
		List<SendTie> allTie = tmsi.choseAllTie();
		req.getSession().setAttribute("allTie", allTie);
		req.getRequestDispatcher("/book.jsp").forward(req, resp);
	}

}
