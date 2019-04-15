package URLRewrite;
/**
  	2.�ض����url��д
	���룺
		UrlDemo01 ������url���룬�����ض���
		UrlDemo02 ��session�Ļ�ȡ������Cookieײ������Ч��
	�����
		1�����û�н���cookie����Ȼ����cookie�ķ�ʽ
			�������cookie�ͻ�url��д��urlһ�㲻�Ƽ�
		2�����������Cookie��ת�������ض����session������ͬһ��
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/udemo02")
public class URLDemo02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean b = session.isNew();
		//�ж�session�Ƿ����½���
		System.out.println(b);
		System.out.println("udemo02��ȡ�ģ�"+session.getId());
	}

}
