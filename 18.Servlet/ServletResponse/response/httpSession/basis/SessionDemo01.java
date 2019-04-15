package httpSession.basis;
/**
 * 	String	getId()  ��ȡsession�����id��Ҳ����JSESSIONID���cookie�����valueֵ
	long getLastAccessedTime()  ��ȡ��session�����������ʱ�䣬��Ϊsession�ǵ���ʱ��
	int	getMaxInactiveInterval()   ��ȡ����������ڣ�Ĭ��ֵ��30min,����ֵ����
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo01")
public class SessionDemo01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		//���·���ʱ��
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println("������ʱ����"+new Date(lastAccessedTime));
		//��ȡ��ǰsession ��IDֵ
		String id = session.getId();
		System.out.println("session�����ID����ֵ"+id);
		//��ȡ��ǰ��������
		int maxInactiveInterval = session.getMaxInactiveInterval();
		System.out.println("session������������������"+maxInactiveInterval);
	}

	
}
