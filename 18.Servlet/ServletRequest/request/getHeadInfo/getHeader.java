package getHeadInfo;
/**
 * getHeader(String name)获取指定名称的请求消息头的值
 * 
 * 获取用户浏览器标志并提示
 * 启动浏览器，访问此服务器程序，如果是Chrome浏览器就显示show.html页面，如果不是就显示info.html页面
 * 	请求消息头：
		网页压缩格式
		Accept-Encoding: gzip, deflate, br
		网页编码格式
		Accept-Language: zh-CN,zh;q=0.9
		当前网页在连接状态
		Connection: keep-alive
		当前网页保留的cookie信息
		Cookie: WWW_ST=1525228962878
		当前访问的主机名
		Host: www.baidu.com
		当前访问该网站的设备的系统和浏览器信息
		User-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36
		是否使用ajax的交互方式
		X-Requested-With: XMLHttpRequest

 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getHeader")
public class getHeader extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取用户浏览器标志
		String value = req.getHeader("user-agent");
		//2。如果不包含Google，，提示使用谷歌浏览器
		if (!value.contains("Chrome")) {
		//3.页面 跳转提示使用谷歌浏览器(先用调度员，不讲解)
			getServletContext().getRequestDispatcher("/info.html").forward(req, resp);
		}else {
			getServletContext().getRequestDispatcher("/show.html").forward(req, resp);
		}
	}
}
