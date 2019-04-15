package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 根据名称搜索book
 * 
 * @类名称:FindBookByNameServlet
 * @创建人:SYC
 * @创建时间:2017年7月18日 下午5:43:22
 */
public class FindBookByNameServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取搜索的图书名称
		String name = request.getParameter("bookName");

		System.out.println("Name=" + name);

		// 根据图书名称查找图书名称的集合
		IBookService service = new BookServiceImpl();
		Book book = service.findBookByName(name);

		if (book != null) {
			request.setAttribute("book", book);
			// 跳转到展示界面
			request.getRequestDispatcher("/productInfo.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/bookIsNull.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
