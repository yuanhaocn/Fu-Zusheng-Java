package com.syc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.utils.JsonUtils;
import com.syc.rest.pojo.CatResult;
import com.syc.rest.service.ItemCatService;

/**
 * 商品分类的控制器
 * 
 * @类名称:ItemCatController
 * @创建人:一一哥
 * @创建时间:2017年11月13日 下午4:58:37
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService catService;

	// 把查询商品分类的功能发布成服务,返回js代码
	@RequestMapping(value = "/itemcat/all", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public String findItemCatList(String callback) {
		System.out.println("rest--->callback=" + callback);
		CatResult result = catService.findItemCatService();
		// 将Java对象转成json字符串
		String json = JsonUtils.objectToJson(result);

		String show = callback + "(" + json + ")";

		System.out.println("result=" + show);

		return show;
	}

	// 把查询商品分类的功能发布成服务,返回js代码
	// spring4.1之后支持的
	// @RequestMapping(value = "/itemcat/all", produces =
	// MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	// @ResponseBody
	// public Object findItemCatLists(String callback) {
	// System.out.println("rest--->callback2="+callback);
	// CatResult result = catService.findItemCatService();
	// // 将Java对象转成json字符串
	// MappingJacksonValue value=new MappingJacksonValue(result);
	// //JSONP,跨域?,设置JSONP函数的名称.
	// value.setJsonpFunction(callback);
	// System.out.println("value="+value.toString());
	// return value;
	// }
}
