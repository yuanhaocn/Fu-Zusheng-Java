package com.syc.manager.domain;

import java.io.Serializable;

public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String key;// 用来区分到底是请假还是借款
	private String bo_name;// 借款/请假人
	private String bo_money;// 借款金额/请假时间
	private String bo_reason;// 借款/请假原因
	private String assignee;// 借款/请假的经办人(办理人)

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBo_name() {
		return bo_name;
	}

	public void setBo_name(String bo_name) {
		this.bo_name = bo_name;
	}

	public String getBo_money() {
		return bo_money;
	}

	public void setBo_money(String bo_money) {
		this.bo_money = bo_money;
	}

	public String getBo_reason() {
		return bo_reason;
	}

	public void setBo_reason(String bo_reason) {
		this.bo_reason = bo_reason;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

}
