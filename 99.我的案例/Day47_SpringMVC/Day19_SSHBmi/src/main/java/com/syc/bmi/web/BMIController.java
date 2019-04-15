package com.syc.bmi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.bmi.domain.BMI;
import com.syc.bmi.service.BMIService;

@Controller
public class BMIController {

	@Autowired
	@Qualifier("bmiService")
	private BMIService service;

	public void setService(BMIService service) {
		this.service = service;
	}

	// 查询
	@RequestMapping("/queryBMI")
	public @ResponseBody List<BMI> queryBMI() {
		List<BMI> bmis = service.queryBMI();
		return bmis;
	}

	// 添加
	@RequestMapping("/addBMI")
	public @ResponseBody BMI addBMI(BMI bmi) {
		
		System.out.println("bmi="+bmi.getBmiSign()+"k="+bmi.getHeight());
		
		boolean result = service.addBMI(bmi);

		// 当添加成功之后!
		if (result) {
			return bmi;
		}
		return null;
	}

	// 删除
	@RequestMapping("/deleteBMI")
	public @ResponseBody BMI deleteBMI(@RequestBody BMI bmi) {
		boolean result = service.deleteBMI(bmi);
		if (result) {
			System.out.println("删除成功!");
		}
		
		return null;
	}
}
