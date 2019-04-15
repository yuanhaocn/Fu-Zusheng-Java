package com.syc.jms.ps;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

//p/s模式中的消息订阅者
public class MsgSubscriber {

	public static void main(String[] args) {
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
			Connection conn = factory.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// 创建主题对象
			Topic topic = session.createTopic("topic1707");

			MessageConsumer consumer = session.createConsumer(topic);

			// 同步的接收消息:
			// consumer.receive();

			// 异步的执行
			// obj.setXXXListener(XXXListener);--->接口回调.
			consumer.setMessageListener(new MessageListener() {
				// 匿名内部类的写法.当接口执行完,收到消息后,执行该方法.
				public void onMessage(Message message) {
					if (message != null) {
						TextMessage msg = (TextMessage) message;
						try {
							String text = msg.getText();
							System.out.println("1.订阅的消息=" + text);
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}
				}
			});

			// 人为的阻塞一下代码的执行.
			System.in.read();

			consumer.close();
			session.close();
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
