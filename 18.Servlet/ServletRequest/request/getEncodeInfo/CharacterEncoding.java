package getEncodeInfo;
/**
 * ���ñ���ĵ�һ�ַ�ʽ
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo01")
public class CharacterEncoding extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.��ȡ��ǰ�ı��뷽ʽ
		String encoding01 = req.getCharacterEncoding();
		System.out.println(encoding01);
		// 2.���ñ��뷽ʽΪutf-8
		req.setCharacterEncoding("utf-8");
		// 2.ʹ��getQueryString��������ǰ�ε�ֵ
		String str = req.getQueryString();
		System.out.println(str);
		System.out.println("current coding :" + req.getCharacterEncoding());
	}
}
