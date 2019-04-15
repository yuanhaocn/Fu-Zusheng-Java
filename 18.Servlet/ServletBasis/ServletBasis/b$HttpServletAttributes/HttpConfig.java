package b$HttpServletAttributes;
/**
 * 【正文】

一、ServletConfig:代表当前Servlet在web.xml中的配置信息（用的不多）
		String getServletName()  -- 获取当前Servlet在web.xml中配置的名字
		String getInitParameter(String name) -- 获取当前Servlet指定名称的初始化参数的值
		Enumeration getInitParameterNames()  -- 获取当前Servlet所有初始化参数的名字组成的枚举
		ServletContext getServletContext()  -- 获取代表当前web应用的ServletContext对象
	在Servlet的配置文件中，可以使用一个或多个<init-param>标签为servlet配置一些初始化参数。

	当servlet配置了初始化参数后，web容器在创建servlet实例对象时，会自动将这些初始化参数封装到ServletConfig对象中，
	并在调用servlet的init方法时，将ServletConfig对象传递给servlet。进而，程序员通过ServletConfig对象就可以得到当前servlet的
	初始化参数信息。
这样做的好处是：如果将数据库信息、编码方式等配置信息放在web.xml中，如果以后数据库的用户名、密码改变了，则直接很方便地修改web.xml就行了，
避免了直接修改源代码的麻烦。 
 */
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpConfig extends HttpServlet {
		//重写doGet   和  doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//直接通过getServletConfig获取,这个相当于this.getServletConfig()--->是因为GenericServlet有这个东西
			ServletConfig sc =getServletConfig();
			System.out.println(sc);
			//获取当前Servlet的名字
			String name = sc.getServletName();
			System.out.println("当前Servlet 在web.xml中配置的名称:"+name);
//获取ServletContext对象-->org.apache.catalina.core.ApplicationContextFacade@16ed9eb
			ServletContext servletContext = sc.getServletContext();
			System.out.println(servletContext);
	}
}
