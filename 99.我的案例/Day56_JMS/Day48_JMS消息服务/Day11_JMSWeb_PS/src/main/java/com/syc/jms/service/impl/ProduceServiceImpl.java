package com.syc.jms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syc.jms.domain.MessageVO;
import com.syc.jms.service.ProduceService;

@Transactional
@Service
public class ProduceServiceImpl implements ProduceService{

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate template;
	
	//发送消息
	public void sendMsg(MessageVO msg) {
		//将消息对象转换为符合jms规范的对象,然后再发送!
		//将对象发送到目的地---->队列(主题)中
		template.convertAndSend(msg);
		
		//先接收消息,再转换消息为某个特定的对象.
		//template.receiveAndConvert()/send/receive...;
	}

}
