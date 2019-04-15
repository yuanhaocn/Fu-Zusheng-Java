package com.syc.mvc;

import java.util.List;

/*
 * json到底是什么格式,取决于JavaBean怎么设计?
 */
public class Movies {

	private String retcode;
	private String retdesc;

	private List<Movie> list;

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getRetdesc() {
		return retdesc;
	}

	public void setRetdesc(String retdesc) {
		this.retdesc = retdesc;
	}

	public List<Movie> getList() {
		return list;
	}

	public void setList(List<Movie> list) {
		this.list = list;
	}

}
