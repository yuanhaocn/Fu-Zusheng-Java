package com.syc.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor02 implements HandlerInterceptor {

	//1.preHandle()执行时机:
	//当用户输入了一个url发起request请求之后,该请求会先到达DispatcherServlet,然后DispatcherServlet将该请求中的url取出,
	//交给处理器映射器,处理器映射器根据该url去寻找对应的处理器,此时preHandle()方法会在处理器映射器返回Handler处理器之前开始工作.
	//也就是说在处理器还没有工作之前,会执行preHandle()方法.
	//2.preHandle()使用场景:校验用户身份,对用户的身份进行识别和拦截,作用等同于过滤器和Struts里的拦截器;
	//3.返回值:是否放行,true:放行,request对象可以进入到下一个拦截器或者handler中;
	//  false:不放行,会拦截下一个拦截器或者handler,
	//4.执行顺序:该方法会按照注册的顺序执行.
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Interceptor02---->preHandle()方法执行了...");
		
		return true;
	}

	//1.执行时机:
	//当处理器适配器已经开始处理Handler,也就是进入到了Handler的相关方法中了,但是还没有返回ModelAndView之前来执行.
	//2.使用场景:
	//  通常在该方法中,会对我们的View做统一的或者自定义的修改.
	//3.执行顺序:该方法的执行顺序与注册顺序逆序!
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Interceptor02---->postHandle()方法执行了...");
	}

	//1.执行时机:
	//  当Hander处理器已经处理完毕,也就是ModelAndView已经返回给调度中心的时候执行.
	//2.使用场景:
	//  通常在该方法中,对Handler的异常做统一的处理;统一日志记录;检测处理器的执行性能和效率等;
	//3.执行顺序:该方法的执行顺序与注册顺序逆序!
	//4.注意:afterCompletion()执行与否,只有当preHandle()成功的执行完毕,并且该方法返回值是true的时候,afterCompletion()方法才会执行!
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Interceptor02---->afterCompletion()方法执行了...");
	}

}
