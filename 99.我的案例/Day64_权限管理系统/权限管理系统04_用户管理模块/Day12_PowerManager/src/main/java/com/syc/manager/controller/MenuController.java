package com.syc.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.manager.domain.Menu;
import com.syc.manager.service.MenuService;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.vo.BaseJSON;

/**
 * 权限管理模块
 * 
 * @类名称:MenuController
 * @创建人:一一哥
 * @创建时间:2018年3月16日 上午9:57:13
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping(value = "/sys/menu/getAllMenuForTree", produces = { "text/plain;charset=UTF-8" })
	public String getAllMenuForTree() {
		List<Menu> menus=menuService.getAllMenuForTree();
		if(menus!=null){
			return JSONUtil.objectToJson(BaseJSON.setOK(menus));
		}
		return null;
	}
	
}
