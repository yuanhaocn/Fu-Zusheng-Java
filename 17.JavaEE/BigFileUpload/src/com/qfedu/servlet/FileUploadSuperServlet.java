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
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qfedu.util.UUIDUtil;

@WebServlet("/fileUploadSuperServlet")
public class FileUploadSuperServlet extends HttpServlet {

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.确定文件上传的位置
		String filePath = getServletContext().getRealPath("/file");
		//2.判断文件夹是否存在，如果不存在需要创建
		File targetFile = new File(filePath);
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		String tempPath = getServletContext().getRealPath("/temp");
		File tempFile = new File(tempPath);
		if(!tempFile.exists()) {
			tempFile.mkdirs();
		}
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(1024*1024*10);
		diskFileItemFactory.setRepository(tempFile);
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		
//###################################################################################################		
//###################################################################################################	
		//设置监听文件上传进度,需要使用ProgressListener多为参数设置进去
		servletFileUpload.setProgressListener(new ProgressListener() {
			/*
			 * 第一个参数是当前已经上传文件大小
			 * 第二个参数是当前等待上传文件总大小
			 */
			@Override
			public void update(long arg0, long arg1, int arg2) {
				System.out.println("当前已经接收"+arg0/1024/1024+"M,文件总大小是"+arg1/1024/1024+"M");
				
			}
		});
//###################################################################################################		
//###################################################################################################	
		
		
		
		servletFileUpload.setHeaderEncoding("utf-8");
		if(ServletFileUpload.isMultipartContent(req)) {
			servletFileUpload.setFileSizeMax(1024*1024*200);
			servletFileUpload.setSizeMax(1024*1024*1024);
			try {
				List<FileItem> fileItems = servletFileUpload.parseRequest(req);
				Iterator<FileItem> iterator = fileItems.iterator();
				while(iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					if(fileItem.isFormField()) {
						String fieldName = fileItem.getFieldName();
						String fieldValue = fileItem.getString("utf-8");
						System.out.println(fieldName+"    "+fieldValue);
						req.getSession().setAttribute("fieldName", fieldValue);

					}else {
						/*
						 * 17.获取文件名
						 * 	不同浏览器处理不一样，比如谷歌上传上来  xxx.avi
						 * 		opera的早期版本是    c:/user/xxx.avi
						 */
						String name = fileItem.getName();
						//18.切割文件名和后缀名出来
						String fileName = name.substring(name.lastIndexOf("\\")+1, name.lastIndexOf("."));
						String fileExtName = name.substring(name.lastIndexOf(".")+1);
						//19.进行uuid的组装生成文件存储路径
						String finalFilePath = filePath+"\\"+fileName+UUIDUtil.getUUID()+"."+fileExtName;
						//20.获取文件输出流
						FileOutputStream fos = new FileOutputStream(new File(finalFilePath));
						//21.构建数组和行数变量
						byte[] bytes = new byte[1024];
						int count = 0;
						//22.获取输入流
						InputStream is = fileItem.getInputStream();
						//23.文件复制
						while((count = is.read(bytes))!=-1) {
							fos.write(bytes, 0, count);
						}
						//24.刷新缓冲区
						fos.flush();
						//25.关闭资源
						fos.close();
						is.close();
						//26.打印文件路径
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





