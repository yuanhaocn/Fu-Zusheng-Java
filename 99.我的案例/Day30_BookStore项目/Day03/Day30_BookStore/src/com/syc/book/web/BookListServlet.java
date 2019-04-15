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
 * 后台管理员界面的图书列表页面
 * @类名称:BookListServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:21:10
 */
public class BookListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IBookService service=new BookServiceImpl();
		List<Book> books = service.findAllBooks();
		
		if(books!=null){
			request.setAttribute("books", books);
			//跳转到图书列表页面
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}