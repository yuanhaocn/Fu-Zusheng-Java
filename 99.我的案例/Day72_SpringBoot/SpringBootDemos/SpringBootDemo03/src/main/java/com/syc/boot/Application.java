package com.syc.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *  项目的入口类
 *  启动方式一:建立Application类,直接run;
 *  启动方式二:SpringBoot插件启动.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.syc.boot"})
public class Application {

    private static final Logger LOGGER=LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class);
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for(String profile : profiles){
            LOGGER.warn("profile="+profile);
        }
    }
}
