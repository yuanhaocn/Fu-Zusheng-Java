package com.syc.oa.service;

import java.util.List;

import com.syc.oa.domain.TbJob;
import com.syc.oa.vo.PageBean;

/**
 * 职位管理的接口类
 */
public interface JobService {
	/**
	 * 查询职位
	 */
	public PageBean<TbJob> findJob(String jname);
	
	/**
	 * 新增职位
	 */
	public boolean addJob(TbJob job);

	/**
	 * 修改职位
	 */
	public boolean updateJob(TbJob job);
	
	/**
	 * findJobById,通过id查找一个职位
	 */
	public TbJob findJobById(Integer id);

	/**
	 * 删除一个职位
	 */
	public boolean removeOneJob(Integer id);

	/**
	 * 删除多个职位
	 */
	public boolean removeMore(Integer[] ids);
	
	 /**
     * 查找所有职位
     */
    public List<TbJob> findAll();

}
