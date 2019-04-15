package com.qfedu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qfedu.domain.SendTie;
import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.TieManagerServiceImp;

@WebServlet("/autoQueryTiesServlet")
public class AutoQueryTiesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应乱码
		resp.setContentType("text/html; charset=utf-8");
		//获取session域的值
		UserExt ue = (UserExt)req.getSession().getAttribute("currentUser");
		TieManagerServiceImp tmsi = new TieManagerServiceImp();
		//调用方法生成集合
		List<SendTie> tiesList = tmsi.getTiesByUsername(ue.getUsername());
		//转为json数组字符串
		Gson gson = new Gson();
		String jsonStr = gson.toJson(tiesList);
		//System.out.println(jsonStr);
		//设置把jsonStr写回前端
		resp.getWriter().write(jsonStr);
	}
}
