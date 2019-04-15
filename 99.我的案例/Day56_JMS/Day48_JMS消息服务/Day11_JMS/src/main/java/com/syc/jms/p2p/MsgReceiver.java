package com.syc.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgReceiver {

	public static void main(String[] args) {
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
			Connection conn = factory.createConnection();
			// 开启连接
			conn.start();
			// 创建最重要的session对象
			// transacted:表示是否开启事务.
			// :acknowledgeMode:应答模式
			// true:则第二个参数的设置无效,表示开启事务;
			// false:设置第二个值才有效,一般采用自动应答模式,接受者用来告诉消息队列收到了消息.
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// 创建消息的目的地
			// Destination destination=session.createQueue("queue1707");
			Queue queue = session.createQueue("queue1707");

			// 创建消息的消费者
			MessageConsumer consumer = session.createConsumer(queue);

			// 消息推送(极光/腾讯/个推....推送)---->长连接:
			// 服务器(某个应用的服务器/网站)(发送消息):

			// 维护一个 长连接---->socket/发送心跳帧

			// 客户端(手机/PC)(接收消息)
			while (true) {
				TextMessage msg = (TextMessage) consumer.receive();
				if (msg != null) {
					String text = msg.getText();
					System.out.println("接收的消息:" + text);
				}
			}

			// 释放资源
			// consumer.close();
			// session.close();
			// conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
