package httpSession.basis;
/**
 * ÿ��web���̳�Apache/conf/web.xml�ļ�
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SessionInstance")
public class SessionInstance extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//��ȡsession����ֻ�ܻ�ȡ�����ܴ����������������������ɿͻ�����
		HttpSession session = req.getSession();
	//�鿴session��ID��ֵ
		String id = session.getId();
		System.out.println(id);
	}
	
}
