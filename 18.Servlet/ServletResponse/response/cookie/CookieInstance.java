package cookie;
/**
Cookie��
	cookie��һ�ν�С�����ݣ��ɷ������������͵��ͻ��ˣ�����Ҳ���Դӿͻ���ͨ��
	�������Я��������������ΪCookie��Ψһ�ģ����Կ�����������Session��
	cookie����name��value��������Ҫ�����ԣ���Ȼ��������������������ڵ�����
	
���췽����
	Cookie(String name,String value)   ͨ��name��value����Cookie����
	
����Cookie��
	void  addCookie(Cookie cookie)ʹ��reponse�����cookie�����Ӧ��Ϣͷ���淢�͵��ͻ��ˣ�
		һ��һ��վ���cookie������20��

 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo01")
public class CookieInstance extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1.����һ��Cookie����,�������ֵ�Ǵӿͻ������������ģ������Ƿ������Լ�Ū��
		Cookie cookie = new Cookie("VIP","9191porn");
	//2.��ӵ�response����
		resp.addCookie(cookie);
		
	}
	
}