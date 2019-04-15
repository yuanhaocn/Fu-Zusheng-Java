package com.findu.servlet;

import com.findu.dao.GoodsDAO;
import com.findu.entity.Apply;
import com.findu.entity.Good;
import com.findu.entity.User;
import com.findu.service.ApplyService;
import com.findu.utils.UUIDUtils;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String picName = "";
		String uuid = UUIDUtils.getUUID();

		String filePath = getServletContext().getRealPath("/") + "images";

		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdir();
		}

		SmartUpload su = new SmartUpload();

		su.initialize(getServletConfig(), request, response);

		su.setCharset("utf-8");

		su.setMaxFileSize(5242880L);
		su.setTotalMaxFileSize(5242880L);
		su.setAllowedFilesList("jpg,png,gif,jpeg");

		int flag = 0;
		try {
			su.upload();

			String ext = su.getFiles().getFile(0).getFileExt();

			if ((ext != null) || (!"".equals(ext))) {
				picName = uuid + "." + ext;
				su.getFiles()
						.getFile(0)
						.saveAs(getServletContext().getRealPath("/")
								+ "images\\" + picName);
			}
		} catch (Exception e) {
			request.setAttribute("applyMsg", "�ϴ�ʧ��!");
			flag = 1;
			if (e.getMessage().indexOf("1015") != -1)
				request.setAttribute("applyMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ����Ͳ���ȷ!");
			else if (e.getMessage().indexOf("1010") != -1)
				request.setAttribute("applyMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ����Ͳ���ȷ!");
			else if (e.getMessage().indexOf("1115") != -1)
				request.setAttribute("applyMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ���С���������ϴ���С!");
			else if (e.getMessage().indexOf("1110") != -1) {
				request.setAttribute("applyMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ���С���������ϴ��ܴ�С!");
			}
		}

		String explain = su.getRequest().getParameter("Explain");
		String contact = su.getRequest().getParameter("Contact");
		String gid = su.getRequest().getParameter("ID");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userid = user.getId();

		int goodid = 0;
		if (("".equals(gid)) || (gid == null)) {
			System.out.println("��ȡ��������ƷIDʧ��!");
			return;
		}
		goodid = Integer.parseInt(gid);

		Apply apply = new Apply(explain, goodid, userid, contact, picName);
		ApplyService service = new ApplyService();

		GoodsDAO dao = new GoodsDAO();
		Good g = dao.getGoodById(goodid);
		if (userid == g.getFabuid()) {
			request.setAttribute("applyMsg", "����ʧ�ܣ����������Լ���������Ʒ!");
			request.getRequestDispatcher("/html/message.jsp?id=" + goodid)
					.forward(request, response);
			return;
		}

		if (flag != 1) {
			try {
				service.applyGood(apply);
			} catch (Exception e) {
				request.setAttribute("applyMsg", "����ʧ�ܣ������ظ�����!");
				request.getRequestDispatcher("/html/message.jsp?id=" + goodid)
						.forward(request, response);
				return;
			}

			request.setAttribute("applyMsg", "��ϲ��������ɹ�!");
			request.getRequestDispatcher("/html/message.jsp?id=" + goodid)
					.forward(request, response);
		}

		request.getRequestDispatcher("/html/apply.jsp?id=" + goodid).forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}