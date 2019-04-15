package com.syc.boot.service;

import com.syc.boot.domain.Message;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * Service接口
 */
public interface MsgService {

    List<Message> findAllMsg();

    Message findMsgByID(Integer id);

    void deleteMsg(Integer id);

    void deleteAllMsg();

    void updateMsg(Message msg);

    void saveMsg(Message msg);

    boolean existMsg(Example<Message> example);
}
