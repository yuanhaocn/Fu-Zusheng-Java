package cookie;
/**
Cookie����������
	cookie���û���һ�η��ʸ���վ��ʱ������������ɴ��������Ӧ֮��
	������Ч�ġ�����һ���ر����������Cookie������ʧ�������ʱ���ٴ�
	����������ʣ�����������������cookie��

Ч����
	1��һ���ر������������ʱcookie�Դ�����������ı��ػ�������
	��������ã�Ĭ����-1��������رռ�ɾ��cookie
	2������������������ڣ�����Чʱ���ڣ��رպ��������ٴ�
	���ʸ���վ�����������ٲ���Cookie���������Ȼ���и� Cookie
	3��Cookie��ͬһ��������Ķ��ҳ��֮���ǹ���ģ�Ҳ���Կ������
	����
 */
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cdemo02")
public class CookieAge extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1������cookie����
		Cookie cookie = new Cookie("id",UUID.randomUUID().toString().replace("-", ""));
		//2����ȡ�����������
		int maxAge = cookie.getMaxAge();
		System.out.println(maxAge);
		//3�����������������
		cookie.setMaxAge(60*30);
		//4����cookie��ӵ���Ӧ����
		resp.addCookie(cookie);
	}
	
}
