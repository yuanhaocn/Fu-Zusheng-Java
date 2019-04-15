package getParamData;

/**
 * 获取表单提交的值
 * 
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo04")
public class GetFormData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取前端表单提交的值
		// 参数必须和前端组建的name属性一致
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 接收前段传过来的单选按钮
		String sex = req.getParameter("sex");
		System.out.println(username + "   " + password + "   " + sex);
	}
}