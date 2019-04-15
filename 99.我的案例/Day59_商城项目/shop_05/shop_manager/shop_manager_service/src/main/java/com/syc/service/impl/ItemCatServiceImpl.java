package com.syc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.common.pojo.EasyTreeNode;
import com.syc.mapper.TbItemCatMapper;
import com.syc.pojo.TbItemCat;
import com.syc.pojo.TbItemCatExample;
import com.syc.pojo.TbItemCatExample.Criteria;
import com.syc.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyTreeNode> findItemCatList(long parentId) {

		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> catList = itemCatMapper.selectByExample(example);
		
		List<EasyTreeNode> nodes=new ArrayList<>();
		
		//遍历List<TbItemCat>集合,封装EasyTreeNode
		for(TbItemCat item : catList){
			EasyTreeNode node=new EasyTreeNode();
			node.setId(item.getId());
			node.setText(item.getName());
			node.setState(item.getIsParent()?"closed":"open");
			
			nodes.add(node);
		}
		
		return nodes;
	}

}
