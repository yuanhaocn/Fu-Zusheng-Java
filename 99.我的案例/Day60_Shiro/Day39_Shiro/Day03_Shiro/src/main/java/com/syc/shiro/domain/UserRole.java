package com.syc.shiro.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "t_user_role")
@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	//@ManyToOne:表示多对一关系
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId",unique=true)
	private User user;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="roleId",unique=true)
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
