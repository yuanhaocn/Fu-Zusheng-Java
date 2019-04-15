package com.syc.boot.service;

import com.syc.boot.domain.Message;
import com.syc.boot.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service层
 */
@Service
public class MessageService {

    @Autowired
    private MessageMapper mapper;

    public List<Message> findMsgByName(String name) {
        return mapper.findMsgByName(name);
    }

    public Message getMsgById(long id) {
        return mapper.getById(id);
    }

    public String getNameById(long id) {
        return mapper.getNameById(id);
    }

    //添加事务,在方法上面是给当前方法添加事务,在类中是给类中的所有方法添加
    @Transactional
    public void save(Message msg) {
        mapper.save(msg);
    }
}
