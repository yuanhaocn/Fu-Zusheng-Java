package com.syc.common.pojo;

import java.util.List;

/**
 * 供其他模块调用,分页使用,类型与OA项目中的PageBean类.
 * 
 * @类名称:EasyUIDataGridResult
 * @创建人:一一哥
 * @创建时间:2017年11月9日 下午2:37:07
 */
public class EasyUIDataGridResult {

	private long total;//记录的总数量
	private List<?> rows;//分页条目的集合

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
