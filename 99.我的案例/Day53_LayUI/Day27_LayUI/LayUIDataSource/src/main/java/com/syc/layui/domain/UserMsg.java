package com.syc.layui.domain;

import java.util.List;

public class UserMsg {

	private Integer code;
	private String msg;
	private Long count;

	private List<Msg> data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<Msg> getData() {
		return data;
	}

	public void setData(List<Msg> data) {
		this.data = data;
	}

}
