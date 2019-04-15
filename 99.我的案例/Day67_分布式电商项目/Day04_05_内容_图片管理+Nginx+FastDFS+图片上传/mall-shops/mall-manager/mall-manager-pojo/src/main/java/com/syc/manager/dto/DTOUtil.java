package com.syc.manager.dto;

import com.syc.commons.pojo.ZTreeNode;
import com.syc.manager.pojo.TbItem;
import com.syc.manager.pojo.TbItemCat;


/**
 *  JavaBean转换工具类
 */
public class DTOUtil {

    /**
     * TbItemCat转为ZTreeNode对象
     */
    public static ZTreeNode TbItemCat2ZTreeNode(TbItemCat tbItemCat) {
        ZTreeNode zTreeNode = new ZTreeNode();

        zTreeNode.setId(Math.toIntExact(tbItemCat.getId()));
        zTreeNode.setStatus(tbItemCat.getStatus());
        zTreeNode.setSortOrder(tbItemCat.getSortOrder());
        zTreeNode.setName(tbItemCat.getName());
        zTreeNode.setpId(Math.toIntExact(tbItemCat.getParentId()));
        zTreeNode.setIsParent(tbItemCat.getIsParent());
        //zTreeNode.setRemark(tbItemCat.getRemark());

        return zTreeNode;
    }

    /**
     * ItemDTO转换为TbItem对象
     */
    public static TbItem ItemDTO2TbItem(ItemDTO itemDto) {
        TbItem tbItem =new TbItem();

        tbItem.setTitle(itemDto.getTitle());
        tbItem.setPrice(itemDto.getPrice());
        tbItem.setCid(itemDto.getCid());
        tbItem.setImage(itemDto.getImage());
        tbItem.setSellPoint(itemDto.getSellPoint());
        tbItem.setNum(itemDto.getNum());

        if(itemDto.getLimitNum()==null||itemDto.getLimitNum()<0){
            tbItem.setLimitNum(10);
        }else{
            tbItem.setLimitNum(itemDto.getLimitNum());
        }

        return tbItem;
    }
}
