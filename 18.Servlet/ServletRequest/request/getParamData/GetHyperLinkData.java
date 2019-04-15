package getParamData;

/**
 * 获取超链接提交的值
 * http://localhost:8080/ServletRequest/rdemo03?name=%E5%BC%A0%E4%B8%89&age=12
 * 参数：
			String   是前端元素节点的name属性的值或者是超链接中等号前面的名字
    返回值：
		就是元素节点里面的值，是属性节点的值，不是文本节点
	注意：
		1）该方法不能用于多选框
		2）对于单选按钮，如果不设置，选中是on，不选中是null,但是通常都要设置的，
		只需要设置radio的value属性即可

 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo03")
public class GetHyperLinkData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前端超链接提交的值
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// 打印name和age的值
		System.out.println(name + "  " + age);
	}
}