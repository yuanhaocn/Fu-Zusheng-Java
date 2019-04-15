package com.qfedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qfedu.domain.Book;
@WebServlet("/bindObjectServlet")
public class BindObjectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//构建session对象
		HttpSession session = req.getSession();
		//构建对象填充数据
		Book book = new Book();
		book.setNumber("001");
		book.setName("西厢记");
		book.setPrice(13.14);
		//设置域对象的值
		session.setAttribute("book", book);
		req.getRequestDispatcher("/unBindObjectServlet").forward(req, resp);
	}

}
