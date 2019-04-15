package response.encoding;
/**
 * �����������new String("hello �ͻ���".getBytes(),Charset.forName("utf-8"))
 * ��Ӧ��Ϣ=��Ӧ��Ϣͷ����Ӧ��Ϣ��
 *response�ĳ��÷���
 *	addCookie(Cookie cookie) cookieʹ�õ�Ψһ����
 *	addHeader(name,value)
 
	������Ӧ��Ϣͷ��
		������������
		Cache-Control: no-cache
		�Ƿ񱣳�����
		Connection: Keep-Alive
		ҳ��������ռ��������
		Content-Type: text/html;charset=utf-8
		�������汾
		Server: apache

 */
import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo01")
public class EncodeSolution01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������Ӧ����
		resp.setCharacterEncoding("utf-8");
		//���������ռ��������
		resp.setContentType("text/html;charset=UTF-8");
		//����hello �ͻ��˵������--->>>�Լ���������תһ��
		resp.addHeader("info", new String("hello �ͻ���".getBytes(),Charset.forName("utf-8")));
		
	}
	
}
