package com.syc.ssm.mapper;

import java.util.List;

import com.syc.ssm.domain.Msg;

public interface MsgMapper {

	int addMsg(Msg msg);

	List<Msg> queryAll();
}
