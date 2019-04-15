package servlet;


import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {

	@SuppressWarnings("resource")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接收前端的数据
		String fileName = req.getParameter("fileName");
		//2.构建文件路径
		String path = getServletContext().getRealPath("/fileDownload");
		//3.设置文件的MIME类型
		resp.setContentType(getServletContext().getMimeType(fileName));
		//4.屏蔽浏览器解析图片的能力
		resp.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		//5.开启io操作即可
		FileInputStream fis = new FileInputStream(path+"/"+fileName);
		byte[] bytes= new byte[1024];
		int count = 0;
		//6.文件的输出使用response即可
		ServletOutputStream os = resp.getOutputStream();
		while((count = fis.read(bytes))!=-1) {
			os.write(bytes, 0, count);
		}
		//7.刷新
		os.flush();
		//8.关闭流
		os.close();
		fis.close();
	}
	

}
