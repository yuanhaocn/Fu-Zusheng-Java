package b$HttpServletAttributes;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
����ServletContext������ǰwebӦ�ã��ǳ���Ҫ��
 
		WEB����������ʱ������Ϊÿ��WEBӦ�ó��򶼴���һ����Ӧ��ServletContext����������ǰwebӦ�á�
	ServletConfig������ά����ServletContext��������ã�������Ա�ڱ�дservletʱ��
	����ͨ��ServletConfig.getServletContext�������ServletContext����
	
	����һ��WEBӦ���е�����Servlet����ͬһ��ServletContext�������Servlet����֮�����ͨ��ServletContext������ʵ��ͨѶ��
	ServletContext����ͨ��Ҳ����֮Ϊcontext�����
	
	
ServletContext��Ӧ�ã�
	1.��Ϊ��������������webӦ�÷�Χ�ڹ������ݡ�
		�����漰��һЩ���
		�������һ�����Ա������ķ�Χ�ڹ��������õ�����
		���÷�Χ������webӦ�÷�Χ�ڹ�������
		�������ڣ�������������webӦ�ü��غ󴴽���ServletContext��������������webӦ�ñ��Ƴ���������������رգ�����webӦ�õ����������١� 
 
context�г��õķ����У�
	void setAttribute(String,Object);
	Object getAttribute(String);
	void removeAttribute(String);
 

2����ȡWEBӦ�õĳ�ʼ������

	������ServletConfig��getInitParameter��ϰ�У�ͨ��<init-param>��ǩΪĳһ��������servlet��������Ϣ������������Ϣ��������Servlet����
	�޷����ʵ��ġ����������ʹ��<context-param>��ǩ����Servlet��ǩ���У�Ϊ����WebӦ���������ԵĻ��������е�Servlet�Ͷ��ܷ�������Ĳ����ˡ�
���磺���԰����ݿ��������Ϣ�������

�����漰��һЩ���Ҫ������

	������� parameter --- ��������͹����������еĲ�����Ϣ
	��ʼ������ initparameter --- ��web.xml��ΪServlet��ServletContext���õĳ�ʼ��ʱ���еĻ�������
	������ attribute --- �Ĵ��������д�ȡ�ļ�ֵ��
 */
public class HttpContext  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.ͨ��ServletConfig�����ȡServletContext����
		ServletContext context01 = getServletConfig().getServletContext();
		System.out.println(context01);
		// 2.ֱ�ӵ���getServletContext������ȡ--->>����ģʽ��ֻ��һ������	
		ServletContext context02 = getServletContext();
		System.out.println(context02);
	}
}
