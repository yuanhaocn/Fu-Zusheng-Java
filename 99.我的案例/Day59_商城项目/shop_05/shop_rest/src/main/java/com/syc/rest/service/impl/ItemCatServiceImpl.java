package com.syc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.mapper.TbItemCatMapper;
import com.syc.pojo.TbItemCat;
import com.syc.pojo.TbItemCatExample;
import com.syc.pojo.TbItemCatExample.Criteria;
import com.syc.rest.pojo.CatNode;
import com.syc.rest.pojo.CatResult;
import com.syc.rest.service.ItemCatService;

/**
 * 商品分类条目的服务接口
 * 
 * @类名称:ItemCatServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月13日 下午1:43:04
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper catMapper;

	@SuppressWarnings("rawtypes")
	@Override
	public CatResult findItemCatService() {
		CatResult result = new CatResult();

		List data = getItemCatList(0L);

		result.setData(data);

		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List getItemCatList(Long parentId) {

		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		List<TbItemCat> cats = catMapper.selectByExample(example);

		List lists = new ArrayList<>();
		for (TbItemCat itemCat : cats) {
			if (itemCat.getIsParent()) {// 如果是父节点
				CatNode node = new CatNode();
				// 顶层的分类名字上有链接
				if (parentId == 0) {//顶层的分类
					node.setName("<a href='/products/" + itemCat.getId() + ".html'>" + itemCat.getName() + "</a>");
				} else {
					node.setName(itemCat.getName());
				}

				node.setUrl("/products/" + itemCat.getId() + ".html");
				// 设置子分类
				node.setItem(getItemCatList(itemCat.getId()));
				lists.add(node);
			} else {// 不是父节点
				lists.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
			}
		}

		return lists;
	}

}
