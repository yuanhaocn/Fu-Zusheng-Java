package com.syc.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 商品详情页面,将该商品添加到购物车
 * 
 * @类名称:DetailServlet
 * @创建人:SYC
 * @创建时间:2017年7月21日 上午9:39:08
 */
public class DetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		// 根据id获取具体的商品信息
		String id = request.getParameter("id");
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);

		//获取Session对象
		HttpSession session = request.getSession();
		//取出Session中的购物车
		List<Product> products = (List<Product>) session.getAttribute("car");
		if (products == null) {
			products = new ArrayList<>();
		}
		// 将该商品添加到集合中
		products.add(product);
		// 将集合添加到购物车中
		session.setAttribute("car", products);

		PrintWriter writer = response.getWriter();

		writer.write("添加购物车成功!");

		//设置response的响应头.refresh:自动刷新功能----3:3秒之后,定位到url中.
		response.setHeader("refresh", "3;url=" + request.getContextPath() + "/productList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}