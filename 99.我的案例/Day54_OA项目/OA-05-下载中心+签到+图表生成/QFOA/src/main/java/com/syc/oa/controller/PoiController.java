package com.syc.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syc.oa.service.PoiService;

/**
 * 报表管理模块. 其实就是查询tb_user表
 */
@Controller
public class PoiController {

	@Autowired
	private PoiService poiService;

	@RequestMapping("/poi/createPoi")
	public String showCreatePoi() {
		return "poi/poi";
	}

	/**
	 * 导出为excel
	 */
	@RequestMapping("/poi/createExcel")
	public String createExcel(@RequestParam(defaultValue = "") String username) {
		// 生成excle文件名
		String fileName = poiService.generateExcel(username);
		// System.out.println("filename="+fileName);
		if (fileName != null) {
			return "redirect:/doc/downloadDocument?fileName=" + fileName;
		} else {
			return null;
		}
	}
}
