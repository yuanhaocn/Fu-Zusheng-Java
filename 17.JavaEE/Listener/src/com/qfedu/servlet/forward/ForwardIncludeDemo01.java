package com.qfedu.servlet.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwardIncludeDemo01")
public class ForwardIncludeDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("111111111111111111111");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("forwardIncludeDemo02").forward(req, resp);
	//	req.getRequestDispatcher("forwardIncludeDemo02").include(req, resp);
	}

}
