package cookie;
/**
Cookie的生命周期
	cookie在用户第一次访问该网站的时候产生，在若干次请求和响应之内
	都是有效的。但是一旦关闭了浏览器，Cookie马上消失。如果此时，再次
	打开浏览器访问，服务器会重新设置cookie。

效果：
	1）一旦关闭了浏览器，此时cookie仍存在于浏览器的本地缓存里面
	如果不设置，默认是-1，浏览器关闭即删除cookie
	2）设置了最大生命周期，在有效时间内，关闭后的浏览器再次
	访问该网站，服务器不再产生Cookie，浏览器依然保有该 Cookie
	3）Cookie在同一个浏览器的多个页面之间是共享的，也可以跨浏览器
	共享
 */
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo02")
public class CookieAge extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、构建cookie对象
		Cookie cookie = new Cookie("id",UUID.randomUUID().toString().replace("-", ""));
		//2、获取最大生命周期
		int maxAge = cookie.getMaxAge();
		System.out.println(maxAge);
		//3、设置最大生命周期
		cookie.setMaxAge(60*30);
		//4、把cookie添加到响应对象
		resp.addCookie(cookie);
	}
	
}
