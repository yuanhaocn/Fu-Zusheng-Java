package b$HttpServletAttributes;
/**
 * getServletContextά������һ��map
 * 
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpContextGetInitPara extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		//��ȡ������·��
		String path = context.getContextPath();
		//�õ�����/Demo01��Ҳ����/��ǰӦ����
		System.out.println(path);
		
		//��ȡ���е�ȫ�ֱ��������֣��޲λ�õ���һ��ö�����͵�parameterNames
		Enumeration<String> parameterNames = context.getInitParameterNames();
		//ö�ٵ�����
		while(parameterNames.hasMoreElements()) {
			String currentName = parameterNames.nextElement();
			//�������ֻ�ȡֵ
			String currentValue = context.getInitParameter(currentName);
			System.out.println(currentName+"    "+currentValue);
		}
	}
}
