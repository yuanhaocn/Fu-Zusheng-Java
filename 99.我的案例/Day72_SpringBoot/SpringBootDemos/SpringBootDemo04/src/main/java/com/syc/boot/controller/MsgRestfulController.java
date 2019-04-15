package com.syc.boot.controller;

import com.syc.boot.RestfulUrlTemplate;
import com.syc.boot.domain.Message;
import com.syc.boot.service.MsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Restful风格的Controller
 */
@RestController
@RequestMapping("/restfulApi")
public class MsgRestfulController {

    static final Logger logger = LoggerFactory.getLogger(MsgRestfulController.class);

    @Autowired
    private MsgService service;

    /**
     * 查找所有的Msg
     */
    @RequestMapping(value = RestfulUrlTemplate.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> findAllMsg() {
        List<Message> list = service.findAllMsg();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 根据id查找Msg
     */
    @RequestMapping(value = RestfulUrlTemplate.FIND_ONE_MSG, method = RequestMethod.GET)
    public ResponseEntity<?> findMsgByID(@PathVariable("id") Integer id) {
        logger.info("Msg id is " + id);
        Message msg = service.findMsgByID(id);
        if (msg == null) {
            logger.info("Msg is not found!");
            return new ResponseEntity<Object>("Msg is not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    /**
     * 根据id删除Msg
     */
    @RequestMapping(value = RestfulUrlTemplate.DELETE_MSG, method = RequestMethod.GET)
    public ResponseEntity<?> deleteMsgById(@PathVariable("id") Integer id) {
        logger.info("delete msg by id");
        Message msg = service.findMsgByID(id);
        if (msg == null) {
            return new ResponseEntity<>("unable to delete with id:" + id, HttpStatus.NOT_FOUND);
        }
        service.deleteMsg(id);
        return new ResponseEntity<>("删除成功!",HttpStatus.OK);
    }

    /**
     * 删除全部的Msg
     */
    @RequestMapping(value = RestfulUrlTemplate.DELETE_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> deleteALlMsg() {
        service.deleteAllMsg();
        return new ResponseEntity<>("删除成功!",HttpStatus.OK);
    }

    /**
     * 保存Msg
     */
    @RequestMapping(value = RestfulUrlTemplate.CREATE_MSG, method = RequestMethod.POST)
    public ResponseEntity<?> createMsg(@RequestBody Message msg) {
        if (service.existMsg(Example.of(msg))) {
            logger.info("对象已经存在了");
            return new ResponseEntity<>("Msg is exist!" + msg.getName(), HttpStatus.CONFLICT);
        }
        service.saveMsg(msg);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 更新Msg
     */
    @RequestMapping(value = RestfulUrlTemplate.UPDATE_MSG, method = RequestMethod.POST)
    public ResponseEntity<?> updateMsg(@PathVariable("id") Integer id, @RequestBody Message message) {
        Message msg = service.findMsgByID(id);
        if (msg == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        logger.warn("msg="+msg.toString());
        msg.setMsg(message.getMsg());
        msg.setName(message.getName());
        service.updateMsg(msg);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
