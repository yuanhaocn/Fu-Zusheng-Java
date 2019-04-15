package com.syc.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 查看购物车
 * 
 * @类名称:ShowCarServlet
 * @创建人:SYC
 * @创建时间:2017年7月21日 上午9:54:44
 */
public class ShowCarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		HttpSession session = request.getSession();
		List<Product> products = (List<Product>) session.getAttribute("car");
		if (products != null) {
			String html = "";
			for (Product product : products) {
				html += "<p>商品编号:" + product.getId() + ",商品名称" + product.getPname() + ",商品价格" + product.getPrice()
						+ "</p>";
			}
			writer.write(html);
		} else {
			writer.write("购物车为空!");
			response.setHeader("refresh", "3;url=" + request.getContextPath() + "/productList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}