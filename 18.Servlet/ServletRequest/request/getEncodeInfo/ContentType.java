package getEncodeInfo;
/**
 * ���ñ���ĵڶ��ַ�ʽ
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo02")
public class ContentType extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡcontentTpe��ֵ����������Ӧ�����������ñ���---����������response�����ʱ�򽲽�
		String contentType = req.getContentType();
		System.out.println(contentType);
	}
}
