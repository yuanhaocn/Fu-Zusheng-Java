package a$Create_Servlet_Method;
/**
 * ������һ�ַ���ʵ�ַ�ʽ�����ӹ��̣��������е�ķ������ಿ�ֲ���Ҫ���ģ�ֻҪдһ��service����
 */
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo02 extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("���Ǻ���Ů�ͷ��񷽷�...");
	}

}
