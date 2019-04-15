package com.syc.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 处理文件上传的Servlet
 * 
 * @类名称:UploadServlet
 * @创建人:SYC
 * @创建时间:2017年7月26日 下午3:25:03
 */
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取request请求中的数据内容:
		// 1.request.getParameter();---get/post
		// 2.request.getParameterMaps();---get/post
		// 3.request.getQueryString();---get
		// 4.request.getParameterNames();---post/get
		// 5.request.getInputStream();---post

		FileItemFactory factory = new DiskFileItemFactory();
		// 实现文件上传的类
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 在处理文件上传之前,做一些基本的设置
		// 设置单个文件的最大尺寸,20M
		upload.setFileSizeMax(20 * 1024 * 1024);
		// 上传的文件总的尺寸,60M
		upload.setSizeMax(60 * 1024 * 1024);
		// 设置上传文件的编码
		upload.setHeaderEncoding("UTF-8");
		// 设置文件上传进度的监听器
		upload.setProgressListener(new ProgressListener() {
			// 更新进度的方法
			@Override
			public void update(long progress, long size, int state) {
				System.out.println(progress + "--" + size + "--" + state);
			}
		});

		// 对上传的数据做判断:文件/表单数据
		if (ServletFileUpload.isMultipartContent(request)) {
			// 属于表单数据
			try {
				// 表单中上传上来的所有的数据
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {
						// 是表单元素--->是普通的表单数据
						// 获取表单中name属性的值
						String fieldName = item.getFieldName();
						// 表单数据内容
						String content = item.toString();
						System.out.println("FileName=" + fieldName + ",content=" + content);
					} else {
						// 文件....
						// 获取表单中name属性的值
						String fieldName = item.getFieldName();
						// 获取文件名
						String name = item.getName();
						// 文件类型
						String contentType = item.getContentType();
						// 文件内容
						// String content = item.toString();
						// 音频视频等多媒体文件流
						// item.getInputStream();
						// 获取文件大小
						long size = item.getSize();

						System.out.println("fieldName=" + fieldName + ",contentType=" + contentType + ",size=" + size);

						// 文件上传的本质:把客户端的某个文件--->服务器的某个路径下;

						String path = getServletContext().getRealPath("/upload");
						// 随机生成的一个序号
						String id = UUID.randomUUID().toString();
						String fileName = id + "#" + name;
						File file = new File(path, fileName);
						// if(!file.exists()){
						// file.mkdirs();
						// }
						// 将上传的文件写到服务器的某个路径下.
						item.write(file);
						// 删除产生的临时文件
						item.delete();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 非表单数据
			System.out.println("上传的不是文件!");
		}

	}

}