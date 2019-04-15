package getParamData;
/**
 *  getMethod()获取前端的提交方式
 *  getQueryString()获取提交的数据
 *  先启动a.html文件，点击超链接，超链接会将数据提交给服务器，然后启动rdemo04servlet程序，获取提交的额数据
 *  但是得到的数据编码有问题,就相当于在浏览器的地址栏直接输入相关的表单信息，没有区别
 *  
<a href="http://localhost:8080/ServletRequest01/rdemo04?name='fzs'&age=12&sex='nan'">提交数据</a>
	得到的结果是：name=%27fzs%27&age=12&sex=%27nan%27
	
	注意：
		超链接是get请求
		form默认是get请求，除非使用method属性设置为post

 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getQueryString")
public class getQueryString extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前端提交的数据
		String queryString = req.getQueryString();
		System.out.println(queryString);
		//获取当前提交数据的请求方式
		String method = req.getMethod();
		System.out.println(method);
	}
}
