package cookie;
/**
 * 多个cookie的设置
 * 	注意：第一次访问的时候会出现空指针异常---》》因此只需要关心数组不为空即可
 *	获取只能通过数组的形式获取
 *CookieDemo02-->>>CookieDemo03
 */
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo03")
public class SetMutiCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建两个cookie对象
		Cookie cookie01 = new Cookie("name","zhangsan");
		Cookie cookie02 = new Cookie("age","12");//数字也要双引号
		//设置最大生命周期
		cookie01.setMaxAge(60*30);
		cookie02.setMaxAge(60*60);
		//添加cookie到response对象上
		resp.addCookie(cookie01);
		resp.addCookie(cookie02);
		System.out.println("添加进去的第一个cookie是"+cookie01);
		System.out.println("添加进去的第一个cookie是"+cookie02);
	}
	
}
