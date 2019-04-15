package cookie;
/**
 * 多个cookie的获取
 * 	 
 注意：
	1）空指针异常————第一次访问服务器的时候，此时没有Cookie
	因此只需要关心数组不为空即可
	
	2）只能通过数组获取，不能单独获取
	
	3）此时所有的Cookie对象均不是相同的，即遍设置进去的cookie
	再次获取的时候也不是同一个对象

.Cookie的一些方法
	String	getName()  获取Cookie的名字
	String	getValue()   获取Cookie的值
	String	getDomain()   获取Cookie的域

 */
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo04")
public class GetMutiCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、获取所有的cookie
		Cookie[] cookies = req.getCookies();
		// 2、遍历数组，需要判断数组不为空的可能cookies != null
		for (int i = 0; cookies != null && i < cookies.length; i++) {
		// System.out.println("获取到的第"+(i+1)+"个cookie是"+cookies[i]);
		// 3、获取cookie的最大生命周期
			System.out.println(cookies[i].getMaxAge());
		// 4、获取name和value属性
			System.out.println(cookies[i].getName() + "  " + cookies[i].getValue());
		}
	}

}
