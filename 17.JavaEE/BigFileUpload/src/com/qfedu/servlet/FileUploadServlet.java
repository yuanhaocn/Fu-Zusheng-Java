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
		// 1.ȷ���ļ��ϴ���λ��
		String filePath = getServletContext().getRealPath("/file");
		// 2.�ж��ļ����Ƿ���ڣ������������Ҫ����
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 3.���������ļ�·��
		String tempPath = getServletContext().getRealPath("/temp");
		// 4.����·�������ļ���������ļ��в����ڣ����봴��
		File tempFile = new File(tempPath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		// 5.����DiskFileItemFactroy����
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 6.�����ϴ��ļ���������С��һ������,��λ��b,����ϴ����ļ�С��10M���ǲ��Ὺ����������
		diskFileItemFactory.setSizeThreshold(1024 * 1024 * 10);
		// 7.ָ���������ļ���
		diskFileItemFactory.setRepository(tempFile);
//###################################################################################################
//###################################################################################################
		// 8.����ServletFileUpload����
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		// 9.�ļ��ϴ���������
		servletFileUpload.setHeaderEncoding("utf-8");
		// 10.���������ж�request�����ǲ���io��ʽ
		if (ServletFileUpload.isMultipartContent(req)) {
			// 11.Լ���ϴ��ĵ����ļ���С,��λ��b
			servletFileUpload.setFileSizeMax(1024 * 1024 * 200);
			// 12.�����ļ��洢���ļ��ܴ�С
			servletFileUpload.setSizeMax(1024 * 1024 * 1024);
			try {
				// 13.��ʽ�����󣬰�������з��ദ��
				List<FileItem> fileItems = servletFileUpload.parseRequest(req);
				// 14.����������
				Iterator<FileItem> iterator = fileItems.iterator();
				while (iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					// 15.�ж��Ƿ��Ǽ����
					if (fileItem.isFormField()) {
						// 16.��ȡ����������ֺ�ֵ
						String fieldName = fileItem.getFieldName();
						String fieldValue = fileItem.getString("utf-8");
						System.out.println(fieldName + "    " + fieldValue);
						req.getSession().setAttribute("fieldName", fieldValue);

					} else {
						/*
						 * 17.��ȡ�ļ��� ��ͬ���������һ��������ȸ��ϴ����� xxx.avi opera�����ڰ汾�� c:/user/xxx.avi
						 */
						String name = fileItem.getName();  
						// 18.�и��ļ����ͺ�׺������
						String fileName = name.substring(name.lastIndexOf("\\") + 1, name.lastIndexOf("."));
						String fileExtName = name.substring(name.lastIndexOf(".") + 1);
						// 19.����uuid����װ�����ļ��洢·��
						String finalFilePath = filePath + "\\" + fileName + UUIDUtil.getUUID() + "." + fileExtName;
						// 20.��ȡ�ļ������
						FileOutputStream fos = new FileOutputStream(new File(finalFilePath));
						// 21.�����������������
						byte[] bytes = new byte[1024];
						int count = 0;
						// 22.��ȡ������
						InputStream is = fileItem.getInputStream();
						// 23.�ļ�����
						while ((count = is.read(bytes)) != -1) {
							fos.write(bytes, 0, count);
						}
						// 24.ˢ�»�����
						fos.flush();
						// 25.�ر���Դ
						fos.close();
						is.close();
						// 26.��ӡ�ļ�·��
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
