package c$ContextDispatcher;
/**
 * �Ƴ�������ֵ
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher03")
public class dispatcher03 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡservletContext��ֵ��������������ͬ��servlet��
		ServletContext sc = getServletContext();
		 //�Ƴ�������ֵ
		System.out.println("�Ƴ�name,name��value����null");
		sc.removeAttribute("name");
	}
}
