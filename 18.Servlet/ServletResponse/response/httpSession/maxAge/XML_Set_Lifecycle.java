package httpSession.maxAge;

/**
 *  ʹ��XML�������������������
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo04")
public class XML_Set_Lifecycle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// ���ٵ�ǰ�û��󶨵�session
		System.out.println(session.getId());
		//������������������ȫ���޸�֮,���ٵ��Ǵ�������Ķ������������ڴ�����ģ��������δ�ӡ��id ��һ���ģ���Ϊ
		//���Ƕ������Ѿ��ڴ����棬
		session.invalidate();
		System.out.println(session.getId());
		// ��ȡ����ӡ
		System.out.println(session.getMaxInactiveInterval());
	}

}
