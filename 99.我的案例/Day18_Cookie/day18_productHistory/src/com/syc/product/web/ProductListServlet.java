package com.syc.product.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.product.dao.ProductDao;
import com.syc.product.domain.Product;

/**
 * 商品列表---->显示商品列表
 * 
 * @类名称:ProductListServlet
 * @创建人:SYC
 * @创建时间:2017年7月20日 上午9:45:38
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// 获取全部商品
		ProductDao dao = new ProductDao();
		List<Product> products = dao.findAll();

		PrintWriter writer = response.getWriter();

		// 输出商品表格
		String html = "";
		html += "<html>";
		html += "<head>";
		html += "<title>";
		html += "商品列表";
		html += "</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='600px' cellspacing='1' cellpadding='0'>";
		// 表头
		html += "<th>商品编号</th><th>商品名称</th><th>商品价格</th><th>商品类型</th>";

		// 动态生成每一行
		for (int i = 0; i < products.size(); i++) {
			// 有几个商品就创建几行
			html += "<tr align='center'>";
			Product product = products.get(i);
			// 创建td
			html += "<td>" + product.getId() + "</td><td><a href='" + request.getContextPath() + "/detail?id="
					+ product.getId() + "'>" + product.getPname() + "</a></td><td>" + product.getPrice() + "</td><td>"
					+ product.getType() + "</td>";

			html += "</tr>";
		}

		html += "</table>";

		html += "</br><center>最近浏览的商品</center></br>";

		// 取出历史浏览记录
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie ck : cookies) {
				if ("proHistory".equals(ck.getName())) {
					// 2-1
					String value = ck.getValue();
					String[] ids = value.split("-");
					for (String id : ids) {
						Product product = dao.findById(id);
						//输出每一个历史记录
						html += "<center>" + product.getId() + "&nbsp;" + product.getPname() + "&nbsp;"
								+ product.getPrice() + "</center>";
					}
				}
			}
		}

		html += "</body>";
		html += "</html>";

		writer.write(html);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
