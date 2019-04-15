package com.syc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.common.utils.ExceptionUtil;
import com.syc.common.utils.ShopResult;
import com.syc.mapper.TbContentMapper;
import com.syc.pojo.TbContent;
import com.syc.service.ContentService;

/**
 * 内容管理的实现类
 * 
 * @类名称:ContentServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月20日 下午10:07:51
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public ShopResult addContent(TbContent content) {
		try {
			// 补全字段
			content.setUpdated(new Date());
			content.setCreated(new Date());
			contentMapper.insertSelective(content);
		} catch (Exception e) {
			e.printStackTrace();
			return ShopResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return ShopResult.ok();
	}

}
