package com.syc.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 获取请求参数的值
		String method = request.getParameter("method");
		// null.eqauls();
		// method.equals("upload")
		if ("upload".equals(method)) {
			// 执行上传
			uploadFile(request, response);
		} else if ("download".equals(method)) {
			// 执行下载
			downloadFile(request, response);
		} else if ("showFiles".equals(method)) {
			// 展示文件列表
			showFiles(request, response);
		}
	}

	// 执行下载的方法
	private void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		ServletOutputStream out = null;
		try {
			String realPath = getServletContext().getRealPath("/upload");
			String fileName = request.getParameter("fileName");
			File file = new File(realPath, fileName);

			// 下载时的响应头
			response.setHeader("content-disposition", "attachment;fileName=" + fileName);

			fis = new FileInputStream(file);
			out = response.getOutputStream();
			int len = 0;
			byte[] buffer = new byte[2048];
			while ((len = fis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(fis);
			IOUtil.close(out);
		}

	}

	// 显示待下载的文件列表
	private void showFiles(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> fileNames = new HashMap<>();

			String realPath = getServletContext().getRealPath("/upload");
			File file = new File(realPath);
			if (file.exists()) {
				// 列出该文件下所有的文件名称
				String[] list = file.list();
				if (list != null && list.length > 0) {
					for (int i = 0; i < list.length; i++) {
						String fileName = list[i];
						String name = fileName.substring(fileName.lastIndexOf("#") + 1, fileName.length());
						fileNames.put(fileName, name);
					}
				}
			}
			request.setAttribute("fileNames", fileNames);
			request.getRequestDispatcher("/download.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 执行文件上传的方法
	@SuppressWarnings("unchecked")
	private void uploadFile(HttpServletRequest request, HttpServletResponse response) {

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 基本设置
		upload.setFileSizeMax(20 * 1024 * 1024);
		upload.setSizeMax(60 * 1024 * 1024);
		upload.setHeaderEncoding("UTF-8");

		if (ServletFileUpload.isMultipartContent(request)) {
			// 表单数据
			try {
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					// 进一步判断是文件还是普通的表单数据
					if (item.isFormField()) {
						// 普通表单
						String fieldName = item.getFieldName();
						String content = item.toString();
						System.out.println("Field=" + fieldName + "--Content=" + content);
					} else {
						// 文件

						// 返回upload的绝对路径
						String realPath = getServletContext().getRealPath("/upload");

						// 文件名称
						String fileName = item.getName();

						String id = UUID.randomUUID().toString();

						fileName = id + "#" + fileName;

						File file = new File(realPath, fileName);

						item.write(file);
						// 删除临时文件
						item.delete();

						response.getWriter().write("<h1>上传完毕!</h1>");
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("非表单数据!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}