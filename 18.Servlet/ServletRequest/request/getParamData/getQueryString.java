package getParamData;
/**
 *  getMethod()��ȡǰ�˵��ύ��ʽ
 *  getQueryString()��ȡ�ύ������
 *  ������a.html�ļ�����������ӣ������ӻὫ�����ύ����������Ȼ������rdemo04servlet���򣬻�ȡ�ύ�Ķ�����
 *  ���ǵõ������ݱ���������,���൱����������ĵ�ַ��ֱ��������صı���Ϣ��û������
 *  
<a href="http://localhost:8080/ServletRequest01/rdemo04?name='fzs'&age=12&sex='nan'">�ύ����</a>
	�õ��Ľ���ǣ�name=%27fzs%27&age=12&sex=%27nan%27
	
	ע�⣺
		��������get����
		formĬ����get���󣬳���ʹ��method��������Ϊpost

 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getQueryString")
public class getQueryString extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡǰ���ύ������
		String queryString = req.getQueryString();
		System.out.println(queryString);
		//��ȡ��ǰ�ύ���ݵ�����ʽ
		String method = req.getMethod();
		System.out.println(method);
	}
}
