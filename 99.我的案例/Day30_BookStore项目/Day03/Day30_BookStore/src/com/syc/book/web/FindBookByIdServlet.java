package com.syc.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.Book;
import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 查找对应id的Book的Servlet
 * @类名称:FindBookByIdServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:45:15
 */
public class FindBookByIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		IBookService service=new BookServiceImpl();
		Book book = service.findBookById(id);
		
		if(book!=null){
			request.setAttribute("book", book);
			request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}