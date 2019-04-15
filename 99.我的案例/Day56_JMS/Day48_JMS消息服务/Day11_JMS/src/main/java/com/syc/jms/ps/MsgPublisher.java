package com.syc.jms.ps;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

//p/s模式中的消息发布者
public class MsgPublisher {

	public static void main(String[] args) {
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
			Connection conn = factory.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// 创建主题对象
			Topic topic = session.createTopic("topic1707");
			MessageProducer producer = session.createProducer(topic);
			TextMessage msg = session.createTextMessage();
			msg.setText("P/S模式:发布消息....");
			producer.send(msg);

			producer.close();
			session.close();
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
