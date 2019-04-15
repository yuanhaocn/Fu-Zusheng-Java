package getEncodeInfo;
/**
 * 设置编码的第二种方式
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo02")
public class ContentType extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取contentTpe的值，可以在响应对象里面设置编码---》》》讲到response对象的时候讲解
		String contentType = req.getContentType();
		System.out.println(contentType);
	}
}
