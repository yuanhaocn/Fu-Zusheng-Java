package com.syc.content.service.impl;

import com.syc.commons.exception.MallException;
import com.syc.commons.pojo.EasyUITreeNode;
import com.syc.commons.pojo.ZTreeNode;
import com.syc.commons.redis.JedisClient;
import com.syc.commons.redis.RedisUtil;
import com.syc.commons.utils.ShopResult;
import com.syc.content.service.ContentCatService;
import com.syc.manager.dto.DTOUtil;
import com.syc.manager.mapper.TbContentCategoryMapper;
import com.syc.manager.pojo.TbContentCategory;
import com.syc.manager.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容分类管理实现类
 */
@Service
public class ContentCatServiceImpl implements ContentCatService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${CONTENT_REDIS_KEY}")
    private String CONTENT_REDIS_KEY;

    @Override
    public List<ZTreeNode> getContentCatList(Long parentId) {
        TbContentCategoryExample example=new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        example.setOrderByClause("sort_order");
        List<TbContentCategory> catList=contentCategoryMapper.selectByExample(example);

        List<ZTreeNode> list=new ArrayList<>();

        for(int i=0;i<catList.size();i++){
            TbContentCategory contentCat = catList.get(i);
            ZTreeNode zTreeNode= new ZTreeNode();
            zTreeNode.setId(Math.toIntExact(contentCat.getId()));
            zTreeNode.setIsParent(contentCat.getIsParent());
            zTreeNode.setpId(Math.toIntExact(contentCat.getParentId()));
            zTreeNode.setName(contentCat.getName());
            zTreeNode.setIcon(contentCat.getIcon());
            zTreeNode.setSortOrder(contentCat.getSortOrder());
            zTreeNode.setStatus(contentCat.getStatus());
            zTreeNode.setRemark(contentCat.getRemark());
            zTreeNode.setNum(contentCat.getNum());
            list.add(zTreeNode);
        }

        return list;
    }

    @Override
    public void addContentCat(TbContentCategory contentCategory) {
        contentCategory.setParentId((long) 0);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());

        if(contentCategoryMapper.insert(contentCategory)!=1){
            throw new MallException("添加内容分类失败");
        }

        //同步缓存
        //redisUtil.hdel(CONTENT_REDIS_KEY, contentCategory.getId() + "");
    }

    @Override
    public TbContentCategory getContentCatById(Long id) {
        TbContentCategory tbContentCategory=contentCategoryMapper.selectByPrimaryKey(id);
        if(tbContentCategory==null){
            throw new MallException("通过id获得内容分类失败!");
        }
        return tbContentCategory;
    }

    @Override
    public void updateContentCat(TbContentCategory contentCategory) {
        TbContentCategory oldCategory=getContentCatById(contentCategory.getId());
        contentCategory.setParentId(oldCategory.getParentId());
        contentCategory.setIcon(oldCategory.getIcon());
        contentCategory.setCreated(oldCategory.getCreated());
        contentCategory.setUpdated(new Date());

        if(contentCategoryMapper.updateByPrimaryKey(contentCategory)!=1){
            throw new MallException("更新内容分类失败");
        }

        //同步缓存
        //redisUtil.hdel(CONTENT_REDIS_KEY, contentCategory.getId() + "");
    }

    @Override
    public void deleteContentCat(Long id) {
        if(contentCategoryMapper.deleteByPrimaryKey(id)!=1){
            throw new MallException("删除内容分类失败");
        }

        //同步缓存
        //redisUtil.hdel(CONTENT_REDIS_KEY, id+ "");
    }
}
