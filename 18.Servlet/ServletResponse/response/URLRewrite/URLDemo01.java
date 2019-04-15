package URLRewrite;
/**
 * url��д���cookie�Ľ������⣨jsession�ᱻ���ڵ�ַ�����洫��servlet��������
 * �����������cookie��ʱ�������servlet��ת��ʹ��ͬһ��session����
 * �Ա�֤��Ϣ�ڲ�ͬ�ĵط�����
 * ��ת����URL���б���ֱ�ӽ�session������һ��servlet��ȥ����һ���Ͳ��ô����µ�session
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/udemo01")
public class URLDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//��Ҫ���ض����URL���б��룬����ת��ҳ��ļӹ�,���԰�jsessionid�󶨵���ַ�����д���
		String encodeURL = resp.encodeRedirectUrl("/ServletResponse/udemo02");
		//��ȡsession����
		System.out.println("udemo01��ȡ�ģ�"+session.getId());
		resp.sendRedirect(encodeURL);
	}
}
