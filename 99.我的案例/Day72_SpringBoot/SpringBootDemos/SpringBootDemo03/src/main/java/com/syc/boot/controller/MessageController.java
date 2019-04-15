package com.syc.boot.controller;

import com.github.pagehelper.PageHelper;
import com.syc.boot.domain.Message;
import com.syc.boot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *注解RestController声明出一个 rest 风格的 controller
 */
//@Controller
@RestController
public class MessageController {

    @Autowired
    private MessageService msgService;

    //根据姓名查询信息
    @RequestMapping(value = "/findMsgByName/{name}")
    public List<Message> findMsgByName(@PathVariable("name") String name){
        /*
         * 第一个参数：第几页;
         * 第二个参数：每页获取的条数.
         */
        PageHelper.startPage(1, 2);
        return msgService.findMsgByName(name);
    }

    //查询姓名
    @RequestMapping(value = "/getNameById/{id}")
    public String getNameById(@PathVariable("id") long id){
        //测试全局的异常信息配置:
        String name=null;
        System.out.println("name="+name.toUpperCase());
        return msgService.getNameById(id);
    }

    @RequestMapping(value = "/getMsgById/{id}")
    public Message getMsgById(@PathVariable("id") long id){
        return msgService.getMsgById(id);
    }

    //保存信息
    @RequestMapping("/saveMsg")
    public Message saveMsg(){
        Message msg = new Message();
        msg.setName("张三");
        msg.setMsg("张三的幸福生活");
        msgService.save(msg);
        return msg;
    }

}
