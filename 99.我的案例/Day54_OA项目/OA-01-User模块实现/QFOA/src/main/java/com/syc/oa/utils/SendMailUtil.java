package com.syc.oa.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的工具类
 * 
 * @类名称:SendMailUtil
 * @创建人:SYC
 * @创建时间:2017年8月4日 下午2:30:30
 */
public class SendMailUtil {

	/**
	 * emailAddress:收件人地址;
	 * emailMsg:邮件内容
	 * @方法名称:sendMail
	 * @创建时间:2017年8月4日 下午2:57:12   
	 * @返回类型:boolean
	 */
	public static boolean sendMail(String emailAddress,String emailSubject, String emailMsg) {
		try {
			// 获取配置对象
			Properties props = System.getProperties();
			// 邮件服务协议:smtp;pop3
			// smtp:发送邮件的协议;
			// pop3:接收邮件的协议.
			// 设置发送邮件的服务器.
			// key:设置邮件的服务器;value:邮件服务器地址.
			props.setProperty("mail.smpt.host", "localhost");
			// 设置邮件发送时是否要验证用户名密码.
			props.setProperty("mail.smpt.auth", "true");
			// 设置发送邮件时采用的协议名称.
			props.setProperty("mail.smpt.protocol", "smtp");

			// 1.创建邮件的会话对象.
			Session session = Session.getInstance(props);
			
			// 4.创建Message对象
			MimeMessage msg = new MimeMessage(session);

			// 5.设置邮件消息内容
			// 设置发件人地址
			String from = "syc@sun.com";
			msg.setFrom(new InternetAddress(from));
			// 设置邮件主题
			msg.setSubject(emailSubject);
			// 设置邮件正文内容
			msg.setContent(emailMsg, "text/html;charset=UTF-8");

			// 2.打开一个传输邮件的端口
			Transport transport = session.getTransport();

			String username = "syc@sun.com";
			String password = "123";

			// 设置服务器连接,参数分别是服务器地址;服务器端口号;用户名;密码
			transport.connect("localhost", 25, username, password);
			// 3.msg:要发送的消息内容;address:收件人的地址
			transport.sendMessage(msg, new Address[] { new InternetAddress(emailAddress) });
			// 关闭端口
			transport.close();

			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

}
