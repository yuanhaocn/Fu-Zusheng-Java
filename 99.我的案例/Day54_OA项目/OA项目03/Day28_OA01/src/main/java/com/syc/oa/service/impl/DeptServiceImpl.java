package com.syc.oa.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbDept;
import com.syc.oa.domain.TbDeptExample;
import com.syc.oa.mapper.TbDeptMapper;
import com.syc.oa.service.DeptService;
import com.syc.oa.vo.PageBean;

/**
 * JavaDoc注释. 部门模块的实现类
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private TbDeptMapper mapper;

	/**
	 * 查找部门信息
	 */
	@Override
	public PageBean<TbDept> findDept(String deptName) {
		TbDeptExample example = new TbDeptExample();
		example.createCriteria().andNameLike("%" + deptName + "%");

		List<TbDept> depts = mapper.selectByExample(example);

		// 部门中,是否关联了对应的员工信息,如果关联了,怎么处理?
		PageBean<TbDept> bean = new PageBean<>();
		bean.setTotal(depts.size());
		bean.setRows(depts);

		return bean;
	}

	@Override
	public boolean addDept(TbDept dept) {

		return mapper.insertSelective(dept) > 0;
	}

	@Override
	public void removeOne(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeMore(Integer[] ids) {
		TbDeptExample example = new TbDeptExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		mapper.deleteByExample(example);
	}

	@Override
	public boolean updateDept(TbDept dept) {

		return mapper.updateByPrimaryKeySelective(dept) > 0;
	}

	@Override
	public TbDept findById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TbDept> findAll() {
		return mapper.selectByExample(new TbDeptExample());
	}

}
