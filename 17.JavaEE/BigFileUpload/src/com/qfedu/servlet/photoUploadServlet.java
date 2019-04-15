package com.qfedu.servlet;

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

@WebServlet("/photoUploadServlet")
public class photoUploadServlet extends HttpServlet {

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filePath = getServletContext().getRealPath("/file");
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
					}else {
						String name = fileItem.getName();
						String fileName = name.substring(name.lastIndexOf("\\")+1, name.lastIndexOf("."));
						String uuidValue=UUIDUtil.getUUID();
						String fileExtName = name.substring(name.lastIndexOf(".")+1);
						String finalFilePath = filePath+"\\"+fileName+uuidValue+"."+fileExtName;
						FileOutputStream fos = new FileOutputStream(new File(finalFilePath));
						//获取服务器路径
						//localhost:8080/BigFileUpload/photoUploadServlet
						String pathInServer="http://localhost:8080/BigFileUpload/file/"+fileName+uuidValue+"."+fileExtName;
						byte[] bytes = new byte[1024];
						int count = 0;
						InputStream is = fileItem.getInputStream();
						while((count = is.read(bytes))!=-1) {
							fos.write(bytes, 0, count);
						}
						fos.flush();
						fos.close();
						is.close();
						System.out.println(finalFilePath);
						//发送图片在服务器上的地址到前段
						req.getSession().setAttribute("pathInServer", pathInServer);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher("/phototUpload.jsp").forward(req, resp);
	}
}





