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

@WebServlet("/rdemo04")
public class SetDateHeader extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����һ����Ӧ��Ϣͷ,��׼ʱ�䲻�Ƕ������ģ�������candela��ȡ
		resp.setDateHeader("Date", new Date().getTime());
		//�������ƻ�ȡ��Ӧ��Ϣͷ�����cookie����ȥ
		String dateInfo = resp.getHeader("Date");
		System.out.println(dateInfo);
	}
	
}
