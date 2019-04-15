package com.syc.manager.service;

import com.syc.manager.pojo.TbUser;

/**
 * @author yyg
 */
public interface UserService {

    /**
     * 通过用户名获取用户
     */
    TbUser getUserByUsername(String username);

}
