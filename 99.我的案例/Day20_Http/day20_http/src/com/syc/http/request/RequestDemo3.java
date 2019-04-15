package com.syc.http.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String value = request.getHeader("user-agent");
		if(value.contains("Chrome")){
			writer.write("Chrome浏览器...");
		}else if(value.contains("Firefox")){
			writer.write("火狐浏览器...");
		}else{
			writer.write("杂牌子浏览器...");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}