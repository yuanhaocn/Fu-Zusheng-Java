package com.syc.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syc.oa.service.PoiService;

/**
 * 报表管理模块
 * 
 * @类名称:PoiController
 * @创建人:一一哥
 * @创建时间:2018年3月6日 上午11:19:18
 */
@Controller
public class PoiController {
	
	@Autowired
	private PoiService poiService;

	@RequestMapping("/poi/createPoi")
	public String showPoiCreate() {

		return "poi/poi";
	}

	/**
	 * 用来生成Excel
	 */
	@RequestMapping("/poi/createExcel")
	public String createPoi(@RequestParam(defaultValue = "") String username) {
		
		String fileName = poiService.createExcel(username);
		
		if(fileName!=null){
			return "redirect:/doc/downloadDocument?fileName="+fileName;
		}
		
		return null;
	}

}
