package com.syc.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.PageBean;
import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 图书分类Servlet
 * 
 * @类名称:BookCategoryServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 下午2:04:32
 */
public class BookCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取分类
		String category = request.getParameter("category");

		if (category == null) {
			category = "";
		}

		// 当前页
		int currentPage = 1;
		// 每页显示的数量
		int pageSize = 4;

		// 当前页的索引值
		String current = request.getParameter("currentPage");
		if (current != null && current != "") {
			currentPage = Integer.parseInt(current);
		}

		// 1.图书的总数量---totalCount;
		// 2.每页显示的数量--pageSize;
		// 3.总页数=totalCount/pageSize;
		// 4.当前页=currentPage
		IBookService service = new BookServiceImpl();
		PageBean pageBean = service.pageBooks(currentPage, pageSize, category);

		request.setAttribute("pageBooks", pageBean);
		request.getRequestDispatcher("/productList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}