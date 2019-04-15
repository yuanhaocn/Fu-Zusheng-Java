package response;
/**
 *   防止用post提交表单时出现请求乱码，出现的可能很低
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo06")
public class SetPostEncode extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码，防止用post提交表单时出现请求乱码
		req.setCharacterEncoding("utf-8");
		String parameter = req.getParameter("username");
		System.out.println(parameter);
	}
}
