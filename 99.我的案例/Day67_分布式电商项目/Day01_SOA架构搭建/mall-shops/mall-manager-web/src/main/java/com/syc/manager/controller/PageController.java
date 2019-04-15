package com.syc.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页面跳转
 */
@Controller
public class PageController {

    //跳转到首页面
    @RequestMapping("/")
    public String showIndex(){
        System.out.println("index...");
        return "index";
    }

    //跳转到指定的页面	
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
