package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImp.UserHandleImp;
import serviceImp.ManagerUserImp;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.addHeader("Content-type", "text/html;charset=UTF-8");
		String number = req.getParameter("number");
		String password = req.getParameter("password");

		// 调用service层
		ManagerUserImp userImp = new ManagerUserImp();
		userImp.setUh(new UserHandleImp());
		boolean b = userImp.login(number, password);

		if (b) {
			// 判断多选框是否选中
			if (req.getParameter("remeber") != null && req.getParameter("remeber").equals("yes")) {
				//设置cookie保存用户名和密码
				Cookie cookie = new Cookie("userInfo",number+"_"+password);
				//设置cookie的生命周期
				cookie.setMaxAge(30*60);
				//通过response对象把cookie添加早响应上
				resp.addCookie(cookie);
			}
			// 页面跳转
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

}
