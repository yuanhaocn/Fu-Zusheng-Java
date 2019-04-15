package com.syc.layui.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.layui.domain.UserMsg;
import com.syc.layui.service.MsgService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private MsgService service;

	@RequestMapping("/msg")
	@ResponseBody
	public UserMsg getUserMsg(int currentPage, int pageSize) {// page,limit是layui默认传递过来的参数!
		// System.out.println("page="+currentPage+",limit="+pageSize);
		System.out.println("page=" + currentPage + ",limit=" + pageSize);
		return service.getMsg();
	}
}
