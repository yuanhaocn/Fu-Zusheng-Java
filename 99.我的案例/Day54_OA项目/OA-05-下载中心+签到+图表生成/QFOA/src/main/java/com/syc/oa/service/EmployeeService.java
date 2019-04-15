package com.syc.oa.service;

import java.util.Map;

import com.syc.oa.domain.TbEmployee;
import com.syc.oa.vo.PageBean;

/**
 * 类描述:员工业务接口类
 */
public interface EmployeeService {

	/**
	 * 查询员工
	 */
	public PageBean<TbEmployee> selectEmployee(Map<String, Object> map);

	/**
	 * 新增员工
	 */
	public boolean addEmployee(TbEmployee employee, Integer jid, Integer did);
	
	/**
	 * 修改员工信息
	 */
	public boolean updateEmployee(TbEmployee employee, Integer jid, Integer did);

	/**
	 * selectEmployeeById 通过ID查找一个员工
	 */
	public TbEmployee selectEmployeeById(Integer id);

	/**
	 * 删除一个员工
	 */
	public boolean removeOne(Integer id);

	/**
	 * 删除多个员工
	 */
	public boolean removeMore(Integer[] ids);

}
