package com.syc.boot.controller;

import com.syc.boot.domain.City;
import com.syc.boot.domain.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
public class HelloController {

    //定义一个模板,用来格式化字符串
    private static final String template = "Hello, %s!";

    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Map<String,List<Contact>> hello(@RequestParam(value="name", defaultValue="World") String name) {
        Map<String,List<Contact>> map = new HashMap<>();
        List<Contact> list  =new ArrayList<>();
        List<City> citys = new ArrayList<>();
        citys.add(new City(1001,"北京"));
        citys.add(new City(1002,"上海"));

        Contact contact = new Contact();
        contact.setId(1000);
        //用定义好的模板进行格式化
        contact.setName(String.format(template, name));
        contact.setCitys(citys);

        list.add(contact);
        map.put("resultData",list);
        return  map;
    }
}
