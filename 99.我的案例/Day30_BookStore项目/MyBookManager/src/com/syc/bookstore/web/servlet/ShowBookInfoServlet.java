package com.syc.bookstore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 显示图书信息
 * 
 * @类名称:ShowBookInfoServlet
 * @创建人:SYC
 * @创建时间:2017年7月14日 下午5:54:44
 */
public class ShowBookInfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		// 获取图书编号
		String id = request.getParameter("id");
		IBookService service = new BookServiceImpl();
		Book book = service.findBookByID(id);

		//跳转到图书详情页面
		request.setAttribute("book", book);
		request.getRequestDispatcher("/productInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
