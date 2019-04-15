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

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public EasyUIDataGridResult findItemsByPage(Integer pageNum, Integer pageSize) {

		EasyUIDataGridResult result=new EasyUIDataGridResult();
		
		System.out.println("Num="+pageNum+",Size="+pageSize);
		
		//在查询sql语句执行前，添加下面一行代码,执行分页:必须?
		//开始分页
		PageHelper.startPage(pageNum, pageSize);
		
		TbItemExample example=new TbItemExample();
		
		List<TbItem> items = itemMapper.selectByExample(example);
		
		//设置行数
		result.setRows(items);
		
		//对Page<E>结果进行包装
		PageInfo<TbItem> info=new PageInfo<>(items);
		long total = info.getTotal();
		
		//设置总数量
		result.setTotal(total);
		
		return result;
	}

}
