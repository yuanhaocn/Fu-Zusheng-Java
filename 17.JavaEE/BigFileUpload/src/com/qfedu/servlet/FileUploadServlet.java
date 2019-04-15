package com.qfedu.servlet;

/**
 * 大文件上传，纯手敲
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.FieldNameHelper;

import com.qfedu.util.UUIDUtil;

@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//###################################################################################################
//###################################################################################################
		// 1.确定文件上传的位置
		String filePath = getServletContext().getRealPath("/file");
		// 2.判断文件夹是否存在，如果不存在需要创建
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 3.构建缓存文件路径
		String tempPath = getServletContext().getRealPath("/temp");
		// 4.根据路径构建文件对象，如果文件夹不存在，代码创建
		File tempFile = new File(tempPath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		// 5.构建DiskFileItemFactroy对象
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 6.设置上传文件缓冲区大小的一个方法,单位是b,如果上传的文件小于10M，是不会开启缓冲区的
		diskFileItemFactory.setSizeThreshold(1024 * 1024 * 10);
		// 7.指定缓冲区文件夹
		diskFileItemFactory.setRepository(tempFile);
//###################################################################################################
//###################################################################################################
		// 8.构建ServletFileUpload对象
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		// 9.文件上传乱码问题
		servletFileUpload.setHeaderEncoding("utf-8");
		// 10.处理请求，判断request对象是不是io格式
		if (ServletFileUpload.isMultipartContent(req)) {
			// 11.约束上传的单个文件大小,单位是b
			servletFileUpload.setFileSizeMax(1024 * 1024 * 200);
			// 12.设置文件存储区文件总大小
			servletFileUpload.setSizeMax(1024 * 1024 * 1024);
			try {
				// 13.格式化请求，把请求进行分类处理
				List<FileItem> fileItems = servletFileUpload.parseRequest(req);
				// 14.迭代器操作
				Iterator<FileItem> iterator = fileItems.iterator();
				while (iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					// 15.判断是否是简单组件
					if (fileItem.isFormField()) {
						// 16.获取该组件的名字和值
						String fieldName = fileItem.getFieldName();
						String fieldValue = fileItem.getString("utf-8");
						System.out.println(fieldName + "    " + fieldValue);
						req.getSession().setAttribute("fieldName", fieldValue);

					} else {
						/*
						 * 17.获取文件名 不同浏览器处理不一样，比如谷歌上传上来 xxx.avi opera的早期版本是 c:/user/xxx.avi
						 */
						String name = fileItem.getName();  
						// 18.切割文件名和后缀名出来
						String fileName = name.substring(name.lastIndexOf("\\") + 1, name.lastIndexOf("."));
						String fileExtName = name.substring(name.lastIndexOf(".") + 1);
						// 19.进行uuid的组装生成文件存储路径
						String finalFilePath = filePath + "\\" + fileName + UUIDUtil.getUUID() + "." + fileExtName;
						// 20.获取文件输出流
						FileOutputStream fos = new FileOutputStream(new File(finalFilePath));
						// 21.构建数组和行数变量
						byte[] bytes = new byte[1024];
						int count = 0;
						// 22.获取输入流
						InputStream is = fileItem.getInputStream();
						// 23.文件复制
						while ((count = is.read(bytes)) != -1) {
							fos.write(bytes, 0, count);
						}
						// 24.刷新缓冲区
						fos.flush();
						// 25.关闭资源
						fos.close();
						is.close();
						// 26.打印文件路径
						System.out.println(finalFilePath);
						req.getSession().setAttribute("finalFilePath", finalFilePath);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher("/show.jsp").forward(req, resp);
	}
}
