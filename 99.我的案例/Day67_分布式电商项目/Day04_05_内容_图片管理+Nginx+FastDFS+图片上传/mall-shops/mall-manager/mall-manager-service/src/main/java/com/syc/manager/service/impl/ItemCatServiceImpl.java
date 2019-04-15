package com.syc.manager.service.impl;

import com.syc.commons.exception.MallException;
import com.syc.commons.pojo.ZTreeNode;
import com.syc.manager.dto.DTOUtil;
import com.syc.manager.mapper.TbItemCatMapper;
import com.syc.manager.pojo.TbItemCat;
import com.syc.manager.pojo.TbItemCatExample;
import com.syc.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理--->商品分类实现类
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private TbItemCatMapper itemCatMapper;

    /**
     * 获取商品分类列表
     */
    @Override
    public List<ZTreeNode> getItemCatList(long parentId) {
        TbItemCatExample example=new TbItemCatExample();
        TbItemCatExample.Criteria criteria=example.createCriteria();
        //排序
        example.setOrderByClause("sort_order");
        //条件查询
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        System.out.println("size="+list.size()+",pid="+parentId);
        //转换成ZTreeNode
        List<ZTreeNode> resultList=new ArrayList<>();
        //List<EasyTreeNode> nodes=new ArrayList<>();

        for(TbItemCat tbItemCat:list){
            ZTreeNode node= DTOUtil.TbItemCat2ZTreeNode(tbItemCat);
            System.out.println("node="+node.getName()+",parent="+node.getIsParent()+",id="+node.getId()+",pid="+node.getpId());
            resultList.add(node);
        }

        /*for(TbItemCat item : list){
            EasyTreeNode node=new EasyTreeNode();
            node.setId(item.getId());
            node.setText(item.getName());
            node.setState(item.getIsParent()?"closed":"open");

            nodes.add(node);
        }*/

        return resultList;
    }

    @Override
    public TbItemCat getItemCatById(Long id) {
        TbItemCat tbItemCat=itemCatMapper.selectByPrimaryKey(id);
        if(tbItemCat==null){
            throw new MallException("根据id获取商品分类失败!");
        }
        return tbItemCat;
    }
}
