package a$Create_Servlet_Method;

/**
 * ʵ����Servlet�ӿڣ�ʵ���Լ��ķ��������򡣴˳����Ǵ�����tomcat��������ϵġ��������Ϊ�û��ṩ��˾��ʵ��
 */
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo01 implements Servlet {

	@Override
	public void destroy() {
		// ��servlet�������ٵ���Ҫִ�еķ���
		System.out.println("���servletҪ�������ˡ�����");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// ��servlet���󱻴�����ʱ��ִ�еķ���
		System.out.println("��servletҪ�������ˡ�����");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// ���񷽷���servlet�ĺ��ķ������ṩ����ķ���
		System.out.println("����Ǻ���servlet����");
	}

}
