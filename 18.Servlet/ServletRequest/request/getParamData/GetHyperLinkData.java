package getParamData;

/**
 * ��ȡ�������ύ��ֵ
 * http://localhost:8080/ServletRequest/rdemo03?name=%E5%BC%A0%E4%B8%89&age=12
 * ������
			String   ��ǰ��Ԫ�ؽڵ��name���Ե�ֵ�����ǳ������еȺ�ǰ�������
    ����ֵ��
		����Ԫ�ؽڵ������ֵ�������Խڵ��ֵ�������ı��ڵ�
	ע�⣺
		1���÷����������ڶ�ѡ��
		2�����ڵ�ѡ��ť����������ã�ѡ����on����ѡ����null,����ͨ����Ҫ���õģ�
		ֻ��Ҫ����radio��value���Լ���

 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo03")
public class GetHyperLinkData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡǰ�˳������ύ��ֵ
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// ��ӡname��age��ֵ
		System.out.println(name + "  " + age);
	}
}