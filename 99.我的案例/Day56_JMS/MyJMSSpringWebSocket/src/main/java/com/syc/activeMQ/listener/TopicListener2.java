package com.syc.activeMQ.listener;

import java.io.IOException;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import com.google.gson.GsonBuilder;
import com.syc.vo.Mail;
import com.syc.vo.Message;
import com.syc.websocket.MyWebSocketHandler;

public class TopicListener2 {
	
	MyWebSocketHandler handler = new MyWebSocketHandler();

	@Transactional
	public void displayTopic(Mail mail) throws IOException {
		Message msg = new Message();
		msg.setText("我是主题订阅者2号,我从ActiveMQ的Topic:myTopic中取出一条消息:" + mail.toString());
		msg.setDate(new Date());
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}
}
