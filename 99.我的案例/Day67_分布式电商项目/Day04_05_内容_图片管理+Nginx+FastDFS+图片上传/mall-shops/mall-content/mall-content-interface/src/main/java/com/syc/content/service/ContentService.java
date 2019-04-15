package com.syc.content.service;

import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.utils.ShopResult;
import com.syc.manager.pojo.TbContent;

import java.util.List;

/**
 * 内容管理的接口
 */
public interface ContentService {

    //获取内容列表
    List<TbContent> getContentList(Long cid);

    //添加内容
    void addContent(TbContent content);

    //获取单个内容
    TbContent getContentById(Long id);

    //修改内容
    void updateContent(TbContent tbContent);

    //删除内容
    void deleteContent(Long id);
}
