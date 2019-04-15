package com.syc.oa.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	// 实现邮件发送
	public static boolean sendMail(String receiver, String title, String content) {
		// 3.创建一个Properties配置对象
		Properties props = new Properties();
		// 设置发送服务器的主机地址
		props.setProperty("mail.smtp.host", "localhost");
		// 设置发送服务器的协议
		props.setProperty("mail.smtp.protocol", "smtp");
		// 设置客户端连接服务器时是否需要进行验证
		props.setProperty("mail.smtp.auto", "true");

		// 2.创建一个邮件会话对象
		Session session = Session.getInstance(props);

		// 1.创建消息对象
		MimeMessage msg = new MimeMessage(session);

		// 设置发件人地址
		try {
			msg.setFrom("syc@sun.com");
			msg.setSubject(title);
			msg.setContent(content, "text/html;charset=UTF-8");

			try {
				// 4.获取消息的传输端口
				Transport transport = session.getTransport();

				// 设置与邮件服务器的连接账号的信息
				transport.connect("localhost", 25, "syc@sun.com", "123");

				// 发送邮件.第二个参数:是接收者的邮件地址
				transport.sendMessage(msg, new Address[] { new InternetAddress(receiver) });

				transport.close();
				
				return true;
			} catch (NoSuchProviderException e) {
				e.printStackTrace();
				return false;
			}
		} catch (MessagingException e1) {
			e1.printStackTrace();
			return false;
		}
	}
}
