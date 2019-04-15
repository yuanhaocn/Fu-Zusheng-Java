package com.findu.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findu.entity.Apply;
import com.findu.entity.User;
import com.findu.service.ApplyService;
import com.findu.service.GoodService;
import com.findu.utils.Judge;
import com.findu.utils.UUIDUtils;
import com.jspsmart.upload.SmartUpload;

public class ChangeApplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("utf-8");
	    
	    GoodService gservice=new GoodService();
	    ApplyService aservice=new ApplyService();
	    
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
	    try
	    {
	      su.upload();

	      String ext = su.getFiles().getFile(0).getFileExt();

	      if ((ext != null) || (!"".equals(ext))) {
	        picName = uuid + "." + ext;
	        su.getFiles().getFile(0).saveAs(getServletContext().getRealPath("/") + "images\\" + picName);
	      }
	    }
	    catch (Exception e) {
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
	    int applyid =Integer.parseInt(su.getRequest().getParameter("applyID"));

	    HttpSession session = request.getSession();
	    User user = (User)session.getAttribute("user");
	    int userid = user.getId();

	    int goodid = 0;
	    if (("".equals(gid)) || (gid == null)) {
	      System.out.println("��ȡ��������ƷIDʧ��!");
	      return;
	    }
	    goodid = Integer.parseInt(gid);
	    
	    String picture = "";
	    
	    if(Judge.hasPic(picName)){
	    	picture = picName;
		}else{
			try {
				picture=aservice.getApplyById(applyid).getPicture();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	    Apply apply = new Apply(explain, contact, picture);
	    apply.setId(applyid);
	    ApplyService service = new ApplyService();

	    if (flag != 1) {
	      try {
	        service.updateApply(apply);
	      } catch (Exception e) {
	        request.setAttribute("applyMsg", "�޸�ʧ�ܣ������ظ�����!");
	        request.getRequestDispatcher("/html/message.jsp?id=" + goodid).forward(request, response);
	        return;
	      }

	      request.setAttribute("applyMsg", "���±༭�ύ�ɹ�!");
	      request.getRequestDispatcher("/html/message.jsp?id=" + goodid).forward(request, response);
	      return;
	    }

	    request.getRequestDispatcher("/html/apply.jsp?id=" + goodid).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
