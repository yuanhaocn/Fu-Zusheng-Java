package com.syc.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbSign;
import com.syc.oa.service.SignService;
import com.syc.oa.vo.PageBean;
import com.syc.oa.vo.SignChart;

@Controller
public class SignController {

	@Autowired
	private SignService signService;

	// 跳转到签到查询页面
	@RequestMapping("/sign/selectSign")
	public String toSign() {
		return "sign/sign";
	}

	// 跳转到签到图表页面
	@RequestMapping("/sign/showChart")
	public String signCharts() {
		return "sign/signCharts";
	}

	// 验证今天是否已打卡
	@ResponseBody
	@RequestMapping("/sign/isSign")
	public Map<String, Object> isSign(Integer uid, String today) {

		Map<String, Object> map = new HashMap<>();
		if (signService.isSign(uid, today)) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	// 查询签到信息
	@ResponseBody
	@RequestMapping("/sign/signJson")
	public PageBean<TbSign> selectSign(@RequestParam(defaultValue = "1900-01-01") String startDate,
			@RequestParam(defaultValue = "2099-12-31") String endDate) {
		return signService.selectSign(startDate, endDate);
	}

	// 添加打卡信息
	@ResponseBody
	@RequestMapping("/sign/addSign")
	public Map<String, Object> addSign(Integer uid) {
		Map<String, Object> map = new HashMap<>();
		if (signService.addSign(uid)) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	// 查询签到图表数据
	@ResponseBody
	@RequestMapping("/sign/chartsJson")
	public List<SignChart> selectChartData(@RequestParam(defaultValue = "1900-01-01") String beginDay) {
		return signService.selectChartData(beginDay);
	}

}
