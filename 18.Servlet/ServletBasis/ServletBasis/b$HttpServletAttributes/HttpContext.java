package b$HttpServletAttributes;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
二、ServletContext：代表当前web应用（非常重要）
 
		WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。
	ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
	可以通过ServletConfig.getServletContext方法获得ServletContext对象。
	
	由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。
	ServletContext对象通常也被称之为context域对象。
	
	
ServletContext的应用：
	1.做为域对象可以在整个web应用范围内共享数据。
		这里涉及到一些概念：
		域对象：在一个可以被看见的范围内共享数据用到对象
		作用范围：整个web应用范围内共享数据
		生命周期：当服务器启动web应用加载后创建出ServletContext对象后，域产生。当web应用被移除出容器或服务器关闭，随着web应用的销毁域销毁。 
 
context中常用的方法有：
	void setAttribute(String,Object);
	Object getAttribute(String);
	void removeAttribute(String);
 

2、获取WEB应用的初始化参数

	我们在ServletConfig的getInitParameter练习中，通过<init-param>标签为某一个单独的servlet加配置信息，这种配置信息在其他的Servlet中是
	无法访问到的。可如果我们使用<context-param>标签（与Servlet标签并列）为整个Web应用配置属性的话，那所有的Servlet就都能访问里面的参数了。
例如：可以把数据库的配置信息放在这里。

这里涉及到一些概念不要混淆：

	请求参数 parameter --- 浏览器发送过来的请求中的参数信息
	初始化参数 initparameter --- 在web.xml中为Servlet或ServletContext配置的初始化时带有的基本参数
	域属性 attribute --- 四大作用域中存取的键值对
 */
public class HttpContext  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.通过ServletConfig对象获取ServletContext对象
		ServletContext context01 = getServletConfig().getServletContext();
		System.out.println(context01);
		// 2.直接调用getServletContext方法获取--->>单例模式，只有一个对象	
		ServletContext context02 = getServletContext();
		System.out.println(context02);
	}
}
