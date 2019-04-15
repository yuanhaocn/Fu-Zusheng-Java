package com.syc.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.bookstore.domain.PageBean;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 图书分类展示及分页的Servlet
 * 
 * @类名称:BookServlet
 * @创建人:SYC
 * @创建时间:2017年7月12日 下午5:27:55
 */
public class BookCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		// 获取分类列表名称
		String category = request.getParameter("category");
		if (category == null) {
			category = "";
		}
		
		//默认当前页
		int currentPage=1;
		//每页显示的数量
		int pageSize=4;
		
		//获取当前页的索引值
		String current = request.getParameter("currentPage");
		if(current!=null&&current!=""){
			currentPage= Integer.parseInt(current);
		}
		
		//加载每页显示的数据
		IBookService service=new BookServiceImpl();
		//获取每页显示的图书信息
		PageBean pageBooks = service.pageBooks(pageSize, currentPage, category);

		//存放PageBean
		request.setAttribute("pageBooks", pageBooks);
		//跳转到商品展示列表
		request.getRequestDispatcher("/productList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
