package com.syc.content.service.impl;

import com.syc.commons.exception.MallException;
import com.syc.commons.redis.JedisClient;
import com.syc.commons.redis.RedisUtil;
import com.syc.commons.utils.JsonUtils;
import com.syc.commons.utils.ShopResult;
import com.syc.content.service.ContentService;
import com.syc.manager.mapper.TbContentCategoryMapper;
import com.syc.manager.mapper.TbContentMapper;
import com.syc.manager.pojo.TbContent;
import com.syc.manager.pojo.TbContentCategory;
import com.syc.manager.pojo.TbContentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容管理服务实现类
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${CONTENT_REDIS_KEY}")
    private String CONTENT_REDIS_KEY;

    //查找内容列表
    @Override
    public List<TbContent> getContentList(Long catId) {
        try {
            //从redis缓存中取出对应的内容,以内容分类id作为具体的field.
            //hash类型的缓存:key,field,value结构!
            String str = (String) redisUtil.hget(CONTENT_REDIS_KEY, catId + "");

            if (StringUtils.isNotBlank(str)) {
                //把json字符串还原成List集合
                List<TbContent> list = JsonUtils.jsonToList(str, TbContent.class);
                System.out.println("使用了缓存");
                return list;
            }

            //如果redis缓存中没有对应的内容,则查询数据库,并存放到redis缓存中
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryIdEqualTo(catId);
            List<TbContent> contents = contentMapper.selectByExample(example);
            //关联查询内容分类表
            TbContentCategory tbContentCategory=contentCategoryMapper.selectByPrimaryKey(catId);
            for(int i=0;i<contents.size();i++){
                contents.get(i).setCategoryName(tbContentCategory.getName());
            }

            //放入缓存，缓存的使用不应该影响正常的数据库操作
            redisUtil.hset(CONTENT_REDIS_KEY, catId + "", JsonUtils.objectToJson(contents));
            return contents;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());

        //添加内容时会造成缓存中的数据和数据库中的数据不一致
        int flag = contentMapper.insert(content);
        if (flag <= 0) {
            throw new MallException("内容添加失败!");
        }

        //同步内容到redis缓存中
        redisUtil.hdel(CONTENT_REDIS_KEY, content.getCategoryId() + "");
    }

    //根据id查找内容
    @Override
    public TbContent getContentById(Long id) {
        TbContent tbContent=contentMapper.selectByPrimaryKey(id);
        if(tbContent==null){
            throw new MallException("通过id获取内容失败!");
        }
        return tbContent;
    }

    //更新内容
    @Override
    public void updateContent(TbContent tbContent) {
        TbContent oldContent=getContentById(tbContent.getId());
        if(tbContent.getImage().isEmpty()){
            tbContent.setImage(oldContent.getImage());
        }

        tbContent.setUpdated(new Date());
        tbContent.setCreated(new Date());

        if(contentMapper.updateByPrimaryKey(tbContent)!=1){
            throw new MallException("内容更新失败!");
        }

        //同步缓存
        redisUtil.hdel(CONTENT_REDIS_KEY, tbContent.getCategoryId() + "");
    }

    //删除内容
    @Override
    public void deleteContent(Long id) {
        //同步缓存id
        TbContent tbContent=getContentById(id);

        if(contentMapper.deleteByPrimaryKey(id)!=1){
            throw new MallException("内容删除失败!");
        }

        redisUtil.hdel(CONTENT_REDIS_KEY, tbContent.getCategoryId() + "");
    }

}
