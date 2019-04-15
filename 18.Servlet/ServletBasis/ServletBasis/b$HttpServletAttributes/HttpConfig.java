package b$HttpServletAttributes;
/**
 * �����ġ�

һ��ServletConfig:����ǰServlet��web.xml�е�������Ϣ���õĲ��ࣩ
		String getServletName()  -- ��ȡ��ǰServlet��web.xml�����õ�����
		String getInitParameter(String name) -- ��ȡ��ǰServletָ�����Ƶĳ�ʼ��������ֵ
		Enumeration getInitParameterNames()  -- ��ȡ��ǰServlet���г�ʼ��������������ɵ�ö��
		ServletContext getServletContext()  -- ��ȡ����ǰwebӦ�õ�ServletContext����
	��Servlet�������ļ��У�����ʹ��һ������<init-param>��ǩΪservlet����һЩ��ʼ��������

	��servlet�����˳�ʼ��������web�����ڴ���servletʵ������ʱ�����Զ�����Щ��ʼ��������װ��ServletConfig�����У�
	���ڵ���servlet��init����ʱ����ServletConfig���󴫵ݸ�servlet������������Աͨ��ServletConfig����Ϳ��Եõ���ǰservlet��
	��ʼ��������Ϣ��
�������ĺô��ǣ���������ݿ���Ϣ�����뷽ʽ��������Ϣ����web.xml�У�����Ժ����ݿ���û���������ı��ˣ���ֱ�Ӻܷ�����޸�web.xml�����ˣ�
������ֱ���޸�Դ������鷳�� 
 */
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpConfig extends HttpServlet {
		//��дdoGet   ��  doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//ֱ��ͨ��getServletConfig��ȡ,����൱��this.getServletConfig()--->����ΪGenericServlet���������
			ServletConfig sc =getServletConfig();
			System.out.println(sc);
			//��ȡ��ǰServlet������
			String name = sc.getServletName();
			System.out.println("��ǰServlet ��web.xml�����õ�����:"+name);
//��ȡServletContext����-->org.apache.catalina.core.ApplicationContextFacade@16ed9eb
			ServletContext servletContext = sc.getServletContext();
			System.out.println(servletContext);
	}
}
