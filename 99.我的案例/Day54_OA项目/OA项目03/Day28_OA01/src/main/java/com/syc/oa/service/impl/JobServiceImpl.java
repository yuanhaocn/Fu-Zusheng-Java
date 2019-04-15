package com.syc.oa.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbJob;
import com.syc.oa.domain.TbJobExample;
import com.syc.oa.mapper.TbJobMapper;
import com.syc.oa.service.JobService;
import com.syc.oa.vo.PageBean;

/*
 * 部门模块的实现类
 */
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private TbJobMapper mapper;

	@Override
	public PageBean<TbJob> findJob(String jobName) {

		TbJobExample example = new TbJobExample();

		example.createCriteria().andNameLike("%" + jobName + "%");

		List<TbJob> jobs = mapper.selectByExample(example);

		// 部门中,是否关联了对应的员工信息,如果关联了,怎么处理?

		PageBean<TbJob> bean = new PageBean<>();
		bean.setTotal(jobs.size());
		bean.setRows(jobs);

		return bean;
	}

	@Override
	public boolean addJob(TbJob job) {

		return mapper.insertSelective(job) > 0;
	}

	@Override
	public boolean updateJob(TbJob job) {

		return mapper.updateByPrimaryKeySelective(job) > 0;
	}

	@Override
	public TbJob findById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void removeOne(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeMore(Integer[] ids) {
		TbJobExample example = new TbJobExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		mapper.deleteByExample(example);
	}

	@Override
	public List<TbJob> findAll() {
		return mapper.selectByExample(new TbJobExample());
	}

}
