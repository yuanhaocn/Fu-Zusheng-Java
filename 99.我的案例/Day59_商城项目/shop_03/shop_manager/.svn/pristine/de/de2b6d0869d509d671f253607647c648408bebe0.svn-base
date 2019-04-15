package com.syc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.common.pojo.EasyUIDataGridResult;
import com.syc.common.utils.IDUtils;
import com.syc.common.utils.ShopResult;
import com.syc.mapper.TbItemDescMapper;
import com.syc.mapper.TbItemMapper;
import com.syc.mapper.TbItemParamItemMapper;
import com.syc.pojo.TbItem;
import com.syc.pojo.TbItemDesc;
import com.syc.pojo.TbItemExample;
import com.syc.pojo.TbItemParamItem;
import com.syc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;

	@Override
	public EasyUIDataGridResult findItemsByPage(Integer pageNum, Integer pageSize) {

		EasyUIDataGridResult result = new EasyUIDataGridResult();

		// 开始分页
		PageHelper.startPage(pageNum, pageSize);

		TbItemExample example = new TbItemExample();

		List<TbItem> items = itemMapper.selectByExample(example);

		// 设置行数
		result.setRows(items);

		// 对Page<E>结果进行包装
		PageInfo<TbItem> info = new PageInfo<>(items);
		long total = info.getTotal();

		// 设置总数量
		result.setTotal(total);

		return result;
	}

	@Override
	public ShopResult addItem(TbItem item, String desc, String itemParams) throws Exception {

		// 设置商品基本信息
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());

		// 添加商品基本信息
		itemMapper.insert(item);

		// 添加商品描述信息
		ShopResult itemDescResult = addItemDesc(itemId, desc);
		if (itemDescResult.getStatus() != 200) {
			throw new Exception("商品描述添加失败");
		}

		// 添加商品的规格参数数据
		ShopResult itemParamItemResult = addItemParamItem(itemId, itemParams);
		if (itemParamItemResult.getStatus() != 200) {
			throw new Exception("商品规格参数添加失败");
		}

		return ShopResult.ok();
	}

	// 添加商品描述
	private ShopResult addItemDesc(Long itemId, String desc) {

		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());

		itemDescMapper.insert(itemDesc);

		return ShopResult.ok();
	}

	// 添加商品的规格参数数据
	private ShopResult addItemParamItem(Long itemId, String itemParams) {

		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParams);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());

		itemParamItemMapper.insert(itemParamItem);

		return ShopResult.ok();
	}

}
