package com.syc.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.ssm.domain.Msg;
import com.syc.ssm.service.MsgService;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("msgService")
	private MsgService service;

	@RequestMapping("/index")
	public String index() {

		return "index";
	}

	// 添加消息
	@RequestMapping("/addMsg")
	public void addMsg(Msg msg,HttpServletResponse response) throws IOException {
		boolean result = service.addMsg(msg);
		
		if(result){
			response.getWriter().print("添加成功!");
		}else{
			response.getWriter().print("添加失败!");
		}
	}

	// 查询消息
	@ResponseBody
	@RequestMapping("/queryMsg")
	public List<Msg> queryMsg() {
		
		return service.queryAll();
	}
}
