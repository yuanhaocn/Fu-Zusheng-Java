package httpSession.basis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/sdemo02")
public class SessionDemo02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡsession����
		HttpSession session = request.getSession();
		//��ȡ��ǰsession�����Ƿ����µ�session����
		boolean new1 = session.isNew();
		System.out.println(new1);
	}

}
