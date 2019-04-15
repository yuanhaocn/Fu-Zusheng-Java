package com.syc.http.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现下载某个资源的响应头.
 * 
 * @类名称:ResponseDemo2Servlet
 * @创建人:SYC
 * @创建时间:2017年7月21日 下午3:27:36
 */
public class ResponseDemo2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		File file = new File("//psf/Home/Desktop/boluo.jpg");
		// Content-Disposition=attachment;filename=文件路径+文件名;
		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

		// ServletOutputStream outputStream = response.getOutputStream();
		FileInputStream is = new FileInputStream(file);
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = is.read(buffer)) != -1) {
			//response.getOutputStream():输出被下载的资源.
			response.getOutputStream().write(buffer, 0, len);
			//response.getWriter().write(buf);
		}
		is.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}