package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.Order;
import com.syc.bookstore.service.IOrderService;
import com.syc.bookstore.service.impl.OrderServiceImpl;

/**
 * 查看订单信息
 * 
 * @类名称:FindOrderInfoServlet
 * @创建人:SYC
 * @创建时间:2017年8月8日 下午1:31:39
 */
public class FindOrderInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查找订单详细信息的servlet
		// 得到订单号
		String orderid = request.getParameter("orderId");

		IOrderService orderService = new OrderServiceImpl();

		Order order = orderService.findOrderInfo(orderid);// 查找订单详细信息

		request.setAttribute("order", order);
		request.getRequestDispatcher("/orderInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}