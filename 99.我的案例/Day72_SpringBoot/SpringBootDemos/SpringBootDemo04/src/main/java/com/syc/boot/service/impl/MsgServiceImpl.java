package com.syc.boot.service.impl;

import com.syc.boot.domain.Message;
import com.syc.boot.mapper.MsgRepository;
import com.syc.boot.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 具体实现
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgRepository repository;

    @Override
    public List<Message> findAllMsg() {
        return repository.findAll();
    }

    @Override
    public Message findMsgByID(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteMsg(Integer id) {
        repository.delete(id);
    }

    @Override
    public void deleteAllMsg() {
        repository.deleteAll();
    }

    @Override
    public void updateMsg(Message msg) {
        repository.saveAndFlush(msg);
    }

    @Override
    public void saveMsg(Message msg) {
        repository.save(msg);
    }

    @Override
    public boolean existMsg(Example<Message> example) {
        return repository.exists(example);
    }
}
