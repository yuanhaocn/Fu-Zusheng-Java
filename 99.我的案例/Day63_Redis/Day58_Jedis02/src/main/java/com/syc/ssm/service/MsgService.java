package com.syc.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.syc.ssm.domain.Msg;
import com.syc.ssm.mapper.MsgMapper;
import com.syc.ssm.util.RedisUtil;

@Service("msgService")
public class MsgService {

	@Autowired
	private MsgMapper mapper;

	@Autowired
	private RedisUtil redisUtil;

	// 添加消息
	public boolean addMsg(Msg msg) {
		System.out.println("添加数据库...");
		// 消息内容添加到MySQL数据库中.
		boolean result = mapper.addMsg(msg)>0?true:false;
		if(result){
			redisUtil.expire("msgs", 0);
		}
		
		return result;
	}

	public List<Msg> queryAll() {
		// 1.先从Redis数据库中进行查询--->result.
		List<Object> result = redisUtil.lGet("msgs", 0, -1);

		List<Msg> msgs;

		if (result != null && result.size() > 0) {
			System.out.println("redis......");
			// 4.直接利用Redis中获取的数据(该数据是json格式的),然后转换为JSON格式的数据!
			msgs = JSON.parseArray(result.get(0).toString(), Msg.class);
		} else {
			// 2.如果Redis中没有数据,则直接查询MySQL数据库.
			msgs = mapper.queryAll();

			// 3.然后将该集合添加到Redis数据库中!
			System.out.println("json="+JSON.toJSONString(msgs));
			
			redisUtil.lSet("msgs", JSON.toJSONString(msgs));
		}

		return msgs;
	}
}
