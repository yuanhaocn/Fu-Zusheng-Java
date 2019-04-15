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

/**
 * 商品类目的接口实现类
 * @类名称:ItemCatServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月10日 上午10:33:13
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper catMapper;
	
	@Override
	public List<EasyTreeNode> findItemCatList(Long parentId) {

		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> cats = catMapper.selectByExample(example);
		
		List<EasyTreeNode> nodes=new ArrayList<>();
		for(TbItemCat cat : cats){
			EasyTreeNode node=new EasyTreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			//动态设置每个节点的开关状态.如果是父节点,默认closed;否则默认是open.
			node.setState(cat.getIsParent()?"closed":"open");
			
			nodes.add(node);
		}
		
		
		return nodes;
	}

}
