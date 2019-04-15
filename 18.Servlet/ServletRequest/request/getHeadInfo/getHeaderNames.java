package getHeadInfo;
/**
 * html与servlet的交互，
 *		getHeader(String name)获取指定名称的请求消息头的值
 *		Enumeration<String> getHeaderNames()获取所有的请求消息头的名字的枚举的引用
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getHeaderNames")
public class getHeaderNames extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1.获取所有的请求消息头
	 Enumeration<String> names = req.getHeaderNames();
	 //2.迭代器遍历
	 while (names.hasMoreElements()) {
		String name = (String) names.nextElement();
	//3.根据名称获取值
		String value = req.getHeader(name);
		//4打印名称和值
		System.out.println(name+"  "+value);
	}
	}
}
