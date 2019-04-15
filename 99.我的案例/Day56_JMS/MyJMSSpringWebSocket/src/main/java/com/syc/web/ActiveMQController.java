package com.syc.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.google.gson.GsonBuilder;
import com.syc.service.impl.ProducerImpl;
import com.syc.service.impl.TopicImpl;
import com.syc.vo.Mail;
import com.syc.vo.Message;
import com.syc.websocket.MyWebSocketHandler;

@Controller
public class ActiveMQController {

	// 用来处理WebSocket的消息和生命周期事件的类.
	private MyWebSocketHandler handler = new MyWebSocketHandler();

	@Autowired
	private ProducerImpl producer;

	@Autowired
	private TopicImpl topic;

	// 跳转到index.jsp页面
	@RequestMapping("/index")
	public String demo(HttpSession session) {
		session.setAttribute("username", "syc");
		return "index";
	}

	// @ModelAttribute:运用在参数上的时候,会将客户端传递过来的参数按名称注入到指定对象中,
	// 并且会将这个对象自动加入ModelMap中,便于View层使用.
	// 向队列中添加消息
	@RequestMapping(value = "/produce", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void produce(@ModelAttribute("mail") Mail mail) throws Exception {
		// 设置服务器反馈给客户端浏览器的信息内容.
		Message msg = new Message();
		msg.setText("向队列myQuene添加一条消息:" + mail.toString());
		msg.setDate(new Date());
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
		// handler.sendMessageToUser("syc", new TextMessage(new
		// GsonBuilder().setDateFormat("yyyy-MM-dd
		// HH:mm:ss").create().toJson(msg)));

		// 将消息发送到Queue队列中
		producer.sendMail(mail);
	}

	// 向主题中添加消息
	@RequestMapping(value = "/topic", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void topic(@ModelAttribute("mail") Mail mail) throws Exception {
		// 设置服务器反馈给客户端浏览器的信息内容.
		Message msg = new Message();
		msg.setText("向话题myTopic发布一条消息:" + mail.toString());
		msg.setDate(new Date());
		// 给所有在线用户广播消息
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));

		// 将消息发送到Topic主题中
		topic.sendMail(mail);
	}

}
