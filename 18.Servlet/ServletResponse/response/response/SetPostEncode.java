package response;
/**
 *   ��ֹ��post�ύ��ʱ�����������룬���ֵĿ��ܺܵ�
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
		//���ñ��룬��ֹ��post�ύ��ʱ������������
		req.setCharacterEncoding("utf-8");
		String parameter = req.getParameter("username");
		System.out.println(parameter);
	}
}
