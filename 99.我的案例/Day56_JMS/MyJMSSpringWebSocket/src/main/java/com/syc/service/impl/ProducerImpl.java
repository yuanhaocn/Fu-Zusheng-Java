package com.syc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syc.service.Producer;
import com.syc.vo.Mail;

/**
 * JmsTemplate是一个Spring提供的用来操作JMS的模板类,
 * 可以很方便的发送和接收消息,并且资源的管理也都由template来管理了.
 * 发送消息的代码很简单:
 * jmsTemplate.convertAndSend(request);
 * 接收消息也很简单:
 * Object obj = jmsTemplate.receiveAndConvert(); 
 */
@Transactional
@Service("producer")
public class ProducerImpl implements Producer{
	
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void sendMail(Mail mail) {
		jmsTemplate.convertAndSend(mail);
	}

}
