package response.status;
/**
 *  
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo03")
public class GetStatus extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��ǰ��״̬��,һ����200������������
		int status = resp.getStatus();
		System.out.println(status);
		//���ô������Ϊ404 500 502 ��ʱ���û��޷�������������ݣ��Լ������޴��������
		resp.setStatus(404);
		System.out.println(3/0);
	}
}
