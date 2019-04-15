package a$Create_Servlet_Method;
/**
 * 摒弃第一种方法实现方式的冗杂过程，着眼于中点的服务，其余部分不需要关心，只要写一个service方法
 */
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo02 extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("这是核心女仆服务方法...");
	}

}
