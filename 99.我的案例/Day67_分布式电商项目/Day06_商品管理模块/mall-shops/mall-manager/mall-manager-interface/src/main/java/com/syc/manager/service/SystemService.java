package com.syc.manager.service;

import com.syc.manager.pojo.TbShiroFilter;

import java.util.List;

/**
 * 系统管理的Service
 */
public interface SystemService {

    /**
     * 获得shiro过滤链配置
     */
    List<TbShiroFilter> getShiroFilter();
}
