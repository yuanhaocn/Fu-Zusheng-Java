package com.syc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.common.utils.ShopResult;
import com.syc.mapper.TbItemParamMapper;
import com.syc.pojo.TbItemParam;
import com.syc.pojo.TbItemParamExample;
import com.syc.pojo.TbItemParamExample.Criteria;
import com.syc.service.ItemParamService;

/*
 * 商品规格接口实现类
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;

	// 根据商品分类添加商品规格模板
	@Override
	public ShopResult addItemParam(Long itemCatId, String paramData) {
		
		//创建商品规格项
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(itemCatId);
		itemParam.setParamData(paramData);
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());

		//添加商品规格
		itemParamMapper.insert(itemParam);

		return ShopResult.ok();
	}

	// 根据商品分类id查找商品规格模板
	@Override
	public ShopResult findItemParamByCatId(Long itemCatId) {
		
		//设置查询条件
		TbItemParamExample example=new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(itemCatId);
		
		//itemParamMapper.selectByExample(example);
		List<TbItemParam> itemParams = itemParamMapper.selectByExampleWithBLOBs(example);
		if(itemParams!=null&&itemParams.size()>0){
			System.out.println(itemParams.get(0).getParamData());
			return ShopResult.ok(itemParams.get(0).getParamData());
		}
		
		return ShopResult.ok();
	}

}
