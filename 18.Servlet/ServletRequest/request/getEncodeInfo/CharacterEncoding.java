package getEncodeInfo;
/**
 * 设置编码的第一种方式
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo01")
public class CharacterEncoding extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取当前的编码方式
		String encoding01 = req.getCharacterEncoding();
		System.out.println(encoding01);
		// 2.设置编码方式为utf-8
		req.setCharacterEncoding("utf-8");
		// 2.使用getQueryString方法接收前段的值
		String str = req.getQueryString();
		System.out.println(str);
		System.out.println("current coding :" + req.getCharacterEncoding());
	}
}
