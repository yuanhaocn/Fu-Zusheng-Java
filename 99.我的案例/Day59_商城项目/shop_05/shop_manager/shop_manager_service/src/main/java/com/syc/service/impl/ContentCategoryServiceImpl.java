package com.syc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.common.pojo.TreeNode;
import com.syc.common.utils.ShopResult;
import com.syc.mapper.TbContentCategoryMapper;
import com.syc.pojo.TbContentCategory;
import com.syc.pojo.TbContentCategoryExample;
import com.syc.pojo.TbContentCategoryExample.Criteria;
import com.syc.service.ContentCategoryService;

/**
 * 内容分类服务的实现类
 * 
 * @类名称:ContentCategoryServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月16日 下午5:42:28
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper categoryMapper;

	@Override
	public List<TreeNode> getContentCategoryList(long parentId) {

		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> categories = categoryMapper.selectByExample(example);

		// 封装List<TreeNode>集合
		List<TreeNode> nodes = new ArrayList<>();
		for (TbContentCategory category : categories) {
			TreeNode node = new TreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent() ? "closed" : "open");
			nodes.add(node);
		}

		return nodes;
	}

	@Override
	public ShopResult createNode(long parentId, String name) {
		// 创建Pojo对象
		TbContentCategory node = new TbContentCategory();
		node.setName(name);
		node.setIsParent(false);
		node.setParentId(parentId);
		// 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列,取值范围:大于零的整数.
		node.setSortOrder(1);
		// 状态。可选值:1(正常),2(删除)
		node.setStatus(1);
		node.setCreated(new Date());
		node.setUpdated(new Date());
		categoryMapper.insertSelective(node);

		// 更新父节点
		// 取父节点
		TbContentCategory parentNode = categoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {// 判断是否是父节点
			parentNode.setIsParent(true);
			// 更新父节点isParent列
			categoryMapper.updateByPrimaryKeySelective(parentNode);
		}

		// 返回结果
		return ShopResult.ok(node);
	}

	@Override
	public ShopResult renameNode(long id, String name) {
		TbContentCategory node = new TbContentCategory();
		node.setName(name);
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andIdEqualTo(id);
		categoryMapper.updateByExampleSelective(node, example);

		// 返回结果
		return ShopResult.ok(node);
	}

	@Override
	public ShopResult deleteNode(long id) {

		// TbContentCategory node = categoryMapper.selectByPrimaryKey(id);
		categoryMapper.deleteByPrimaryKey(id);

		return ShopResult.ok();
	}

}
