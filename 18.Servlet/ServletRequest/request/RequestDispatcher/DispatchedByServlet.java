package RequestDispatcher;
/**
 * void   removeAttribute(String name)       ɾ��ָ�����Ƶ������
 ���ۣ�
	ֻ��һ����������Ч
	
 ����һ������Ľ��ͣ�
	1������һ��
	2������δ������һֱ����ת��״̬��ת�����ٴΣ�����һ������
	
������
	1����ʱ���Ͻ�������ӿͻ��˷�����ʼ��������������Ϊֹ��
		service����ִ����ϣ�������servlet��ʹ��response����������Ӧ
	2���ڿռ��Ͻ���������ֻҪһֱת����request��ֵ����һֱ������ȥ
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

@WebServlet("/rdemo09")
public class DispatchedByServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ʹ��request�����ȡֵ
		Object value = req.getAttribute("name");
		System.out.println(value);
	}
}