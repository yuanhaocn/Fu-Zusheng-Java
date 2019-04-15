package cookie;
/**
Cookie类
	cookie是一段较小的数据，由服务器产生发送到客户端，数据也可以从客户端通过
	请求对象携带到服务器。因为Cookie是唯一的，所以可以用来产生Session。
	cookie包含name和value两个最重要的属性，当然还有作用域，最大生命周期等属性
	
构造方法：
	Cookie(String name,String value)   通过name和value构建Cookie对象
	
发送Cookie：
	void  addCookie(Cookie cookie)使用reponse对象把cookie存进响应消息头里面发送到客户端，
		一般一个站点的cookie不超过20个

 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo01")
public class CookieInstance extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1.构建一个Cookie对象,这里面的值是从客户输入里面来的，，不是服务器自己弄的
		Cookie cookie = new Cookie("VIP","9191porn");
	//2.添加到response里面
		resp.addCookie(cookie);
		
	}
	
}