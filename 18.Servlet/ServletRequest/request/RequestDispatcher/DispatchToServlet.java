package RequestDispatcher;
/**
 * 
 * 8————》9   :8的请求转发到9,考究ServletContext域对象的生命周期
 * 4.ServletContext域对象详细说明
	1）任何用户(浏览器)获取的该对象都是相同的
	2）任何用户设置的值和获取的值都是相同的，且都有效
	3）伴随ServletContext而生而死，ServletContext在应用加载的时候产生，在应用卸载的时候消失
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo08")
public class DispatchToServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 使用request对象设置域对象的值
		req.setAttribute("name", "账单");
		// 转发到09上
		req.getRequestDispatcher("/demo09").forward(req, resp);
	}
}