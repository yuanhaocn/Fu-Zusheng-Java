package cookie;
/**
 * ���cookie�Ļ�ȡ
 * 	 
 ע�⣺
	1����ָ���쳣����������һ�η��ʷ�������ʱ�򣬴�ʱû��Cookie
	���ֻ��Ҫ�������鲻Ϊ�ռ���
	
	2��ֻ��ͨ�������ȡ�����ܵ�����ȡ
	
	3����ʱ���е�Cookie�����������ͬ�ģ��������ý�ȥ��cookie
	�ٴλ�ȡ��ʱ��Ҳ����ͬһ������

.Cookie��һЩ����
	String	getName()  ��ȡCookie������
	String	getValue()   ��ȡCookie��ֵ
	String	getDomain()   ��ȡCookie����

 */
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo04")
public class GetMutiCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1����ȡ���е�cookie
		Cookie[] cookies = req.getCookies();
		// 2���������飬��Ҫ�ж����鲻Ϊ�յĿ���cookies != null
		for (int i = 0; cookies != null && i < cookies.length; i++) {
		// System.out.println("��ȡ���ĵ�"+(i+1)+"��cookie��"+cookies[i]);
		// 3����ȡcookie�������������
			System.out.println(cookies[i].getMaxAge());
		// 4����ȡname��value����
			System.out.println(cookies[i].getName() + "  " + cookies[i].getValue());
		}
	}

}
