package com.syc.oa.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class TbUser {
	private Integer id;

	private Date createDate;

	private String loginName;

	private String password;

	private Integer status;

	private String username;

	@OneToMany(mappedBy = "user", targetEntity = TbDoc.class, fetch = FetchType.EAGER)
	private Set<TbDoc> documents;

	@OneToMany(mappedBy = "user", targetEntity = TbSign.class, fetch = FetchType.EAGER)
	private Set<TbSign> signs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public Set<TbDoc> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<TbDoc> documents) {
		this.documents = documents;
	}

	public Set<TbSign> getSigns() {
		return signs;
	}

	public void setSigns(Set<TbSign> signs) {
		this.signs = signs;
	}

}