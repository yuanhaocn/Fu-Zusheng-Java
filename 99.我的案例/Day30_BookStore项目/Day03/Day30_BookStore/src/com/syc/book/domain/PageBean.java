package com.syc.book.domain;

import java.util.List;

/**
 * 单独的分页用的JavaBean
 * 
 * @类名称:PageBean
 * @创建人:SYC
 * @创建时间:2017年8月7日 下午2:18:48
 */
public class PageBean {

	private int totalCount;// 图书总数量
	private int totalPage;// 总页数
	private int pageSize;// 每页的数量
	private int currentPage;// 当前页
	private String category;// 图书分类
	private List<Book> books;// 封装每一页的图书信息

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
