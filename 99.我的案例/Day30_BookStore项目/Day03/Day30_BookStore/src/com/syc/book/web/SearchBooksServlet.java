package com.syc.book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.Book;
import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 多条件查询图书的Servlet
 * @类名称:SearchBooksServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午11:34:17
 */
public class SearchBooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取查询条件
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String minPrice = request.getParameter("minprice");
		String maxPrice = request.getParameter("maxprice");
		
		IBookService service=new BookServiceImpl();
		List<Book> books = service.searchBooks(id,name,category,minPrice,maxPrice);
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}