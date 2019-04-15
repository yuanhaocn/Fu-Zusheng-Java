package com.syc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.commons.exception.MallException;
import com.syc.commons.pojo.DataTableResult;
import com.syc.commons.utils.IDUtil;
import com.syc.manager.dto.DTOUtil;
import com.syc.manager.dto.ItemDTO;
import com.syc.manager.mapper.TbItemDescMapper;
import com.syc.manager.mapper.TbItemMapper;
import com.syc.manager.pojo.TbItem;
import com.syc.manager.pojo.TbItemDesc;
import com.syc.manager.pojo.TbItemExample;
import com.syc.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品列表实现类
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    /**
     * 分页查询商品列表
     */
    @Override
    public DataTableResult getItemList(int draw, int start, int pageSize, int cid, String search, String orderColumn, String orderOperator) {
        //分页执行查询返回结果
        PageHelper.startPage(start/pageSize+1,pageSize);

        List<TbItem> list = itemMapper.selectItemByCondition(cid,"%"+search+"%",orderColumn,orderOperator);
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);

        DataTableResult result=new DataTableResult();

        //设置符合条件的商品数量
        result.setRecordsFiltered((int)pageInfo.getTotal());

        //设置商品总数量
        result.setRecordsTotal(getAllItemCount().getRecordsTotal());

        result.setDraw(draw);

        result.setData(list);

        return result;
    }

    /**
     * 获取商品总数量
     */
    @Override
    public DataTableResult getAllItemCount() {
        TbItemExample example=new TbItemExample();
        Long count=itemMapper.countByExample(example);
        DataTableResult result=new DataTableResult();
        result.setRecordsTotal(Math.toIntExact(count));
        return result;
    }

    /**
     * 添加商品
     */
    @Override
    public TbItem addItem(ItemDTO itemDto) {
        long id= IDUtil.getRandomId();
        TbItem tbItem= DTOUtil.ItemDTO2TbItem(itemDto);
        tbItem.setId(id);
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());

        //图片为空时上传空白的图片
        if(tbItem.getImage().isEmpty()){
            tbItem.setImage("http://ow2h3ee9w.bkt.clouddn.com/nopic.jpg");
        }

        if(itemMapper.insertSelective(tbItem)!=1){
            throw new MallException("商品添加失败!");
        }

        TbItemDesc tbItemDesc=new TbItemDesc();
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(itemDto.getDetail());
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());

        if(itemDescMapper.insertSelective(tbItemDesc)!=1){
            throw new MallException("商品详情添加失败!");
        }

        //发送消息到同步索引库
        //sendRefreshESMessage("add",id);

        return getTbItemById(id);
    }

    /**
     * 根据id查找对应的TbItem
     */
    @Override
    public TbItem getTbItemById(Long id) {

        return itemMapper.selectByPrimaryKey(id);
    }
}
