package getHeadInfo;
/**
 * getHeader(String name)��ȡָ�����Ƶ�������Ϣͷ��ֵ
 * 
 * ��ȡ�û��������־����ʾ
 * ��������������ʴ˷��������������Chrome���������ʾshow.htmlҳ�棬������Ǿ���ʾinfo.htmlҳ��
 * 	������Ϣͷ��
		��ҳѹ����ʽ
		Accept-Encoding: gzip, deflate, br
		��ҳ�����ʽ
		Accept-Language: zh-CN,zh;q=0.9
		��ǰ��ҳ������״̬
		Connection: keep-alive
		��ǰ��ҳ������cookie��Ϣ
		Cookie: WWW_ST=1525228962878
		��ǰ���ʵ�������
		Host: www.baidu.com
		��ǰ���ʸ���վ���豸��ϵͳ���������Ϣ
		User-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36
		�Ƿ�ʹ��ajax�Ľ�����ʽ
		X-Requested-With: XMLHttpRequest

 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getHeader")
public class getHeader extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��ȡ�û��������־
		String value = req.getHeader("user-agent");
		//2�����������Google������ʾʹ�ùȸ������
		if (!value.contains("Chrome")) {
		//3.ҳ�� ��ת��ʾʹ�ùȸ������(���õ���Ա��������)
			getServletContext().getRequestDispatcher("/info.html").forward(req, resp);
		}else {
			getServletContext().getRequestDispatcher("/show.html").forward(req, resp);
		}
	}
}
