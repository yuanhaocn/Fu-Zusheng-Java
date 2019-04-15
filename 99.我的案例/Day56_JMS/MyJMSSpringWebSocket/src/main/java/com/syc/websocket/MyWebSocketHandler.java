package com.syc.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.syc.vo.Message;

/**
 * 
 * WebSocketHandler:A handler for WebSocket messages and lifecycle events.
 * 用来处理WebSocket的消息和生命周期事件的类.
 *
 * Socket处理器. 消息推送:现在的解决方案如轮询、长连接或者短连接，当然还有其他的一些技术框架,有的是客户端直接去服务端拿数据.
 * 其实推送推送主要讲的是一个推的概念,WebSocket是一种主动推送消息的技术。
 * WebSocket:它实现了浏览器与服务器全双工(full-duplex)通信——允许服务器主动发送信息给客户端。
 * WebSocket实现原理:在实现websocket连线过程中,需要通过浏览器发出websocket连线请求,
 * 然后服务器发出回应,这个过程通常称为“握手”.在 WebSocket API中,
 * 浏览器和服务器只需要做一个握手的动作,然后,浏览器和服务器之间就形成了一条快速通道. 两者之间就直接可以数据互相传送!
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {

	//存放WebSocketSession.
	public static final Map<String, WebSocketSession> userSocketSessionMap;

	static {
		userSocketSessionMap = new HashMap<String, WebSocketSession>();
	}
	
	/**
	 * 给某个用户发送消息
	 */
	public void sendMessageToUser(String username, TextMessage message) throws IOException {
		WebSocketSession session = userSocketSessionMap.get(username);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}
	
	/**
	 * 给所有在线用户发送消息
	 */
	public void broadcast(final TextMessage message) throws IOException {
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();

		// 多线程群发
		while (it.hasNext()) {
			final Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().isOpen()) {
				new Thread(new Runnable() {
					public void run() {
						try {
							if(entry.getValue().isOpen()){//这个判断不能少
								entry.getValue().sendMessage(message);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		}
	}

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String username = (String) session.getAttributes().get("username");
		if (userSocketSessionMap.get(username) == null) {
			userSocketSessionMap.put(username, session);
		}
	}

	/**
	 * 消息处理,在客户端通过Websocket API发送的消息会经过这里,然后进行相应的处理.
	 * 本案例中,浏览器并没有给服务器发送消息,所以不会执行该方法.
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("处理消息...");
		//判断消息内容是否为空
		if (message.getPayloadLength() == 0) {
			return;
		}
		
		//将客户端发送过来的消息接收,并利用Gson进行格式化.
		Message msg = new Gson().fromJson(message.getPayload().toString(), Message.class);
		msg.setDate(new Date());
		
		//服务器将消息发送给某个指定的用户
		sendMessageToUser(msg.getTo(),
				new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户[" + entry.getKey() + "]");
				break;
			}
		}
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户[" + entry.getKey() + "]");
				break;
			}
		}
	}

	// 是否支持不完整的消息
	public boolean supportsPartialMessages() {
		return false;
	}

}
