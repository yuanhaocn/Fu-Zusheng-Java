package com.syc.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syc.oa.service.PoiService;

/*
 * 报表管理模块
 */
@Controller
public class PoiController {
	
	@Autowired
	private PoiService service;

	@RequestMapping("/poi/createPoi")
	public String showPoi() {
		return "poi/poi";
	}

	// 生成Excel文件
	@RequestMapping("/poi/createExcel")
	public String createExcel(@RequestParam(defaultValue = "") String username) {
		
		String fileName = service.createExcel(username);
		
		//进行文件的下载
		if(fileName!=null){
			return "redirect:/doc/downloadDocument?fileName="+fileName;
		}
		return null;
	}
	
}
