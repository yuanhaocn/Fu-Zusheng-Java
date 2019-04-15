package com.syc.product.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.product.dao.ProductDao;
import com.syc.product.domain.Product;

/**
 * 商品详情页面
 * 
 * @类名称:DetailServlet
 * @创建人:SYC
 * @创建时间:2017年7月20日 上午10:13:52
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		// 取出商品编号
		// 无论get还是post请求,都是利用该方法来取出请求参数的内容.
		String id = request.getParameter("id");

		// 根据id来获取商品
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);

		String html = "";
		html += "<html>";
		html += "<head>";
		html += "<title>";
		html += "商品详情";
		html += "</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='400px' cellspacing='1' cellpadding='0'>";

		// 绘制商品详情行
		if (product != null) {
			html += "<tr align='center'><td>商品编号</td><td>" + product.getId() + "</td></tr>";
			html += "<tr align='center'><td>商品名称</td><td>" + product.getPname() + "</td></tr>";
			html += "<tr align='center'><td>商品价格</td><td>" + product.getPrice() + "</td></tr>";
			html += "<tr align='center'><td>商品类型</td><td>" + product.getType() + "</td></tr>";
		}

		html += "</table>";

		html += "</br><center><a href='" + request.getContextPath() + "/proList'>返回商品列表</a></center>";

		writer.write(html);

		// 创建Cookie
		//
		//Cookie cookie = new Cookie("proHistory", "2-1");
		Cookie cookie = new Cookie("proHistory", createValue(request, id));
		cookie.setMaxAge(30 * 24 * 60 * 60);
		response.addCookie(cookie);
	}

	// 用来创建Cookie的值
	private String createValue(HttpServletRequest request, String id) {

		Cookie[] cookies = request.getCookies();

		// 历史记录
		String proHistory = null;

		// 如果Cookie不为空,说明之前访问该商品.
		if (cookies != null) {
			for (Cookie ck : cookies) {
				if ("proHistory".equals(ck.getName())) {
					// 取出历史记录
					proHistory = ck.getValue();
					break;
				}
			}
		}

		// 如果某个商品没有浏览过.对于前3次访问,直接获取对应商品的id即可.
		if (cookies == null || proHistory == null) {
			return id;
		}

		// 历史记录的规则:
		// proHistory=3-2-1
		// proHistory=4-3-2
		// proHistory=5-4-3
		// proHistory=6-5-4
		// 因为数组适合查询,不适合增删.
		String[] split = proHistory.split("-");
		List<String> collect = Arrays.asList(split);
		// LinkedList适合增删,不适合查询.
		LinkedList<String> ids = new LinkedList<>(collect);

		// id历史记录,要么小于3,要么大于等于3.
		if (ids.size() < 3) {
			if (ids.contains(id)) {// 判断该集合中之前是否有过该id.
				// 先移除之前的历史记录
				ids.remove(id);
				// 再重现把该id添加到集合的第一行.
				ids.addFirst(id);
			} else {
				// 将该id添加到集合的第一行.
				ids.addFirst(id);
			}
		} else {// >=3
			if (ids.contains(id)) {
				ids.remove(id);
				ids.addFirst(id);
			} else {
				// 移除最早的那个历史记录id
				ids.removeLast();
				// 把该商品添加到第一行.
				ids.addFirst(id);
			}
		}

		// 将id进行拼接
		// 历史记录的规则:
		// proHistory=3-2-1
		// proHistory=4-3-2
		// proHistory=5-4-3
		// proHistory=6-5-4-
		StringBuffer sb = new StringBuffer();
		for (String str : ids) {
			sb.append(str + "-");
		}
		
		String result= sb.toString();
		//截取子串,目的是为了去掉最后的-
		//2-1
		return result.substring(0, result.length()-1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
