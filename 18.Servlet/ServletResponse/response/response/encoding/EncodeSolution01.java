package response.encoding;
/**
 * 解决编码问题new String("hello 客户端".getBytes(),Charset.forName("utf-8"))
 * 响应消息=响应消息头和响应消息体
 *response的常用方法
 *	addCookie(Cookie cookie) cookie使用的唯一方法
 *	addHeader(name,value)
 
	关于响应消息头：
		开启缓存设置
		Cache-Control: no-cache
		是否保持连接
		Connection: Keep-Alive
		页面乱码的终极解决方案
		Content-Type: text/html;charset=utf-8
		服务器版本
		Server: apache

 */
import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo01")
public class EncodeSolution01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应编码
		resp.setCharacterEncoding("utf-8");
		//解决乱码的终极解决方案
		resp.setContentType("text/html;charset=UTF-8");
		//发送hello 客户端到浏览器--->>>自己又又又又转一下
		resp.addHeader("info", new String("hello 客户端".getBytes(),Charset.forName("utf-8")));
		
	}
	
}
