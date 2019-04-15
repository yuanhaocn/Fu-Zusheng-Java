package com.syc.oa.controller;

import java.text.ParseException;
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

/**
 * 签到管理模块
 */
@Controller
public class SignController {

	@Autowired
	private SignService signService;

	/**
	 * 跳转到签到查询界面
	 */
	@RequestMapping("/sign/selectSign")
	public String showSign() {
		return "sign/sign";
	}

	/**
	 * 判断是否已签到打卡
	 */
	@ResponseBody
	@RequestMapping("/sign/isSign")
	public Map<String, Object> isSign(Integer uid, String today) {
		Map<String, Object> map = new HashMap<>(16);
		if (signService.isSign(uid, today)) {
			map.put("code", 1);
		} else {
			map.put("code", 2);
		}
		return map;
	}

	/**
	 * 查询签到打卡信息
	 */
	@ResponseBody
	@RequestMapping("/sign/signJson")
	public PageBean<TbSign> findSign(@RequestParam(defaultValue = "1900-01-01") String startDate,
			@RequestParam(defaultValue = "2099-12-31") String endDate) {
		try {
			Map<String, Object> map = new HashMap<>(16);
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			return signService.findSign(map);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加签到打卡记录
	 */
	@ResponseBody
	@RequestMapping("/sign/addSign")
	public Map<String, Object> addSign(Integer uid) {
		Map<String, Object> map = new HashMap<>(16);
		if (signService.addSign(uid)) {
			map.put("code", 1);
		} else {
			map.put("code", 2);
		}
		return map;
	}

	/**
	 * 跳转到签到图表界面
	 */
	@RequestMapping("/sign/showChart")
	public String showChart() {
		return "sign/signCharts";
	}

	/**
	 * 查询签到图表信息
	 */
	@ResponseBody
	@RequestMapping("/sign/chartJson")
	public List<SignChart> findSignChart(@RequestParam(defaultValue = "1900-01-01") String beginDay) {
		return signService.findSignChart(beginDay);
	}
}
