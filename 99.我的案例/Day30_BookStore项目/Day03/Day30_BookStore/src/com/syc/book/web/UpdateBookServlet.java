package com.syc.book.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.book.domain.Book;
import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 修改图书的Servlet
 * 
 * @类名称:UpdateBookServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:54:27
 */
public class UpdateBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Book book = new Book();
			BeanUtils.populate(book, request.getParameterMap());

			//修改图书
			IBookService service = new BookServiceImpl();
			service.updateBook(book);
			
			request.getRequestDispatcher("/bookListServlet").forward(request, response);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}