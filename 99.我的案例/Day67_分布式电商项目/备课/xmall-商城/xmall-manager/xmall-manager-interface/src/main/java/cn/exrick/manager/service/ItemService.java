package cn.exrick.manager.service;

import cn.exrick.manager.dto.ItemDto;
import cn.exrick.common.pojo.DataTablesResult;
import cn.exrick.manager.pojo.TbItem;


/**
 * Created by Exrick on 2017/7/29.
 */
public interface ItemService {

     /**
     * 分页搜索排序获取商品列表
     */
    DataTablesResult getItemList(int draw, int start, int length, int cid,
                                 String search, String orderCol, String orderDir);

    /**
     * 多条件查询获取商品列表
     */
    DataTablesResult getItemSearchList(int draw,int start,int length,int cid,
                                       String search,String minDate,String maxDate,
                                       String orderCol,String orderDir);

    /**
     * 通过ID获取商品
     */
    ItemDto getItemById(Long itemId);

    /**
     * 
     */
    TbItem getNormalItemById(Long id);

    /**
     * 获取商品总数
     * @return
     */
    DataTablesResult getAllItemCount();

    /**
     * 添加商品
     */
    TbItem addItem(ItemDto itemDto);

    /**
     * 更新商品
     */
    TbItem updateItem(Long id,ItemDto itemDto);

    /**
     * 修改商品状态
     */
    TbItem alertItemState(Long id,Integer state);

    /**
     * 彻底删除商品
     */
    int deleteItem(Long id);

}
