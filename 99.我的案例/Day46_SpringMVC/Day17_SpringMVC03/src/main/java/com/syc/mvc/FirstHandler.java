package com.syc.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/*
 * 实现HttpRequestHandler接口,创建了一个处理器.
 */
public class FirstHandler implements HttpRequestHandler{

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("msg", "Handler里的信息....");
		
		//response.sendRedirect("/WEB-INF/jsp/index.jsp");
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		
		//在请求转发方法中,可以不可以使用逻辑视图名?---->不可以!
		//request.getRequestDispatcher("index").forward(request, response);
		
	}

}
