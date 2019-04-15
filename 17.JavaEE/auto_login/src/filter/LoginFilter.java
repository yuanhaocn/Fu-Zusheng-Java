package filter;

/**
 * 自动登录的过滤器
 * 拦截所有的资源，再判断放行，判断是否有用户信息，有用户信息的话就挡住  没有局放行到login.jsp
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserHandle;
import daoImp.UserHandleImp;
import domain.User;
import serviceImp.ManagerUserImp;
import util.CookieUtil;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1.把请求和响应对象转为标准的请求和响应对象,以为servlet的请求和响应方法不全
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 2.获取session对象里面域对象的值
		User user = (User) req.getSession().getAttribute("user"); 
		// 3.判断该对象是否存在
		if (user == null) {
			// 4.判断cookie中是否有用户名和密码的存在
			// 5.获取cookie对象
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtil.getCookie(cookies, "userInfo");
			// 6.判断该对象是否为空,没有登录过为空
			if (cookie == null) {
				chain.doFilter(req, resp);
			} else {
				// 7.读取cookie对象里面存储的number和password信息
				String value = cookie.getValue();
				String number = value.split("_")[0];
				String password = value.split("_")[1];
				// 8.调用service层的登录逻辑，判断用户名和密码是否正确
				ManagerUserImp managerUserImp = new ManagerUserImp();
				managerUserImp.setUh(new UserHandleImp());
				boolean b = managerUserImp.login(number, password);
				// 9.如果正确，就把该用户名和密码构建use对象存进session
				if (b) {
					User trueUser = new User();
					trueUser.setNumber(number);
					trueUser.setPassword(password);
					req.getSession().setAttribute("user", trueUser);
				}
				// 10.无论如何都放行
				chain.doFilter(req, resp);
			}
		} else {
			// 11.如果session里面的user不为空，放行
			chain.doFilter(req, resp);
		}
	}

}
