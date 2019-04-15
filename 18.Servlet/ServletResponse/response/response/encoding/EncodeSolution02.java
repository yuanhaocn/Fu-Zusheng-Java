package response.encoding;
/**
 * 解决乱码一
 * 解决乱码二
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo02")
public class EncodeSolution02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//两个一起用,必须成对存在
	resp.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=UTF-8");
	//resp.addHeader("Content-Type", "text/html;charset=UTF-8");//其他的方法设置编码

	PrintWriter writer = resp.getWriter();
	writer.print("hello world");
	writer.print("你好");
	}
}
