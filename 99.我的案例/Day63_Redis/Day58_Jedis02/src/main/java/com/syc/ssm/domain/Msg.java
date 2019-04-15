package com.syc.ssm.domain;

public class Msg {

	private Integer id;
	private String msg;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[id]=" + id + ",[name]=" + name + ",[msg]=" + msg;
	}

}
