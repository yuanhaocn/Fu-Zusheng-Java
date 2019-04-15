package com.syc.bmi.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.IBmiService;
import com.syc.bmi.service.impl.BmiServiceImpl;

import net.sf.json.JSONArray;

/**
 * 处理BMI的Servlet
 * 
 * @类名称:BMIServlet
 * @创建人:SYC
 * @创建时间:2017年8月3日 上午11:16:42
 */
public class BMIServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IBmiService<BMI> service = null;

	@Override
	public void init() throws ServletException {
		// 添加BMI
		service = new BmiServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		// JDK1.7之后的新特性
		switch (method) {
		case "addBMI":// 添加
			addBMI(request, response);
			break;
		case "queryBMI":// 查询
			queryBMI(response);
			break;
		case "deleteBMI":// 删除
			deleteBMI(request);
			break;
		}

	}

	//删除功能
	private void deleteBMI(HttpServletRequest request) {
		String bmiSign = request.getParameter("bmiSign");
		BMI bmi=new BMI();
		bmi.setBmiSign(bmiSign);
		boolean result = service.deleteBMI(bmi);
		if(result){
			System.out.println("删除成功!");
		}
	}

	// 进行数据库查询的方法
	private void queryBMI(HttpServletResponse response) {
		try {
			List<BMI> list = service.queryBMI();
			JSONArray array = JSONArray.fromObject(list);
			response.getWriter().print(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 处理数据库的添加
	private void addBMI(HttpServletRequest request, HttpServletResponse response) {
		// 取出json中的信息
		// String recordTime = request.getParameter("recordTime");
		// String height = request.getParameter("height");
		// String weight = request.getParameter("weight");
		// String bmi = request.getParameter("bmi");
		// String bmiSign = request.getParameter("bmiSign");

		try {
			BMI bmi = new BMI();
			BeanUtils.populate(bmi, request.getParameterMap());

			boolean result = service.addBMI(bmi);

			// 当数据添加成功后,给html页面回传结果
			if (result) {
				// 存放最近添加的这一条记录
				List<BMI> bmis = new ArrayList<>();
				bmis.add(bmi);
				JSONArray array = JSONArray.fromObject(bmis);
				response.getWriter().print(array);
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}