package com.syc.oa.domain;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class TbJob {
	private Integer id;

	private String name;

	private String remark;

	@OneToMany(mappedBy = "job", targetEntity = TbEmployee.class, fetch = FetchType.EAGER)
	private Set<TbEmployee> employees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Set<TbEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<TbEmployee> employees) {
		this.employees = employees;
	}

}