package com.syc.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.Order;
import com.syc.book.exception.OrderException;
import com.syc.book.service.IOrderService;
import com.syc.book.service.impl.OrderServiceImpl;

/**
 * 查看订单详情
 * 
 * @类名称:FindOrderInfoServlet
 * @创建人:SYC
 * @创建时间:2017年8月8日 下午2:53:52
 */
public class FindOrderInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String orderId = request.getParameter("orderId");
			IOrderService service = new OrderServiceImpl();
			Order order = service.findOrderInfo(orderId);
			request.setAttribute("order", order);
			request.getRequestDispatcher("/orderInfo.jsp").forward(request, response);
		} catch (OrderException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}