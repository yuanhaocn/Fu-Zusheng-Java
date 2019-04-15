package RequestDispatcher;
/**
 * 
 * 8����������9   :8������ת����9,����ServletContext��������������
 * 4.ServletContext�������ϸ˵��
	1���κ��û�(�����)��ȡ�ĸö�������ͬ��
	2���κ��û����õ�ֵ�ͻ�ȡ��ֵ������ͬ�ģ��Ҷ���Ч
	3������ServletContext����������ServletContext��Ӧ�ü��ص�ʱ���������Ӧ��ж�ص�ʱ����ʧ
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

@WebServlet("/rdemo08")
public class DispatchToServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ʹ��request��������������ֵ
		req.setAttribute("name", "�˵�");
		// ת����09��
		req.getRequestDispatcher("/demo09").forward(req, resp);
	}
}