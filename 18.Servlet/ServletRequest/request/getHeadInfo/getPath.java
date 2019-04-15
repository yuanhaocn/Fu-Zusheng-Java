package getHeadInfo;
/**
 * request�еĸ���·��
 * 	getRequestURI()-->>uri:/ServletRequest/getPath(��Ŀ��+ע��)
 *	getRequestURL()-->>url:http://localhost:8080/ServletRequest/getPath
 *	getContextPath()-->>contextPath;/ServletRequest(��Ŀ��)
 * 	getServletPath()-->>servletPath:/getPath(ע����)
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getPath")
public class getPath extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uri = req.getRequestURI();
	System.out.println("uri:"+uri);
	StringBuffer url = req.getRequestURL();
	System.out.println("url:"+url);
	//��ȡ��ǰӦ��(��Ŀ)������
	String contextPath = req.getContextPath();
	System.out.println("contextPath;"+contextPath);
	//��ȡservlet�ĵ�urlparrent
	String servletPath = req.getServletPath();
	System.out.println("servletPath:"+servletPath);
	}
}
