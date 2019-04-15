package com.syc.oa.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.oa.domain.TbJob;
import com.syc.oa.domain.TbJobExample;
import com.syc.oa.domain.TbJobExample.Criteria;
import com.syc.oa.mapper.TbJobMapper;
import com.syc.oa.service.JobService;
import com.syc.oa.vo.PageBean;

/**
 * 职位管理的接口实现类
 */
@Service("jobService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class JobServiceImpl implements JobService {

	@Autowired
	private TbJobMapper jobMapper;

	/**
	 * 查询职位
	 */
	@Override
	public PageBean<TbJob> findJob(String name) {
		TbJobExample example = new TbJobExample();
		example.createCriteria().andNameLike("%"+name+"%");
		
		List<TbJob> jobs = jobMapper.selectByExample(example);
		for(TbJob job :jobs){
			job.setEmployees(null);
		}
		
		//进行分页
		PageBean<TbJob> bean=new PageBean<>();
		bean.setRows(jobs);
		bean.setTotal(jobs.size());
		
		return bean;
	}

	/**
	 * 新增职位
	 */
	@Override
	public boolean addJob(TbJob job) {
		return jobMapper.insertSelective(job) > 0;
	}
	
	/**
	 * 编辑职位
	 */
	@Override
	public boolean updateJob(TbJob job) {
		return jobMapper.updateByPrimaryKeySelective(job)>0;
	}

	/**
	 * 查找单个职位
	 */
	@Override
	public TbJob findJobById(Integer id) {

		return jobMapper.selectByPrimaryKey(id);
	}

	/**
	 * 移除一个职位
	 */
	@Override
	public boolean removeOneJob(Integer id) {
		return jobMapper.deleteByPrimaryKey(id)>0;
	}

	/**
	 * 批量移除职位
	 */
	@Override
	public boolean removeMore(Integer[] ids) {
		TbJobExample example = new TbJobExample();
		Criteria criteria = example.createCriteria();
		//for (int i = 0; i < ids.length; i++) {
			criteria.andIdIn(Arrays.asList(ids));
		//}
		return jobMapper.deleteByExample(example)>0;
	}

	/**
	 * 查找所有职位
	 */
	@Override
	public List<TbJob> findAll() {
		return jobMapper.selectByExample(new TbJobExample());
	}

}
