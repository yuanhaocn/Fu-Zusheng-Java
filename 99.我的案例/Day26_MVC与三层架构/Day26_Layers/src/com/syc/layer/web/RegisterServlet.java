package com.syc.layer.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.syc.layer.domain.User;
import com.syc.layer.domain.UserForm;
import com.syc.layer.service.ILoginService;
import com.syc.layer.service.impl.LoginServiceImpl;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 在注册完成之前,要验证表单数据格式.(可以在js中完成;也可以在Web中完成)

		try {
			UserForm form = new UserForm();
			BeanUtils.populate(form, request.getParameterMap());
			//当表单数据格式有问题时,就调到/register.jsp页面.
			if (!form.checkForm()) {// 判断表单数据集合是否为空.
				request.setAttribute("form", form);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}

		// web层调用service层
		ILoginService service = new LoginServiceImpl();

		User user = new User();

		// 默认的转换方式
		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// 实现注册
		service.register(user);

		// 3秒后返回到登陆页面
		PrintWriter writer = response.getWriter();
		writer.write("注册成功,3秒后返回到登陆页面");
		response.setHeader("refresh", "3;url=" + request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}