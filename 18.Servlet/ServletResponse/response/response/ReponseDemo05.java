package response;
/**
 * ��ȡ��Ӧ��Ϣͷ�������Ϣ 
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo05")
public class ReponseDemo05 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡĬ�ϱ��뷽ʽ
		String encoding = resp.getCharacterEncoding();
		System.out.println(encoding);
		//���ñ��뷽ʽ,��ʱ�򲻺��ã�����Ҫ���ϣ�����ټ���resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("���");
		System.out.println(resp.getCharacterEncoding());
	}
	
}
