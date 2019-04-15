package com.syc.content.service;

import com.syc.commons.pojo.EasyUITreeNode;
import com.syc.commons.pojo.ZTreeNode;
import com.syc.commons.utils.ShopResult;
import com.syc.manager.pojo.TbContentCategory;

import java.util.List;

/**
 * 内容分类的服务接口
 */
public interface ContentCatService {

    //查询所有商品分类列表
    List<ZTreeNode> getContentCatList(Long parentId);

    //添加内容分类
    void addContentCat(TbContentCategory contentCategory);

    //根据内容分类id查找内容分类
    TbContentCategory getContentCatById(Long id);

    //修改内容分类
    void updateContentCat(TbContentCategory contentCategory);

    //删除内容分类
    void deleteContentCat(Long id);
}
