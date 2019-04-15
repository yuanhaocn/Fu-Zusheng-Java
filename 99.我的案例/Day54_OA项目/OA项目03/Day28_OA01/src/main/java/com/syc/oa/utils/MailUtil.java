package com.syc.oa.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * 发送邮件工具类
 */
public class MailUtil {

	public static boolean sendMail(String receiver, String title, String content) {
		try {
			//3.创建Properties配置对象props
			Properties props=new Properties();
			//邮件发送时的必要设置
			//smtp:Simple Mail Transport Protocol,简单邮件传输协议,只在发送邮件时使用.
			//pop3:邮件接收协议,在接收邮件的时候使用.
			//指明邮件服务器地址
			props.setProperty("mail.smtp.host", "localhost");
			//使用邮件服务器发送邮件时是否要进行验证
			props.setProperty("mail.smtp.auto", "true");
			//指明邮件服务器采用的协议
			props.setProperty("mail.smtp.protocol", "smtp");
			
			//2.邮件会话对象
			Session session=Session.getInstance(props);
			
			//1.创建一个消息对象.
			MimeMessage msg=new MimeMessage(session);
			
			//4.设置消息内容
			//设置发件人地址
			msg.setFrom(new InternetAddress("syc@sun.com"));
			//设置邮件的主题,也就是标题
			msg.setSubject(title);
			//设置邮件内容
			msg.setContent(content, "text/html;charset=UTF-8");
			
			//5.发送邮件消息
			
			//获取一个传输对象
			Transport transport = session.getTransport();
			//smtp协议端口号:25.
			//pop3协议端口号:110
			//host:服务器地址;port:邮件服务器的端口号;user:邮箱地址,pass:密码
			//建立与服务器之间的连接
			transport.connect("localhost",25, "syc@sun.com", "123");
			//发送信息---->指明收件人地址
			transport.sendMessage(msg, new Address[]{new InternetAddress(receiver)});
			
			transport.close();
			
			return true;
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
