package com.syc.activiti;

import java.io.Serializable;
import java.util.Date;

/*
 * 流程变量的JavaBean.
 * 必须实现序列化!
 */
public class Leave implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;// 请假人
	private String desc;// 请假原因
	private Date date;// 请假时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
