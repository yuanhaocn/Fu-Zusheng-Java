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
import java.util.Date;
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

        for(TbItemCat tbItemCat:list){
            ZTreeNode node= DTOUtil.TbItemCat2ZTreeNode(tbItemCat);
            System.out.println("node="+node.getName()+",parent="+node.getIsParent()+",id="+node.getId()+",pid="+node.getpId());
            resultList.add(node);
        }
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

    @Override
    public void addItemCat(TbItemCat tbItemCat) {
        if(tbItemCat.getParentId()==0){
            //根节点
            tbItemCat.setSortOrder(0);
            tbItemCat.setStatus(1);
        }else{
            TbItemCat parentCat=itemCatMapper.selectByPrimaryKey(tbItemCat.getParentId());
            tbItemCat.setParentId(parentCat.getId());
            tbItemCat.setSortOrder(0);
            tbItemCat.setStatus(1);
            tbItemCat.setCreated(new Date());
            tbItemCat.setUpdated(new Date());
        }

        if(itemCatMapper.insert(tbItemCat)!=1){
            throw new MallException("添加商品分类失败!");
        }
    }

    @Override
    public void updateItemCat(TbItemCat tbItemCat) {
        TbItemCat oldItemCat=getItemCatById(tbItemCat.getId());
        tbItemCat.setCreated(oldItemCat.getCreated());
        tbItemCat.setUpdated(new Date());

        if(itemCatMapper.updateByPrimaryKey(tbItemCat)!=1){
            throw new MallException("添加商品分类失败!");
        }
    }

    @Override
    public void deleteItemCat(Long id) {
        //查询该节点所有子节点
        List<ZTreeNode> node=getItemCatList(Math.toIntExact(id));
        if(node.size()>0){
            //如果有子节点，遍历子节点
            for(int i=0;i<node.size();i++){
                deleteItemCat((long) node.get(i).getId());
            }
        }

        //没有子节点直接删除
        if(itemCatMapper.deleteByPrimaryKey(id)!=1){
            throw new MallException("删除商品分类失败!");
        }
    }

}
