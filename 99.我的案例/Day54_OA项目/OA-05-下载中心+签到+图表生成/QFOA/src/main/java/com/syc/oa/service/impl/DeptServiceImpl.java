package com.syc.oa.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.oa.domain.TbDept;
import com.syc.oa.domain.TbDeptExample;
import com.syc.oa.domain.TbDeptExample.Criteria;
import com.syc.oa.mapper.TbDeptMapper;
import com.syc.oa.service.DeptService;
import com.syc.oa.vo.PageBean;

/**
 * 部门管理Service实现类
 * 
 * @类名称:DeptServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月4日 下午2:44:56
 */
@Service("deptService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

	@Autowired
	private TbDeptMapper deptMapper;

	/**
	 * 查找部门
	 */
	@Override
	public PageBean<TbDept> findDept(String deptName) {
		// 得到利用部门名模糊搜索得到的部门总数
		TbDeptExample example = new TbDeptExample();
		// 模糊查询
		example.createCriteria().andNameLike("%" + deptName + "%");
		List<TbDept> depts = deptMapper.selectByExample(example);
		for (TbDept dept : depts) {
			dept.setEmployees(null);
		}

		// 进行分页
		PageBean<TbDept> pageBean = new PageBean<>();
		pageBean.setRows(depts);
		pageBean.setTotal(depts.size());

		return pageBean;
	}
	
	/**
	 * 根据id查询部门
	 */
	@Override
	public TbDept findDeptById(Integer id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	/**
	 * 部门添加
	 */
	@Override
	public boolean addDept(TbDept dept) {
		return deptMapper.insertSelective(dept) > 0;
	}
	
	/**
	 * 编辑部门
	 */
	@Override
	public boolean editDept(TbDept dept) {
		return deptMapper.updateByPrimaryKeySelective(dept) > 0;
	}

	/**
	 * 删除一个部门
	 */
	@Override
	public void removeOneDept(Integer id) {
		deptMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除部门
	 */
	@Override
	public void removeMore(Integer[] ids) {
		TbDeptExample example = new TbDeptExample();
		Criteria criteria = example.createCriteria();
		//for (int i = 0; i < ids.length; i++) {
			criteria.andIdIn(Arrays.asList(ids));
		//}
		deptMapper.deleteByExample(example);
	}
	
	/**
	 * 查找所有部门
	 */
	@Override
	public List<TbDept> findAll() {
		return deptMapper.selectByExample(new TbDeptExample());
	}

}
