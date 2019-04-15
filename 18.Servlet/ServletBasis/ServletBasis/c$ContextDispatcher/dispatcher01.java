package c$ContextDispatcher;
/**
 * ҳ�潻������ת��--����servlet��servlet,��ע��ķ�ʽ������XML����  
 * 
 * dispatcher01����һ��������ֵ��name:fzs 
 * Ȼ����ת��dispatcher02��ͨ��getServletContext�ķ���getAttribute���name��value����fzs��
 * ����ת��dispatcher03ͨ��getServletContext�ķ���removeAttribute�����Ƴ�name
 * 
 * ����ٴε���dispatcher02������õ��յ�valueֵ����Ϊname��valueֵ�Ѿ���dispatcher03�Ƴ���
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher01")
public class dispatcher01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		System.out.println(sc);
		//����������ֵ
		sc.setAttribute("name", "fzs");
		/*
		 * ҳ����ת��ָ����servlet
		 * 
		 *������
		 *	��Ҫ��ת��servlet��urlparrent
		 *Ȼ����forword����
		 *����������doGet�����Ĳ���
		 */
		System.out.println("dispatcher01����ת��dispatcher02");
		sc.getRequestDispatcher("/dispatcher02").forward(req, resp);
	}
}
