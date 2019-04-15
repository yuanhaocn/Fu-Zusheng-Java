package com.syc.jms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.jms.domain.MessageVO;
import com.syc.jms.service.ProduceService;

@Controller
public class ActiveMQController {
	
	@Autowired
	private ProduceService service;
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}

	//@ModelAttribute:从前端页面中获取对应的值,并且保存到request域中.
	@RequestMapping("/produce")
	@ResponseBody
	public void produceMsg(@ModelAttribute MessageVO msg){
		service.sendMsg(msg);
	}
}

