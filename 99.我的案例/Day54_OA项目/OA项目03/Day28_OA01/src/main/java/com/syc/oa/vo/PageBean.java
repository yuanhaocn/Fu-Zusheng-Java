package com.syc.oa.vo;

import java.util.List;

/**
 * 进行分页的JavaBean
 * 
 * @类名称:PageBean
 * @创建人:一一哥
 * @创建时间:2017年12月20日 下午3:17:49
 */
public class PageBean<T> {

	private long total;// 总数量
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
