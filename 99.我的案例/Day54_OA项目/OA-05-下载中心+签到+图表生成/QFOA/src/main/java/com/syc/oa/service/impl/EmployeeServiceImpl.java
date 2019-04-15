package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.oa.domain.TbDept;
import com.syc.oa.domain.TbEmployee;
import com.syc.oa.domain.TbEmployeeExample;
import com.syc.oa.domain.TbEmployeeExample.Criteria;
import com.syc.oa.domain.TbJob;
import com.syc.oa.mapper.TbDeptMapper;
import com.syc.oa.mapper.TbEmployeeMapper;
import com.syc.oa.mapper.TbJobMapper;
import com.syc.oa.service.EmployeeService;
import com.syc.oa.vo.PageBean;

/**
 * EmployeeService的接口实现类
 */
@Service("employeeService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private TbEmployeeMapper employeeMapper;
	@Autowired
	private TbJobMapper jobMapper;
	@Autowired
	private TbDeptMapper deptMapper;

	/**
	 * 员工查询
	 */
	@Override
	public PageBean<TbEmployee> selectEmployee(Map<String, Object> map) {
		// 员工姓名
		String name = (String) map.get("name");
		// 员工身份证号
		String cardId = (String) map.get("cardId");
		// 员工部门id
		Integer did = (Integer) map.get("did");
		// 员工职位id
		Integer jid = (Integer) map.get("jid");
		String phone = (String) map.get("phone");
		String gender = (String) map.get("gender");

		// 根据did和jid的值是否为空来进行相应的查询
		TbEmployeeExample example = new TbEmployeeExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		if (did != null) {
			if (jid != null) {
				criteria.andJidEqualTo(jid).andDidEqualTo(did).andNameLike("%" + name + "%")
						.andCardidLike("%" + cardId + "%").andGenderEqualTo(Integer.valueOf(gender))
						.andPhoneLike("%" + phone + "%");
			} else {
				criteria.andNameLike("%" + name + "%").andCardidLike("%" + cardId + "%")
						.andPhoneLike("%" + phone + "%");
			}
		} else {
			if (jid != null) {
				criteria.andJidEqualTo(jid).andNameLike("%" + name + "%").andCardidLike("%" + cardId + "%")
						.andGenderEqualTo(Integer.valueOf(gender)).andPhoneLike("%" + phone + "%");
			} else {
				criteria.andNameLike("%" + name + "%").andCardidLike("%" + cardId + "%")
						.andPhoneLike("%" + phone + "%");
			}
		}

		List<TbEmployee> employees = employeeMapper.selectByExample(example);
		// 关联查询
		for (TbEmployee employee : employees) {
			// 查询员工的职位
			TbJob job = jobMapper.selectByPrimaryKey(employee.getJid());
			if(job!=null){
				employee.setJob(job);
				employee.getJob().setEmployees(null);
			}

			// 查询员工所属的部门
			TbDept dept = deptMapper.selectByPrimaryKey(employee.getDid());
			if(dept!=null){
				employee.setDept(dept);
				employee.getDept().setEmployees(null);
			}
		}

		// 分页
		PageBean<TbEmployee> bean = new PageBean<>();
		bean.setRows(employees);
		bean.setTotal(employees.size());

		return bean;
	}

	/**
	 * 添加员工
	 */
	@Override
	public boolean addEmployee(TbEmployee employee, Integer jid, Integer did) {
		try {
			// 管理添加员工的职位和部门
			TbJob job = jobMapper.selectByPrimaryKey(jid);
			employee.setJob(job);
			
			TbDept dept = deptMapper.selectByPrimaryKey(did);
			employee.setDept(dept);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			employee.setCreateDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return employeeMapper.insertSelective(employee) > 0;
	}

	/**
	 * 编辑员工
	 */
	@Override
	public boolean updateEmployee(TbEmployee employee, Integer jid, Integer did) {
		TbJob job = jobMapper.selectByPrimaryKey(jid);
		TbDept dept = deptMapper.selectByPrimaryKey(did);
		employee.setJob(job);
		employee.setDept(dept);

		return employeeMapper.updateByPrimaryKeySelective(employee) > 0;
	}

	/**
	 * 查找单个员工
	 */
	@Override
	public TbEmployee selectEmployeeById(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除单个员工
	 */
	@Override
	public boolean removeOne(Integer id) {
		return employeeMapper.deleteByPrimaryKey(id) > 0;
	}

	/**
	 * 删除多个员工
	 */
	@Override
	public boolean removeMore(Integer[] ids) {
		TbEmployeeExample example = new TbEmployeeExample();
		Criteria criteria = example.createCriteria();
		//for (int i = 0; i < ids.length; i++) {
			criteria.andIdIn(Arrays.asList(ids));
		//}
		return employeeMapper.deleteByExample(example) > 0;
	}

}
