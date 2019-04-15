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
		//1.����ǰ�˵�����
		String fileName = req.getParameter("fileName");
		//2.�����ļ�·��
		String path = getServletContext().getRealPath("/fileDownload");
		//3.�����ļ���MIME����
		resp.setContentType(getServletContext().getMimeType(fileName));
		//4.�������������ͼƬ������
		resp.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		//5.����io��������
		FileInputStream fis = new FileInputStream(path+"/"+fileName);
		byte[] bytes= new byte[1024];
		int count = 0;
		//6.�ļ������ʹ��response����
		ServletOutputStream os = resp.getOutputStream();
		while((count = fis.read(bytes))!=-1) {
			os.write(bytes, 0, count);
		}
		//7.ˢ��
		os.flush();
		//8.�ر���
		os.close();
		fis.close();
	}
	

}
