package com.syc.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 删除图书
 * @类名称:DeleteBookServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午10:22:31
 */
public class DeleteBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		
		//删除某个id对应的图书.
		IBookService service=new BookServiceImpl();
		service.deleteBookByID(id);
		
		//实现批量删除
		String[] ckdValue = request.getParameterValues("cki");
		if(ckdValue!=null){
			service.deleteBooks(ckdValue);
		}
		
		request.getRequestDispatcher("/bookListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}