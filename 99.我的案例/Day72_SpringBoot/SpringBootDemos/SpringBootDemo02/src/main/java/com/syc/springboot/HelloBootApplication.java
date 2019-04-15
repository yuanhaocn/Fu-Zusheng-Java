package com.syc.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @SpringBootApplication：Spring Boot项目的核心注解，
 * 主要目的是开启自动配置,可以将程序以 web 方式运行;
 * @Configuration：这是一个Spring的配置类；
 * @Controller：标明这是一个SpringMVC的Controller控制器；
 */
@SpringBootApplication
@Configuration
@Controller
public class HelloBootApplication {

    @RequestMapping("helloBoot")
    @ResponseBody
    public  String helloWorld() {

        return "Hello,Spring Boot!";
    }
}
