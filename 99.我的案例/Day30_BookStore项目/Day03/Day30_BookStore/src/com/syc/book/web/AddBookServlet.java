package com.syc.book.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.syc.book.domain.Book;
import com.syc.book.service.IBookService;
import com.syc.book.service.impl.BookServiceImpl;

/**
 * 图书的添加操作
 * 
 * @类名称:AddBookServlet
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午10:41:03
 */
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Map<String, String[]> map = null;

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			// 得到一个ServletRequestContext
			ServletRequestContext context = new ServletRequestContext(request);
			List<FileItem> items = upload.parseRequest(context);

			if (items != null) {
				map = new HashMap<>();
				for (FileItem item : items) {
					if (item.isFormField()) {
						// 普通表单数据
						String name = item.getFieldName();
						String value = item.getString("UTF-8");
						map.put(name, new String[] { value });
					} else {
						// 上传的文件
						// 得到文件名或者要上传的文件的路径:c://destop/book.jpg
						String fileName = item.getName();
						// 获取文件扩展名,比如.exe,.jpg
						String extension = FilenameUtils.getExtension(fileName);
						if (!".exe".equals(extension)) {
							String uploadDir = getServletContext().getRealPath("/upload");
							File uploadFile = new File(uploadDir);
							if (!uploadFile.exists()) {
								uploadFile.mkdirs();
							}

							if (fileName != null) {
								// 获取文件路径中的文件名名称部分
								fileName = FilenameUtils.getName(fileName);
								String childDirectory = getChildDirectory(uploadFile, fileName);

								// 形成格式:1/5/henggang.jpg
								fileName = childDirectory + File.separator + fileName;
								System.out.println("格式:" + fileName);

								// 实现文件的上传
								item.write(new File(uploadFile, fileName));

								map.put(item.getFieldName(), new String[] { fileName });
							}
						}
					}
				}
			}

			// 封装图书对象
			Book book = new Book();
			book.setId(UUID.randomUUID().toString());
			BeanUtils.populate(book, map);

			// 实现图书的添加
			IBookService service = new BookServiceImpl();
			service.addBook(book);

			// 跳转到bookList页面
			request.getRequestDispatcher("/bookListServlet").forward(request, response);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	// 定义存储到数据库中img_url字段的文件名称规则
	private String getChildDirectory(File uploadFile, String fileName) {
		// 将文件名称的hashcode转为16进制
		int hashCode = fileName.hashCode();
		String code = Integer.toHexString(hashCode);
		String childDirectory = code.charAt(0) + File.separator + code.charAt(1);
		File file = new File(uploadFile, childDirectory);
		if (!file.exists()) {
			file.mkdirs();
		}
		return childDirectory;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}