package cookie;
/**
 * ���cookie������
 * 	ע�⣺��һ�η��ʵ�ʱ�����ֿ�ָ���쳣---�������ֻ��Ҫ�������鲻Ϊ�ռ���
 *	��ȡֻ��ͨ���������ʽ��ȡ
 *CookieDemo02-->>>CookieDemo03
 */
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo03")
public class SetMutiCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������cookie����
		Cookie cookie01 = new Cookie("name","zhangsan");
		Cookie cookie02 = new Cookie("age","12");//����ҲҪ˫����
		//���������������
		cookie01.setMaxAge(60*30);
		cookie02.setMaxAge(60*60);
		//���cookie��response������
		resp.addCookie(cookie01);
		resp.addCookie(cookie02);
		System.out.println("��ӽ�ȥ�ĵ�һ��cookie��"+cookie01);
		System.out.println("��ӽ�ȥ�ĵ�һ��cookie��"+cookie02);
	}
	
}
