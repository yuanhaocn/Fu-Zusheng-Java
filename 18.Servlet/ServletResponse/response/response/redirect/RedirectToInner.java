package response.redirect;
/**
 * ��վ��ת
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseRedirect02")
public class RedirectToInner extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ҳ����ת��ʼ������");
		/*
		 * ҳ����ת
		 * 	վ�⣺������վ��վ���URL
		 *  վ�ڣ������ǵ�ǰվ���uri
		 *  �ض����������������ڿͻ��˵���ת��Ϊ
		 *  request����ͻ�ʧЧ����Ϊ��ֻ����һ��������Ч��ת���Ƕ�������
		 */
		resp.sendRedirect("/ServletResponse/a.html");
		System.out.println("ҳ���Ѿ���ת��");
	}

}
