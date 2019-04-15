package com.syc.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class GetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Get请求");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User user=new User();
		user.setName(name);
		user.setPass(pass);
		
		List<User> users=new ArrayList<>();
		users.add(user);
		users.add(user);
		
		//将集合转换为JSON数组
		JSONArray array = JSONArray.fromObject(users);
		
		//如果是用的$.ajax()请求方法,服务器端返回字符串是不会成功的.
		//因为这个地方要以json的格式进行数据的返回.
		writer.print(array);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Post请求");
		
		doGet(request, response);
	}

}