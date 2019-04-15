package com.syc.bookstore.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.service.IBookService;
import com.syc.bookstore.service.impl.BookServiceImpl;

/**
 * 添加图书的Servlet
 * 
 * @类名称:AddBookServlet
 * @创建人:SYC
 * @创建时间:2017年7月17日 下午5:51:38
 */
public class AddBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		try {

			// 创建一个文件条目工厂对象
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置上传文件中的中文乱码问题
			upload.setHeaderEncoding("UTF-8");
			// 将request对象转为ServletRequestContext
			ServletRequestContext context = new ServletRequestContext(request);
			// 将request请求对象解析为集合对象
			List<FileItem> items = upload.parseRequest(context);

			Map<String, String[]> map = null;
			if (items != null) {
				// 创建一个Map,存放表单数据.
				map = new HashMap<>();
				for (FileItem item : items) {
					if (item.isFormField()) {
						// 获取表单数据
						String name = item.getFieldName();
						String value = item.getString("UTF-8");
						System.out.println("Name=" + name + ",Value=" + value);
						map.put(name, new String[] { value });
					} else {
						// 得到文件名或者文件路径
						String fileName = item.getName();
						// 根据文件名称获取文件扩展名
						String extension = FilenameUtils.getExtension(fileName);
						// 如果不是.exe可执行文件....;不能上传.exe可执行文件.
						if (!".exe".equals(extension)) {
							// 创建要上传文件所在的目录:upload
							String uploadDirectory = getServletContext().getRealPath("/upload");
							File uploadFile = new File(uploadDirectory);
							// 如果文件不存在,则创建
							if (!uploadFile.exists()) {
								uploadFile.mkdirs();
							}

							if (fileName != null) {
								// 获取要上传的文件名
								fileName = FilenameUtils.getName(fileName);
								System.out.println("文件名:" + fileName);
							}

							// 得到子目录
							String childDirectory = getChildDirectory(uploadFile, fileName);
							System.out.println("child---Directory=" + childDirectory);
							// 需要存到数据库的图片路径
							fileName = childDirectory + File.separator + fileName;

							item.write(new File(uploadDirectory, fileName));

							// 把图片的路径放到map中
							map.put(item.getFieldName(), new String[] { fileName });
						}
					}
				}
			}

			Book book = new Book();
			// BeanUtils.populate(book, request.getParameterMap());
			BeanUtils.populate(book, map);
			// 设置图书的id.
			book.setId(UUID.randomUUID().toString());

			// 添加图书
			IBookService service = new BookServiceImpl();
			service.addBook(book);

			// 跳转到图书展示界面
			request.getRequestDispatcher("bookListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 获取子目录
	public String getChildDirectory(File directory, String fileName) {
		// 得到fileName的hashCode
		int hashCode = fileName.hashCode();
		// 将HashCode转为16进制
		String code = Integer.toHexString(hashCode);

		// 得到子目录
		String childDirectory = code.charAt(0) + File.separator + code.charAt(1);
		System.out.println("childDirectory=" + childDirectory);

		File file = new File(directory, childDirectory);
		// 创建子目录
		if (!file.exists()) {
			file.mkdirs();
		}

		return childDirectory;
	}

}
