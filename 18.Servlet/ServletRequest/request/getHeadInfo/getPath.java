package getHeadInfo;
/**
 * request中的各种路径
 * 	getRequestURI()-->>uri:/ServletRequest/getPath(项目名+注解)
 *	getRequestURL()-->>url:http://localhost:8080/ServletRequest/getPath
 *	getContextPath()-->>contextPath;/ServletRequest(项目名)
 * 	getServletPath()-->>servletPath:/getPath(注解名)
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
	//获取当前应用(项目)的名称
	String contextPath = req.getContextPath();
	System.out.println("contextPath;"+contextPath);
	//获取servlet的的urlparrent
	String servletPath = req.getServletPath();
	System.out.println("servletPath:"+servletPath);
	}
}
