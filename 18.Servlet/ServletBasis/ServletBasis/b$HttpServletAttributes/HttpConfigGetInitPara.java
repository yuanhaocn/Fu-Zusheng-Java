package b$HttpServletAttributes;
 /**
  * ֻ�ܻ�ȡ<servlet><init-param></init-param></servlet>
  * ֮���
  * <init-param></init-param>
  */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpConfigGetInitPara extends HttpServlet {
		//��дdoGet   ��  doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//��ȡServletConfig����
			ServletConfig servletConfig = getServletConfig();
			//��ȡ���г�ʼ������������
			// --��ȡ��ǰServlet�����õĳ�ʼ��������ֻ�ܻ�ȡһ���������õ�
			// String value = config.getInitParameter("characterCoding");	
			Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
			// --��ȡ��ǰServlet�����õĳ�ʼ��������ȫ����ȡ�������õ�
			//ʹ��ö�ٵ���������ö��
			while(parameterNames.hasMoreElements()) {
				//��ȡ��ǰ��name
				String currentName = parameterNames.nextElement();
				//�������ֻ�ȡ��ʼ��������ֵ
				String currentValue = servletConfig.getInitParameter(currentName);
				System.out.println(currentName+"   "+currentValue);
			}
		}
}
