package RequestDispatcher;
/**
 * ����ת������һ��������������������ڲ������ת
 * ��˵�ַ���������ı䣬���ǿ��Է���Ŀ����Դ
 * 
 * RequestDispatcher	getRequestDispatcher(String path)
	һ�㲻�ǵ���ʹ�ã���Ҫ�ڷ����ķ���ֵҲ����RequestDispatcher�������
	����forword�������÷���������������request��response����

 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo07")
public class DispatchToHtml extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ת����ʼ");
		// ����ת������
		req.getRequestDispatcher("/target.html").forward(req, resp);
		System.out.println("ת������");
	}
}