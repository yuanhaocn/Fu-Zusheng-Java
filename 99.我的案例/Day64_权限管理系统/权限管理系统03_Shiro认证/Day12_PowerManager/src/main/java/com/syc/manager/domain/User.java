package com.syc.manager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String username;

	private String password;

	private String email;

	/**
	 * 状态 0:禁用;1:正常
	 */
	private Integer status;

	private Integer createUserId;

	private String mobile;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 角色ID列表:页面展示需要
	 */
	private List<Integer> roleIdList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Integer> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Integer> roleIdList) {
		this.roleIdList = roleIdList;
	}

}
