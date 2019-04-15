package com.qfedu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.UserExt;
import com.qfedu.serviceImp.UserManagerServiceImp;

@WebServlet("/updatePass")
public class UpdatePass extends HttpServlet{
 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String mpass = req.getParameter("mpass");
		 String newpass = req.getParameter("newpass");
		 String renewpass = req.getParameter("renewpass");
		 UserManagerServiceImp umsi = new UserManagerServiceImp();
		 System.out.println("旧密码是："+mpass+"新密码是"+newpass+"重复新密码是"+renewpass);
		 if(newpass.equals(renewpass)) {
			 UserExt ue = (UserExt)req.getSession().getAttribute("currentUser");
			 String userName = ue.getUsername();
			 int updatePass = umsi.updatePass(mpass,userName, newpass);
			 if(updatePass>0) {
				 System.out.println("修改成功");
			 }else {
				 System.out.println("修改失败");
			 }
		 }
		 
	}
	

}
