package c$ContextDispatcher;
/**
 * 	ҳ�潻������ת��--����servlet��html:servlet���������ݵĴ���,html���������ݵ�չʾ
 * �������������dispatcher04��servletӦ�ã��ͻ��Զ���ʾ��ת��show.html
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher04")
public class dispatcher04 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�����Ķ���
		ServletContext sc = getServletContext();
		/*
		 *��תhtmlҳ�棬ע��һ��д��WebContent�У���WEB-INFƽ��
		 *��ʱ�����ǣ�/��ҳ����
		 */
		sc.getRequestDispatcher("/show.html").forward(req, resp);
	}
}
