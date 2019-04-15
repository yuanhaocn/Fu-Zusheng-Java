package com.syc.springboot.web;

import com.syc.springboot.SpringConfig;
import com.syc.springboot.domain.User;
import com.syc.springboot.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 默认web页面
 */
public class TestController {

    public static void main(String[] args){
        //注意此处使用的不再是 xml context,而是AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.findAllUser();
        System.out.println("users="+users.toString());
    }
}
