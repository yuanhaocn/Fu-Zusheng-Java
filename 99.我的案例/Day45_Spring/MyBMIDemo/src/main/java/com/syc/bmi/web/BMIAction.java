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
import com.syc.bmi.service.IBmiService;

/**
 * 处理BMI的Action
 * 
 * @创建人:SYC
 */
public class BMIAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IBmiService<BMI> service;

	public void setService(IBmiService<BMI> service) {
		this.service = service;
	}

	// 进行数据库查询的方法
	public void queryBMI() {
		try {
			List<BMI> list = service.queryBMI();
			Object json = JSON.toJSON(list);
			// System.out.println("json=" + json);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 处理数据库的添加
	public void addBMI() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();

			BMI bmi = new BMI();
			BeanUtils.populate(bmi, request.getParameterMap());
			boolean result = service.addBMI(bmi);

			// 当数据添加成功后,给html页面回传结果
			if (result) {
				// 存放最近添加的这一条记录
				List<BMI> bmis = new ArrayList<BMI>();
				bmis.add(bmi);
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

	// 删除功能
	@SuppressWarnings("unchecked")
	public void deleteBMI() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Map<String, Object> map = request.getParameterMap();
			// 取出传入的信息
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				// 将json字符串转为对应的对象
				BMI bmi = JSON.parseObject(key, BMI.class);
				boolean result = service.deleteBMI(bmi);
				if (result) {
					PrintWriter writer = ServletActionContext.getResponse().getWriter();
					writer.print(JSON.toJSONString("删除成功"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}