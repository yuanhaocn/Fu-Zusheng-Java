package com.syc.springboot.dao;

/**
 *
 */

import com.syc.springboot.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *此处没有使用@Repository等@Component系列注解,目的是为了演示 @Bean 注解
 */

public class UserDao {

    //取值
    @Value("${jdbc.url}")
    private String url;

    public List<User> findAllUser() {

        System.out.println("取值--->url="+url);

        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(10 + i);
            user.setUid("uid" + i);
            user.setUserName("zhangsan" + i);
            list.add(user);
        }
        return list;
    }
}

