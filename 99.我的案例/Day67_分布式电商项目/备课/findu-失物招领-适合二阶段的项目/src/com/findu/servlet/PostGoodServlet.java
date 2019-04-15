package com.findu.servlet;

import com.findu.dao.GoodsDAO;
import com.findu.dao.TypeDAO;
import com.findu.entity.Good;
import com.findu.entity.Type;
import com.findu.entity.User;
import com.findu.service.GoodService;
import com.findu.utils.Judge;
import com.findu.utils.UUIDUtils;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostGoodServlet extends HttpServlet {
	
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

		su.setMaxFileSize(5242880);
		su.setTotalMaxFileSize(5242880);
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
			request.setAttribute("postMsg", "�ϴ�ʧ��!");
			flag = 1;
			if (e.getMessage().indexOf("1015") != -1)
				request.setAttribute("postMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ����Ͳ���ȷ!");
			else if (e.getMessage().indexOf("1010") != -1)
				request.setAttribute("postMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ����Ͳ���ȷ!");
			else if (e.getMessage().indexOf("1115") != -1)
				request.setAttribute("postMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ���С���������ϴ���С!");
			else if (e.getMessage().indexOf("1110") != -1) {
				request.setAttribute("postMsg", "�ϴ�ʧ�ܣ��ϴ�ͼƬ�ļ���С���������ϴ��ܴ�С!");
			}
		}

		String goodname = su.getRequest().getParameter("GoodName");
		String explain = su.getRequest().getParameter("Explain");
		String getsite = su.getRequest().getParameter("GetSite");
		String contact = su.getRequest().getParameter("Contact");
		String goodtime = su.getRequest().getParameter("act_start_time");
		String value = su.getRequest().getParameter("Value");
		String picture = picName;
		int goodvalue = 0;

		String typename = su.getRequest().getParameter("Option");
		TypeDAO td = new TypeDAO();
		Type t = TypeDAO.findTypeByName(typename);
		if (t == null) {
			request.setAttribute("postMsg", "���ݿ�δ�ҵ�����Ʒ���ͣ�����ϵ����Ա!");
			flag = 1;
		}
		int type = t.getTypeid();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int fabuid = user.getId();

		if ((goodtime == null) || ("".equals(goodtime))) {
			request.setAttribute("postMsg", "����δѡ��ʰȡʱ��!");
			flag = 1;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date du = null;
		int timeflag = 0;
		try {
			du = df.parse(goodtime);
		} catch (Exception e1) {
			timeflag = 1;
		}
		Timestamp st = null;
		if (timeflag != 1) {
			st = new Timestamp(du.getTime());
		}

		if (Judge.isValue(value).booleanValue()) {
			goodvalue = Integer.parseInt(value);
			if ((goodvalue < 0) || (goodvalue > 9999)) {
				request.setAttribute("postMsg", "��Ʒ��������������0~9999!");
				flag = 1;
			}
		} else {
			request.setAttribute("postMsg", "��Ʒ��������������0~9999!");
			flag = 1;
		}

		Good good = new Good(goodname, getsite, explain, type, fabuid, contact,
				st, goodvalue, picture);

		Good goodsave = new Good(goodname, getsite, explain, type, fabuid,
				contact, goodtime, goodvalue, picture);
		request.setAttribute("formbean", goodsave);

		if (flag != 1) {
			GoodService service = new GoodService();
			try {
				service.postGood(good);
			} catch (Exception e) {
				request.setAttribute("postMsg", "����ʧ��!");
				request.getRequestDispatcher("/html/post-ad.jsp").forward(
						request, response);
				return;
			}

			GoodsDAO goodDAO = new GoodsDAO();
			Good g = goodDAO.getGoodByDetails(fabuid, goodname, getsite);

			response.sendRedirect("/FindU/html/single.jsp?id=" + g.getId());
			return;
		}

		request.getRequestDispatcher("/html/post-ad.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}