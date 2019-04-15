package com.syc.book.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syc.book.domain.Book;
import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 添加到购物车
 * 
 * @类名称:AddToCartServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 下午3:29:34
 */
public class AddToCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 将该Book存放到购物车中.
		HttpSession session = request.getSession();
		// 从Session中取出购物车
		Map<Book, String> cartMap = (Map<Book, String>) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new HashMap<Book, String>();
		}

		// 得到id对应的Book
		String id = request.getParameter("id");
		IBookService service = new BookServiceImpl();
		Book book = service.findBookById(id);

		// 默认的购物数量
		int num = 1;

		// 判断购物车中是否包含该图书
		if (cartMap.containsKey(book)) {
			num = Integer.parseInt(cartMap.get(book)) + 1;
		}

		// 将购买的图书数量存放到购物车中
		cartMap.put(book, String.valueOf(num));
		// 将购物车集合存放到session中
		session.setAttribute("cart", cartMap);

		PrintWriter writer = response.getWriter();
		writer.write("<a href='" + request.getContextPath() + "/showBookInfo?id=" + id
				+ "'>查看商品详情</a>&nbsp;&nbsp;<a href='" + request.getContextPath() + "/cart.jsp'>去购物车结算</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}