package com.syc.springboot.service;

import com.syc.springboot.dao.UserDao;
import com.syc.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
