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
 * 管理员--图书列表
 * 
 * @类名称:BookListServlet
 * @创建人:SYC
 * @创建时间:2017年7月16日 下午6:02:44
 */
public class BookListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		// 查找所有图书
		IBookService service = new BookServiceImpl();
		List<Book> books = service.findAllBooks();

		//跳转到list.jsp页面
		if (books != null) {
			request.setAttribute("books", books);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
