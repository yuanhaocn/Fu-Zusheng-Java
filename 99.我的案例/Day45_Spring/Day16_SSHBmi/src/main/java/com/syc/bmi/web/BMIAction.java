package com.syc.bmi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.BMIService;

public class BMIAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BMIService service;

	public void setService(BMIService service) {
		this.service = service;
	}

	// 查询
	public void queryBMI() {
		try {
			List<BMI> bmis = service.queryBMI();

			// 如何将Java中的Object传递给前端的html/jsp页面?----JSON!
			Object json = JSON.toJSON(bmis);
			System.out.println("json=" + json);

			// print()方法将json字符串输出给了AJAX的success函数!
			PrintWriter writer = ServletActionContext.getResponse().getWriter();
			writer.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 添加
	public void addBMI() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();

			BMI bmi = new BMI();
			// 将request中的map自动封装到bmi对象中!
			BeanUtils.populate(bmi, request.getParameterMap());

			boolean result = service.addBMI(bmi);

			// 当添加成功之后!
			if (result) {
				List<BMI> bmis = new ArrayList<BMI>();
				bmis.add(bmi);
				// 将新添加成功的对象重新输出!
				Object json = JSON.toJSON(bmis);
				response.getWriter().print(json);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 删除
	@SuppressWarnings("unchecked")
	public void deleteBMI() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Map<String, Object> map = request.getParameterMap();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				// key是前端传入的json字符串
				String key = entry.getKey();
				System.out.println("key=" + key);
				BMI bmi = JSON.parseObject(key, BMI.class);
				boolean result = service.deleteBMI(bmi);
				if (result) {
					PrintWriter writer = ServletActionContext.getResponse().getWriter();
					//writer.print("删除成功!");
					//注意:此处需要将字符串转为JSON格式!
					writer.print(JSON.toJSONString("删除成功!"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
