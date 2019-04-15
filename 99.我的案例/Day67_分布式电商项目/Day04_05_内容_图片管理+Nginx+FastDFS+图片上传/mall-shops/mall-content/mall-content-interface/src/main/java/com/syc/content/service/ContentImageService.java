package com.syc.content.service;

import com.syc.commons.pojo.DataTableResult;
import com.syc.commons.pojo.ResponseResult;
import com.syc.manager.pojo.TbContent;
import com.syc.manager.pojo.TbImage;

import java.util.List;

/**
 * 图片管理模块
 */
public interface ContentImageService {

    List<TbImage> getContentImages();

    TbImage getContentImageById(Long id);

    int updateContentImage(TbImage tbImage);
}
