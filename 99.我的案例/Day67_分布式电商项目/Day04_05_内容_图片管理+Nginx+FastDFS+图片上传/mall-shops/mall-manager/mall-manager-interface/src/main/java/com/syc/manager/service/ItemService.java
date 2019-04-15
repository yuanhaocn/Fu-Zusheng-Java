package com.syc.manager.service;

import com.syc.commons.pojo.DataTableResult;
import com.syc.manager.dto.ItemDTO;
import com.syc.manager.pojo.TbItem;

/**
 * 商品列表的接口
 */
public interface ItemService {

    /**
     * 分页搜索排序获取商品列表
     */
    DataTableResult getItemList(int draw, int start, int length, int cid, String search, String orderColumn, String orderDir);

    /**
     * 获取商品总数量
     */
    DataTableResult getAllItemCount();

    /**
     * 添加商品
     */
    TbItem addItem(ItemDTO itemDto);

    /**
     * 根据id查询对应的TbItem对象
     */
    TbItem getTbItemById(Long id);
}
