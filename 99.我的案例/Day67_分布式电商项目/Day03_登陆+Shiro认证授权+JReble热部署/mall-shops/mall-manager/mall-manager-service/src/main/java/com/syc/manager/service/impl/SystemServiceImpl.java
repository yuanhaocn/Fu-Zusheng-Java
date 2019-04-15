package com.syc.manager.service.impl;

import com.syc.commons.exception.MallException;
import com.syc.manager.mapper.TbShiroFilterMapper;
import com.syc.manager.pojo.TbShiroFilter;
import com.syc.manager.pojo.TbShiroFilterExample;
import com.syc.manager.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SystemService的实现类
 */
@Service
public class SystemServiceImpl implements SystemService{

    @Autowired
    private TbShiroFilterMapper shiroFilterMapper;

    @Override
    public List<TbShiroFilter> getShiroFilter() {
        TbShiroFilterExample example=new TbShiroFilterExample();
        //按照sort_order进行排序
        example.setOrderByClause("sort_order");
        List<TbShiroFilter> shiroFilters = shiroFilterMapper.selectByExample(example);
        if(shiroFilters==null){
            throw new MallException("获取shiro过滤链失败!");
        }
        return shiroFilters;
    }
}
