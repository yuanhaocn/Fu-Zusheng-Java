package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 按条件查询图书
 * @类名称:SearchBooksServlet
 * @创建人:SYC
 * @创建时间:2017年7月18日 下午5:34:10
 */
public class SearchBooksServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		
		//获取条件
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String minPrice = request.getParameter("minprice");
		String maxPrice = request.getParameter("maxprice");
		
		//按条件查询
		IBookService service=new BookServiceImpl();
		List<Book> books = service.searchBooks(id, name, category, minPrice, maxPrice);
		
		//跳转到list.jsp页面,重新显示结果.
		request.setAttribute("books", books);
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
