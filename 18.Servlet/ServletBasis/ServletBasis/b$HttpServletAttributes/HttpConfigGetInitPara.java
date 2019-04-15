package b$HttpServletAttributes;
 /**
  * 只能获取<servlet><init-param></init-param></servlet>
  * 之间的
  * <init-param></init-param>
  */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpConfigGetInitPara extends HttpServlet {
		//重写doGet   和  doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//获取ServletConfig对象
			ServletConfig servletConfig = getServletConfig();
			//获取所有初始化参数的名字
			// --获取当前Servlet中配置的初始化参数（只能获取一个）经常用到
			// String value = config.getInitParameter("characterCoding");	
			Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
			// --获取当前Servlet中配置的初始化参数（全部获取）经常用到
			//使用枚举迭代器遍历枚举
			while(parameterNames.hasMoreElements()) {
				//获取当前的name
				String currentName = parameterNames.nextElement();
				//根据名字获取初始化参数的值
				String currentValue = servletConfig.getInitParameter(currentName);
				System.out.println(currentName+"   "+currentValue);
			}
		}
}
