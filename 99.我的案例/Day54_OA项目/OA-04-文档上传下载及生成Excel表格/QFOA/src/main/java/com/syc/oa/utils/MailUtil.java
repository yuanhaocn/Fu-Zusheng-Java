package com.syc.oa.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件工具类
 * 
 * @类名称:MailUtil
 * @创建人:SYC
 * @创建时间:2017年11月2日 下午4:23:00
 */
public class MailUtil {

	/**
	 * 发送邮件方法
	 * 
	 * @throws MessagingException
	 */
	public static boolean sendMail(String email, String title, String content) {
		try {
			// 3.创建会话所需的配置文件
			Properties props = new Properties();
			// 指明邮件服务器的地址
			props.setProperty("mail.smtp.host", "localhost");
			// 连接邮件服务器的时候是否需要验证
			props.setProperty("mail.smtp.auto", "true");
			// 发送邮件才采用的协议
			props.setProperty("mail.smtp.protocol", "smtp");

			// 2.创建一个邮件会话
			Session session = Session.getInstance(props);

			// 1.创建一个Message对象
			MimeMessage msg = new MimeMessage(session);

			// 4.设置消息的发件人,主题和内容
			String fromAddress = "syc@sun.com";

			msg.setFrom(new InternetAddress(fromAddress));

			msg.setSubject(title);
			msg.setContent(content, "text/html;charset=UTF-8");

			// 5.验证服务器的连接
			// 打开传输端口
			Transport transport = session.getTransport();

			String username = "syc@sun.com";
			String password = "123";
			// 建立连接
			transport.connect("localhost", 25, username, password);

			// 6.利用传输端口发送消息
			// 第2个参数数收件人的地址
			transport.sendMessage(msg, new Address[] { new InternetAddress(email) });

			transport.close();

			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
