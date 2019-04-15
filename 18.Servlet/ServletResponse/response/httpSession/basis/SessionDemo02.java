package httpSession.basis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/sdemo02")
public class SessionDemo02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//获取当前session对象是否是新的session对象
		boolean new1 = session.isNew();
		System.out.println(new1);
	}

}
