package com.qfedu.servlet;
/**
 * ���ļ��ϴ���������
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
		//1.ȷ���ļ��ϴ���λ��
		String filePath = getServletContext().getRealPath("/file");
		//2.�ж��ļ����Ƿ���ڣ������������Ҫ����
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
		//���ü����ļ��ϴ�����,��Ҫʹ��ProgressListener��Ϊ�������ý�ȥ
		servletFileUpload.setProgressListener(new ProgressListener() {
			/*
			 * ��һ�������ǵ�ǰ�Ѿ��ϴ��ļ���С
			 * �ڶ��������ǵ�ǰ�ȴ��ϴ��ļ��ܴ�С
			 */
			@Override
			public void update(long arg0, long arg1, int arg2) {
				System.out.println("��ǰ�Ѿ�����"+arg0/1024/1024+"M,�ļ��ܴ�С��"+arg1/1024/1024+"M");
				
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
						 * 17.��ȡ�ļ���
						 * 	��ͬ���������һ��������ȸ��ϴ�����  xxx.avi
						 * 		opera�����ڰ汾��    c:/user/xxx.avi
						 */
						String name = fileItem.getName();
						//18.�и��ļ����ͺ�׺������
						String fileName = name.substring(name.lastIndexOf("\\")+1, name.lastIndexOf("."));
						String fileExtName = name.substring(name.lastIndexOf(".")+1);
						//19.����uuid����װ�����ļ��洢·��
						String finalFilePath = filePath+"\\"+fileName+UUIDUtil.getUUID()+"."+fileExtName;
						//20.��ȡ�ļ������
						FileOutputStream fos = new FileOutputStream(new File(finalFilePath));
						//21.�����������������
						byte[] bytes = new byte[1024];
						int count = 0;
						//22.��ȡ������
						InputStream is = fileItem.getInputStream();
						//23.�ļ�����
						while((count = is.read(bytes))!=-1) {
							fos.write(bytes, 0, count);
						}
						//24.ˢ�»�����
						fos.flush();
						//25.�ر���Դ
						fos.close();
						is.close();
						//26.��ӡ�ļ�·��
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





