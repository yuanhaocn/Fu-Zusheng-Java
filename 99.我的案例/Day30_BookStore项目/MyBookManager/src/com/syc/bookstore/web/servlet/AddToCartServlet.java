package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 添加到购物车.
 * 
 * @类名称:AddToCartServlet
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午3:22:53
 */
public class AddToCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		// 获取Session
		HttpSession session = request.getSession();
		// 从Session中获取购物车集合
		Map<Book, String> cartMap = (Map<Book, String>) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new HashMap<>();
		}

		// 获取指定id的Book对象
		String id = request.getParameter("id");
		IBookService service = new BookServiceImpl();
		Book book = service.findBookByID(id);

		//默认的商品数量.
		int num = 1;

		// 判断购物车中是否包含该图书
		if (cartMap.containsKey(book)) {
			// 如果购物车中包含该图书,则购物车中该商品数量+1.
			num = Integer.parseInt(cartMap.get(book))+1;
		}

		// 如果购物车中不包含该图书,则将该图书存放到购物车中
		cartMap.put(book,String.valueOf(num));
		// 将购物车Map存放到Session中
		session.setAttribute("cart", cartMap);

		//选择后续操作
		PrintWriter writer = response.getWriter();
		writer.println("<a href='" + request.getContextPath() + "/bookCategory?currentPage=1'>继续购物</a>&nbsp;&nbsp;<a href='"
				+ request.getContextPath() + "/cart.jsp'>查看购物车</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
