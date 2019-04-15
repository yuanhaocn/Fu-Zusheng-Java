package com.syc.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.common.utils.ExceptionUtil;
import com.syc.common.utils.ShopResult;
import com.syc.mapper.TbContentMapper;
import com.syc.pojo.TbContent;
import com.syc.pojo.TbContentExample;
import com.syc.pojo.TbContentExample.Criteria;
import com.syc.rest.service.ContentService;

/**
 * 内容管理服务的接口实现类
 * 
 * @类名称:ContentServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月21日 下午5:30:11
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public ShopResult getContentList(long categoryId) {
		List<TbContent> contents = null;
		try {
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(categoryId);
			contents = contentMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return ShopResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return ShopResult.ok(contents);
	}

}
