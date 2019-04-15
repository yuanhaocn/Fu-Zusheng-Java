package b$HttpServletAttributes;
/**
 * getServletContext维护的是一个map
 * 
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpContextGetInitPara extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		//获取上下文路径
		String path = context.getContextPath();
		//得到的是/Demo01，也就是/当前应用名
		System.out.println(path);
		
		//获取所有的全局变量的名字，无参获得的是一个枚举类型的parameterNames
		Enumeration<String> parameterNames = context.getInitParameterNames();
		//枚举迭代器
		while(parameterNames.hasMoreElements()) {
			String currentName = parameterNames.nextElement();
			//根据名字获取值
			String currentValue = context.getInitParameter(currentName);
			System.out.println(currentName+"    "+currentValue);
		}
	}
}
