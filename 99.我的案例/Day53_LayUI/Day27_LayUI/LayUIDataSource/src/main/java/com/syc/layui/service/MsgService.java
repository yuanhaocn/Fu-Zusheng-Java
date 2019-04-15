package com.syc.layui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.layui.domain.Msg;
import com.syc.layui.domain.MsgExample;
import com.syc.layui.domain.UserMsg;
import com.syc.layui.mapper.MsgMapper;

@Service
public class MsgService {

	//int page=1;
	//int limit=10;
	
	@Autowired
	private MsgMapper mapper;
	
	public UserMsg getMsg(){
		MsgExample example=new MsgExample();
		List<Msg> msgs = mapper.selectByExample(example);
		
		UserMsg users=new UserMsg();
		users.setCode(0);
		users.setMsg("");
		//数量
		long count = mapper.countByExample(example);
		users.setCount(count);
		users.setData(msgs);
		return users;
	}
}
