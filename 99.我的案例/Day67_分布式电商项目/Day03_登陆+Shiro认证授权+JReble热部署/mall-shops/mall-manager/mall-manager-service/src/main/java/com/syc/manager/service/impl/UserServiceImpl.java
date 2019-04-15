package com.syc.manager.service.impl;

import com.syc.commons.exception.MallException;
import com.syc.manager.mapper.TbUserMapper;
import com.syc.manager.pojo.TbUser;
import com.syc.manager.pojo.TbUserExample;
import com.syc.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getUserByUsername(String username) {
        List<TbUser> list;
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(username);
        //设置默认状态值
        criteria.andStateEqualTo(1);
        try {
            list=tbUserMapper.selectByExample(example);
       }catch (Exception e){
            throw new MallException("通过ID获取用户信息失败");
        }
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Set<String> getRoles(String userName) {
        
        return tbUserMapper.getRoles(userName);
    }

    @Override
    public Set<String> getPermissions(String userName) {

        return tbUserMapper.getPermissions(userName);
    }
}
