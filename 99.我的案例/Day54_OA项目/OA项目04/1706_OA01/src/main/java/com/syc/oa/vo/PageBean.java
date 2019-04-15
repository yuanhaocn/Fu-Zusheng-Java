package com.syc.oa.vo;

import java.util.List;

/**
 * 分页用的JavaBean
 * 
 * @类名称:PageBean
 * @创建人:一一哥
 * @创建时间:2018年2月28日 上午10:54:39
 */
public class PageBean<T> {

	private long total;// 条目的总数量
	private List<T> rows;// 数据的集合

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
