package getHeadInfo;
/**
 * html��servlet�Ľ�����
 *		getHeader(String name)��ȡָ�����Ƶ�������Ϣͷ��ֵ
 *		Enumeration<String> getHeaderNames()��ȡ���е�������Ϣͷ�����ֵ�ö�ٵ�����
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getHeaderNames")
public class getHeaderNames extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1.��ȡ���е�������Ϣͷ
	 Enumeration<String> names = req.getHeaderNames();
	 //2.����������
	 while (names.hasMoreElements()) {
		String name = (String) names.nextElement();
	//3.�������ƻ�ȡֵ
		String value = req.getHeader(name);
		//4��ӡ���ƺ�ֵ
		System.out.println(name+"  "+value);
	}
	}
}
