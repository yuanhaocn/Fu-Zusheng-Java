package com.syc.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页面跳转
 */
@Controller
@Api(description = "页面跳转控制器")
public class PageController {

    //跳转到首页面
    @RequestMapping("/")
    @ApiOperation(value = "跳转到index.jsp")
    public String showIndex(){
        System.out.println("到index...33333222");
        return "index";
    }

    //跳转到指定的页面
    @RequestMapping("/{page}")
    @ApiOperation(value = "跳转到指定页面")
    public String showPage(@PathVariable String page){
        return page;
    }
}
