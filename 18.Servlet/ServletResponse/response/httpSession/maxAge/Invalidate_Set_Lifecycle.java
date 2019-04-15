package httpSession.maxAge;

/**
 *  �޸�cdemo04
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo05")
public class Invalidate_Set_Lifecycle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session1 = req.getSession();
		// ���ٵ�ǰ�û��󶨵�session
		System.out.println(session1+"   "+session1.getId());
		//������������������ȫ���޸�֮��Ϊ�ݻٵ��Ǵ�����������л�session����
		//�Ѿ������ص��ڴ�����Ĳ��ܴݻ٣����Խ�����п���û��Ч��
		
		session1.invalidate();
		HttpSession session2=req.getSession();
		System.out.println(session2+"   "+session2.getId());

		// ��ȡ����ӡ
		System.out.println( session1+"����    "+session2);
	}

}
