package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Order;
import com.syc.bookstore.domain.User;
import com.syc.bookstore.service.IOrderService;
import com.syc.bookstore.service.impl.OrderServiceImpl;

public class FindOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询用户所有订单的servlet
		User user = (User) request.getSession().getAttribute("user");

		if(user!=null){
			IOrderService orderService = new OrderServiceImpl();
			List<Order> orders = orderService.findUserOrders(user.getId());

			request.setAttribute("orders", orders);
			request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}