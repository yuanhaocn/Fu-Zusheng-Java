package com.syc.bookstore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 根据id删除Book
 * 
 * @类名称:DeleteBookByIdServlet
 * @创建人:SYC
 * @创建时间:2017年7月16日 下午6:23:39
 */
public class DeleteBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		String id = request.getParameter("id");

		//根据id删除Book
		IBookService service = new BookServiceImpl();
		service.deleteBookByID(id);
		
		//实现批量删除
		//外键约束导致无法批量删除.
		String[] ckdValues = request.getParameterValues("cki");
		if(ckdValues!=null){
			service.deleteBooks(ckdValues);
		}
		
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
