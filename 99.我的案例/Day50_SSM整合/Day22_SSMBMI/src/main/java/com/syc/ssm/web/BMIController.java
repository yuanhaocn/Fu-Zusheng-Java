package com.syc.ssm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.ssm.domain.Bmi;
import com.syc.ssm.service.BMIService;

@Controller
public class BMIController {

	@Autowired
	@Qualifier("bmiService")
	private BMIService service;

	// 查询
	@RequestMapping("/queryBMI")
	public @ResponseBody List<Bmi> queryBMI() {
		return service.queryBMI();
	}

	// 添加
	@RequestMapping("/addBMI")
	public @ResponseBody Bmi addBMI(Bmi bmi) {

		System.out.println("bmiSign=" + bmi.getBmisign() + ",height=" + bmi.getHeight());

		int result = service.addBMI(bmi);

		// 当添加成功之后!
		if (result > 0) {
			return bmi;
		}
		return null;
	}

	// 删除
	@RequestMapping("/deleteBMI")
	public @ResponseBody Bmi deleteBMI(@RequestBody Bmi bmi) {
		int result = service.deleteBMI(bmi);
		if (result > 0) {
			System.out.println("删除成功!");
		}

		return null;
	}
}
