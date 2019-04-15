package com.syc.content.service.impl;

import com.syc.commons.exception.MallException;
import com.syc.commons.redis.RedisUtil;
import com.syc.commons.utils.JsonUtils;
import com.syc.content.service.ContentImageService;
import com.syc.manager.mapper.TbContentCategoryMapper;
import com.syc.manager.mapper.TbImageMapper;
import com.syc.manager.pojo.TbContentCategory;
import com.syc.manager.pojo.TbImage;
import com.syc.manager.pojo.TbImageExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容图片管理
 */
@Service
public class ContentImageServiceImpl implements ContentImageService {

    @Autowired
    private TbImageMapper tbImageMapper;

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${IMAGE_REDIS_KEY}")
    private String IMAGE_REDIS_KEY;

    @Override
    public List<TbImage> getContentImages() {
        //从redis缓存中取出对应的内容,以内容分类id作为具体的field.
        //hash类型的缓存:key,field,value结构!
        String str = (String) redisUtil.hget(IMAGE_REDIS_KEY, IMAGE_REDIS_KEY);
        if (StringUtils.isNotBlank(str)) {
            //把json字符串还原成List集合
            List<TbImage> images = JsonUtils.jsonToList(str, TbImage.class);
            System.out.println("使用了缓存");
            return images;
        }

        //未使用redis缓存时的情况
        TbImageExample example = new TbImageExample();
        List<TbImage> images = tbImageMapper.selectByExample(example);
        //关联设置图片所属分类
        for (TbImage image : images) {
            TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(Long.valueOf(image.getCategoryId()));
            image.setCategory(tbContentCategory.getName());
        }

        //放入缓存，缓存的使用不应该影响正常的数据库操作
        redisUtil.hset(IMAGE_REDIS_KEY, IMAGE_REDIS_KEY, JsonUtils.objectToJson(images));
        return images;
    }

    @Override
    public TbImage getContentImageById(Long id) {
        TbImage tbImage = tbImageMapper.selectByPrimaryKey(Math.toIntExact(id));
        if (tbImage == null) {
            throw new MallException("通过id获取图片失败!");
        }
        return tbImage;
    }

    @Override
    public int updateContentImage(TbImage tbImage) {
        TbImage oldImage = getContentImageById(Long.valueOf(tbImage.getId()));

        if (tbImage.getImage().isEmpty()) {
            tbImage.setImage(oldImage.getImage());
        }

        tbImage.setUpdated(new Date());
        tbImage.setImageMobile(oldImage.getImageMobile());
        tbImage.setCreated(oldImage.getCreated());

        if (tbImageMapper.updateByPrimaryKey(tbImage) != 1) {
            throw new MallException("更新图片失败");
        }

        //同步缓存,每次修改一个条目,也删除了全部的缓存信息?
        redisUtil.hdel(IMAGE_REDIS_KEY, IMAGE_REDIS_KEY);

        return 1;
    }
}
