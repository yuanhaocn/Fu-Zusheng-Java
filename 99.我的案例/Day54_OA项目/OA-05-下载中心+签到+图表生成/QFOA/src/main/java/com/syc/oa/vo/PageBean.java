package com.syc.oa.vo;

import java.util.List;

/*
 * 用来进行分页的Bean
 */
public class PageBean<T> {

	private long total;// 数据的总数目
	private List<T> rows;// 数据集合

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
