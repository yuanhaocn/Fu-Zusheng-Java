package httpSession.maxAge;
/**
setMaxInactiveInterval( );��������session�������������
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sdemo03")
public class SetMaxInactiveInterval extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	//����������������
	 session.setMaxInactiveInterval(2100);//��ע�͵���Ӱ��XML ������
	//��ȡ����ӡ
	System.out.println(session.getMaxInactiveInterval());
	}
	
}
