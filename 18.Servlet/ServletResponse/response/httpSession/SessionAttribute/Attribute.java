package httpSession.SessionAttribute;
/**

 * 	session���������ƻỰ���������һ�ο����ڼ䣬���ڵ�ǰ�������Ķ�η���
	(�������Ӧ)��Ϊһ�λỰ����һ�λỰ�ڼ䣬ֻҪ������session�������ڣ�
	session����Ψһ�ģ���������Ч��
	�ر���Ҫע����ǣ��ر������֮�󣬷������ϵ�session����û����ʧ������
	����ͨ�������ֶ��һ���һ�η��ʵ�session����
	ֻҪ����һ�λỰ�ڼ䣬������ת�������ض���session��һֱ��Ч

   
         ��session�л��������ֵ
 * ��session��������������ֵ
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo08")
public class Attribute extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����������
		req.setAttribute("requestScope", "request");
		//����session��
		req.getSession().setAttribute("sessionScope", "session");
		//����������
		getServletContext().setAttribute("servletContextScope", "servletContext");
		//��һ��ѡ��ת����sdemo09
		req.getRequestDispatcher("/sdemo09").forward(req, resp);
		//�ڶ���ѡ���ض���sdemo10
		//resp.sendRedirect("/ServletResponse/sdemo10");
	}

	
}
