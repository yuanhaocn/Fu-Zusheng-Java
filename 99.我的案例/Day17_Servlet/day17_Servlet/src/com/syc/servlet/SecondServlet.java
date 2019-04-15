package com.syc.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		System.out.println("second...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		String path="//psf/Home/Desktop/test.txt";
		File file=new File(path);
		String str=null;
		BufferedReader reader=new BufferedReader(new FileReader(file));
		while((str=reader.readLine())!=null){
			writer.write(str);
		}
		reader.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
