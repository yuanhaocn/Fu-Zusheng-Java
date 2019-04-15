package com.syc.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgSender {

	public static void main(String[] args) {
		try {
			ConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
			Connection conn = factory.createConnection();
			//开启连接
			conn.start();
			//创建最重要的session对象
			//transacted:表示是否开启事务.
			//:acknowledgeMode:应答模式
			//true:则第二个参数的设置无效,表示开启事务;
			//false:设置第二个值才有效,一般采用自动应答模式,接受者用来告诉消息队列收到了消息.
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//创建消息的目的地
			//Destination destination=session.createQueue("queue1707");
			Queue queue = session.createQueue("queue1707");
			
			//创建消息的生产者.
			MessageProducer producer = session.createProducer(queue);
			
			//创建消息对象
			TextMessage msg = session.createTextMessage();
			msg.setText("传递的消息,来自于服务端....");
			
			//发送消息.
			producer.send(msg);
			
			//只有开启事务后才能提交
			//session.commit();
			
			//是否资源
			producer.close();
			session.close();
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
