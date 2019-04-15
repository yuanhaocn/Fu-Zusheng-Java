package com.syc.bookstore.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * 
 * @类名称:SendJUtil
 * @创建人:SYC
 * @创建时间:2017年7月9日 下午7:53:50
 */
public class SendJUtil {

	public static boolean sendMail(String email, String emailMsg) {
		String username = "syc@sun.com";
		String password = "123";

		// 获取Properties属性对象
		Properties props = System.getProperties();
		// 设置smtp服务器
		// props.setProperty("mail.smtp.host", "smtp.163.com");
		props.setProperty("mail.smtp.host", "localhost");
		// 设置是否进行smtp验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器协议类型
		props.setProperty("mail.transport.protocol", "smtp");
		// 获取Email中的Session会话对象
		Session session = Session.getInstance(props);
		// 设置调试信息
		session.setDebug(true);

		try {
			// 发件人地址
			String from = "syc@sun.com";
			// 收件人地址
			String to = email;
			// 创建消息对象
			MimeMessage msg = new MimeMessage(session);
			// 设置发件人地址
			msg.setFrom(new InternetAddress(from));
			msg.setSubject("用户激活");
			//msg.setText("激活成功,欢迎登陆Book图书系统!");
			//设置邮件内容
			msg.setContent(emailMsg, "text/html;charset=UTF-8");

			// 获取一个信息传输对象
			Transport transport = session.getTransport();
			//设置服务器地址,端口号,用户名,密码
			transport.connect("localhost", 25, username, password);
			//设置要发送的消息内容及收件人地址
			transport.sendMessage(msg, new Address[] { new InternetAddress(to) });
			// 关闭传输端口
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
