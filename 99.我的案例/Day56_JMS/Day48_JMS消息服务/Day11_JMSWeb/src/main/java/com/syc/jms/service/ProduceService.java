package com.syc.jms.service;

import com.syc.jms.domain.MessageVO;

public interface ProduceService {

	void sendMsg(MessageVO msg);
}
