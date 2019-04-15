package com.syc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syc.service.Producer;
import com.syc.vo.Mail;

@Transactional
@Service("topic")
public class TopicImpl implements Producer {
	
	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTopicTemplate;

	public void sendMail(Mail mail) {
		jmsTopicTemplate.convertAndSend(mail);
	}

}
