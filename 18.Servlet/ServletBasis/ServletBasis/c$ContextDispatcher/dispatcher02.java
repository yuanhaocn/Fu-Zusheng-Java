package c$ContextDispatcher;
/**
 * 	ҳ�潻������ת��--����servletDemo01��servletDemo02
 * javaee��������������û���
 * servletContext�����
 * 
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher02")
public class dispatcher02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡservletContext��ֵ��������������ͬ��servlet��
		ServletContext sc = getServletContext();
		System.out.println(sc);
		Object value = sc.getAttribute("name");
		System.out.println("name��valueֵ��"+value);
		System.out.println("dispatcher02����ת��dispatcher03");
		sc.getRequestDispatcher("/dispatcher03").forward(req, resp);
	}
	
}
