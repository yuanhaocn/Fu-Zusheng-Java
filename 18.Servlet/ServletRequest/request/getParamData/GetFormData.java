package getParamData;

/**
 * ��ȡ���ύ��ֵ
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
		// ��ȡǰ�˱��ύ��ֵ
		// ���������ǰ���齨��name����һ��
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// ����ǰ�δ������ĵ�ѡ��ť
		String sex = req.getParameter("sex");
		System.out.println(username + "   " + password + "   " + sex);
	}
}