package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class EmloyeeServiceImpl implements EmployeeService {

	@Autowired
	private TbEmployeeMapper employeeMapper;

	@Autowired
	private TbDeptMapper deptMapper;

	@Autowired
	private TbJobMapper jobMapper;

	@Override
	public PageBean<TbEmployee> selectEmployee(Map<String, Object> map) {

		List<TbEmployee> employees;
		TbEmployeeExample example = new TbEmployeeExample();

		if (map != null && !map.isEmpty()) {// 全部查询
			employees = employeeMapper.selectByExample(example);
		} else {
			Integer did = (Integer) map.get("did");
			Integer jid = (Integer) map.get("jid");
			String name = (String) map.get("name");
			String gender = (String) map.get("gender");
			String phone = (String) map.get("phone");
			String cardid = (String) map.get("cardid");

			// 按条件查询
			Criteria criteria = example.createCriteria();
			if (did != null) {// 按部门查询
				if (jid != null) {// 按职位查询
					criteria.andDidEqualTo(did).andJidEqualTo(jid).andNameLike("%" + name + "%")
							.andCardidLike("%" + cardid + "%").andPhoneLike("%" + phone + "%")
							.andGenderEqualTo(Integer.valueOf(gender));
				} else {
					criteria.andDidEqualTo(did).andNameLike("%" + name + "%").andCardidLike("%" + cardid + "%")
							.andPhoneLike("%" + phone + "%").andGenderEqualTo(Integer.valueOf(gender));
				}
			} else {// 不按部门查询
				if (jid != null) {// 按职位查询
					criteria.andJidEqualTo(jid).andNameLike("%" + name + "%").andCardidLike("%" + cardid + "%")
							.andPhoneLike("%" + phone + "%").andGenderEqualTo(Integer.valueOf(gender));
				} else {
					criteria.andNameLike("%" + name + "%").andCardidLike("%" + cardid + "%")
							.andPhoneLike("%" + phone + "%").andGenderEqualTo(Integer.valueOf(gender));
				}
			}

			employees = employeeMapper.selectByExample(example);
		}

		// 管理查询部门表和职位表
		for (TbEmployee empl : employees) {
			// 关联部门信息
			TbDept dept = deptMapper.selectByPrimaryKey(empl.getDid());
			if (dept != null) {
				empl.setDept(dept);
			}

			// 关联职位信息
			TbJob job = jobMapper.selectByPrimaryKey(empl.getJid());
			if (job != null) {
				empl.setJob(job);
			}
		}

		PageBean<TbEmployee> bean = new PageBean<>();
		bean.setRows(employees);
		bean.setTotal(employees.size());

		return bean;
	}

	@Override
	public boolean addEmployee(TbEmployee employee) {
		try {
			// 多表关联...
			TbJob job = jobMapper.selectByPrimaryKey(employee.getJid());
			employee.setJob(job);

			TbDept dept = deptMapper.selectByPrimaryKey(employee.getDid());
			employee.setDept(dept);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createdate = format.parse(format.format(new Date()));
			employee.setCreatedate(createdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return employeeMapper.insertSelective(employee) > 0;
	}

	@Override
	public TbEmployee findById(Integer id) {

		return employeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateEmployee(TbEmployee employee) {

		// 关联修改部门表和员工表
		employee.setDept(deptMapper.selectByPrimaryKey(employee.getDid()));
		employee.setJob(jobMapper.selectByPrimaryKey(employee.getJid()));

		return employeeMapper.updateByPrimaryKeySelective(employee) > 0;
	}

	@Override
	public void removeOne(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeMore(Integer[] ids) {
		TbEmployeeExample example = new TbEmployeeExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		employeeMapper.deleteByExample(example);
	}

}
