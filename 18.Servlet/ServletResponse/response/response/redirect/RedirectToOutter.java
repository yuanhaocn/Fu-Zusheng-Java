package response.redirect;
/**
ת�����ض��������
	1.��ַ��
		ת����ַ�����䣬�ض���ĵ�ַ�������ı�
	2.�ٶ�
		ת�����ٶȿ죬�ض����ٶ���
	3.��Χ
		ת��ֻ�����ڵ�ǰ��Ŀ����ת��������ת���ܶ��
		�ض���������������Ŀ���ض���Ҳ�����ض���ܶ��
	4.����
		ת��������servletPath���ض������վ����������URL
		���ڱ�վ��URI
	5.�������
		ת����һ���������ڷ������ڲ���ת
		�ض����������������ڿͻ�����ת
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseRedirect")
public class RedirectToOutter extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ҳ����ת��ʼ������");
		/*
		 * ҳ����ת
		 * 	վ�⣺������վ��վ���URL
		 *  վ�ڣ������ǵ�ǰվ���uri
		 */
		resp.sendRedirect("http://www.baidu.com");
		System.out.println("ҳ���Ѿ���ת��");
	}

}
