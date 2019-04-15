package com.syc.jms.listener;

import org.springframework.transaction.annotation.Transactional;

import com.syc.jms.domain.MessageVO;

/**
 * 用来监听Jms的消息队列,一旦发现该队列中,多了一个消息内容,
 * 则读取出来.
 * @类名称:QueueListener
 * @创建人:一一哥
 * @创建时间:2018年4月23日 下午4:08:04
 */
public class QueueListener {

	//不停的去监听消息队列
	@Transactional
	public void showMsg(MessageVO msg){
		System.out.println("队列中的消息内容----->:"+msg.toString());
	}
}
