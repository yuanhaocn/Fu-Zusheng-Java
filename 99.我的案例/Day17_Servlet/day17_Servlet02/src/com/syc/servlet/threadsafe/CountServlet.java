package com.syc.servlet.threadsafe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统计网页的访问次数
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Servlet存在线程安全问题.---->因为每一次对Servlet的请求就相当于是开了一个线程.
	// 那么此时就可能有N多个线程,当遇见同一个资源的时候,就可能存在资源争抢的问题.
	// 要解决该问题,就要给该资源加锁.
	// 但是需要注意加锁的位置和时机!
	// 如果没有注意加锁的位置和时机,可能会造成并发访问时网络的延迟,堵塞.
	// 尽量缩小锁的范围,哪个地方用到了该资源哪个地方才去同步(锁).

	// 注意:在Servlet中,尽量不要设置成员变量!如果非得设置,就要考虑同步的问题!
	// 统计访问次数
	private int count = 0;

	// service()每执行一次,就相当于是开了一个线程.
	// 也就相当于doGet()每执行一次,就开了一个线程.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 锁上某个资源.
		// synchronized (CountServlet.class) {
		try {
			Thread.sleep(100);
			synchronized (CountServlet.class) {
				count++;
			}
			// 在页面输出访问次数
			response.getWriter().write("Count=" + count);
			System.out.println("count=" + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
