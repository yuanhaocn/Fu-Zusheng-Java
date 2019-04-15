package com.syc.springboot;

import com.syc.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  Spring项目的核心配置类,用来取代各种spring的xml配置文件
 */
@Configuration //声明当前类是 spring 的配置文件,用来取代各种xml文件,我们可以将各种配置放到这里,比如创建对象等
@ComponentScan(basePackages ={"com.syc.springboot"})// 包扫描,会自动帮我们扫描注解
@PropertySource(value= {"classpath:db.properties"},ignoreResourceNotFound = true)////通过@PropertySource可以指定读取的配置文件，通过@Value注解获取值
public class SpringConfig {

    /**
     *@Bean注解用于创建bean对象,比如创建userdao对象,
     * 相当于配置文件中的bean 标签,
     *当这个配置文件被加载时候,这个注解会被解析,
     *从而会调用此方法创建出对应的对象.
     * 实际开发中,我们自己写的对象都是通过 @Commpent等相关注解来创建的,
     *此注解主要用于创建我们无法添加@Commpent注解的引入依赖类,比如各种
     * 框架中自带的XXXFactoryBean等类.
     */
    @Bean
    public UserDao getUserDao(){
        return new UserDao();
    }

}
