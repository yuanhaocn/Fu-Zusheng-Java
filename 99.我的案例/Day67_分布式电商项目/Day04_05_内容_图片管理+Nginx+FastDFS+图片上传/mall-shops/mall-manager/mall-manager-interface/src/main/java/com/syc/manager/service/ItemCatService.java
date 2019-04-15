package com.syc.manager.service;

import com.syc.commons.pojo.ZTreeNode;
import com.syc.manager.pojo.TbItemCat;

import java.util.List;

/**
 * 商品管理---->商品分类接口
 */
public interface ItemCatService {

    /**
     * 根据父节点id获取该父节点下的商品分类列表
     */
    List<ZTreeNode> getItemCatList(long parentId);

    /**
     * 根据节点id查找对应的商品分类对象
     */
    TbItemCat getItemCatById(Long id);
}
