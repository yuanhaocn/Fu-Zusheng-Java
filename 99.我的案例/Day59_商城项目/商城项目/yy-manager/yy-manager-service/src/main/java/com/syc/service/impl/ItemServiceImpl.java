package com.syc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.common.pojo.EasyUIDataGridResult;
import com.syc.mapper.TbItemMapper;
import com.syc.pojo.TbItem;
import com.syc.pojo.TbItemExample;
import com.syc.service.ItemService;

/***
 * 商品信息实现类
 * 
 * @类名称:ItemServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月9日 下午3:46:29
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public EasyUIDataGridResult findItemByPage(Integer pageNum, Integer pageSize) {

		EasyUIDataGridResult result=new EasyUIDataGridResult();
		
		//PageHelper类的分页实现,需要写在开始查询之前.
		PageHelper.startPage(pageNum, pageSize);
		
		//查询tb_item全部
		TbItemExample example = new TbItemExample();
		List<TbItem> rows = itemMapper.selectByExample(example);
		
		result.setRows(rows);
		
		//创建一个PageInfo对象
		PageInfo<TbItem> info=new PageInfo<>(rows);
		long total = info.getTotal();
		
		result.setTotal(total);

		return result;
	}

}
