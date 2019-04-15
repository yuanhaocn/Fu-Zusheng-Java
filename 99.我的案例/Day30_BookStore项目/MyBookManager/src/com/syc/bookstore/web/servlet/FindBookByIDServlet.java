package com.syc.bookstore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 根据ID查找图书
 * 
 * @类名称:FindBookByIDServlet
 * @创建人:SYC
 * @创建时间:2017年7月17日 下午5:16:19
 */
public class FindBookByIDServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		//获取id
		String id = request.getParameter("id");
		
		//根据id获取要编辑的图书
		IBookService service = new BookServiceImpl();
		Book book = service.findBookByID(id);
		
		//跳转到edit.jsp
		if (book != null) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
