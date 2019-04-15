package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Book;

/**
 * 改变订单数量的Servlet
 * TODO:目前商品数量无法更改!
 * @类名称:ChangeNumServlet
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午5:00:28
 */
public class ChangeNumServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		
		//得到购物车
		Map<Book, String> map = (Map<Book, String>) request.getSession().getAttribute("cart");

		Book book = new Book();
		book.setId(id);
		
		//-操作:数目为0时,从购物车中移除该条目.
		if ("0".equals(num)) {
			map.remove(book);
		}

		//修改购物车中图书的数量
		if (map.containsKey(book)) {
			map.put(book, num);
		}
		
		System.out.println("Num=" + num);

		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
