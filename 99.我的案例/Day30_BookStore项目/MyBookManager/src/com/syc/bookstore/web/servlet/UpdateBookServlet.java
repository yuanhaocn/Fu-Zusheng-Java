package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 修改图书信息的Servlet
 * 
 * @类名称:UpdateBookServlet
 * @创建人:SYC
 * @创建时间:2017年7月17日 下午5:28:31
 */
public class UpdateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		try {
			//封装Book对象
			Book book = new Book();
			BeanUtils.populate(book, request.getParameterMap());

			//修改图书信息
			IBookService service = new BookServiceImpl();
			service.updateBook(book);

			//进入图书列表,重新查询
			request.getRequestDispatcher("bookListServlet").forward(request, response);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
