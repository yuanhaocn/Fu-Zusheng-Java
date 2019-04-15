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

/**
 * 签到管理
 * @类名称:SignController
 * @创建人:一一哥
 * @创建时间:2018年3月7日 上午9:06:28
 */
@Controller
public class SignController {
	
	@Autowired
	private SignService signService;

	@RequestMapping("/sign/selectSign")
	public String showSign(){
		return "sign/sign";
	}
	
	@RequestMapping("/sign/showChart")
	public String showSignCharts(){
		return "sign/signCharts";
	}
	
	/**
	 * 判断当天是否已打卡
	 */
	@ResponseBody
	@RequestMapping("/sign/isSign")
	public Map<String,Object> isSign(Integer uid,String today){
		Map<String,Object> map=new HashMap<>();
		if(signService.isSign(uid, today)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	/**
	 * 查询签到信息
	 */
	@RequestMapping("/sign/signJson")
	@ResponseBody
	public PageBean<TbSign> selectSign(@RequestParam(defaultValue="1970-01-01")String startDate,@RequestParam(defaultValue="2099-12-31")String endDate){
		return signService.selectSign(startDate, endDate);
	}
	
	/**
	 * 签到打卡功能
	 */
	@RequestMapping("/sign/addSign")
	@ResponseBody
	public Map<String,Object> addSign(Integer uid){
		Map<String, Object> map=new HashMap<>();
		if(signService.addSign(uid)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	/**
	 * 生成图表的方法
	 * [{"day":"03-01","num":1},{"day":"03-07","num":2}]
	 */
	@ResponseBody
	@RequestMapping("/sign/chartJson")
	public List<SignChart> selectChart(@RequestParam(defaultValue="1900-01-01")String beginDay){
		return signService.selectChart(beginDay);
	}
	
}
