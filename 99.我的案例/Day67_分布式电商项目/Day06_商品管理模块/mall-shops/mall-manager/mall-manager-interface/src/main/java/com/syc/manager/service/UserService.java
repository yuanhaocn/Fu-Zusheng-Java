package com.syc.manager.service;

import com.syc.manager.pojo.TbUser;

import java.util.Set;

/**
 * @author yyg
 */
public interface UserService {

    /**
     * 通过用户名获取用户
     */
    TbUser getUserByUsername(String username);

    /**
     * 获取某个用户对应的角色
     */
    Set<String> getRoles(String userName);

    /**
     * 获取某个用户对应的权限
     */
    Set<String> getPermissions(String userName);

}
