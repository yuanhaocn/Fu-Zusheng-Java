package com.syc.oa.service;

import java.util.Map;

import com.syc.oa.domain.TbAdvice;
import com.syc.oa.vo.PageBean;

public interface NoticeService {

	/**
	 * 添加公告的方法
	 */
	public boolean addNotice(Integer uid,TbAdvice advice);
	
	/**
	 * 查询公告
	 */
	public PageBean<TbAdvice> selectAdvice(Map<String,Object> map);
	
	/**
	 * 根据id查询TbAdvice
	 */
	public TbAdvice selectAdviceById(Integer id);
	
	/**
	 * 修改公告
	 * @方法名称:editNotice
	 * @创建时间:2017年11月2日 下午3:55:16   
	 * @返回类型:boolean
	 */
	public boolean editNotice(TbAdvice advice);

	/**
	 * 根据id进行删除
	 */
	public boolean removeById(Integer id);
	
	/**
	 * 批量上传
	 * @方法名称:removeById
	 * @创建时间:2017年11月2日 下午4:03:19   
	 * @返回类型:boolean
	 */
	public boolean removeMore(Integer[] ids);
}
