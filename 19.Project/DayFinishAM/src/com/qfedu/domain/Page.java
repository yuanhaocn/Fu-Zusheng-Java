package com.qfedu.domain;

import java.util.List;

public class Page {
	private Integer startPage;
	private Integer endPage;
	private Integer prevPage;
	private Integer nextPage;
	private List<Student> studentList;
	private Integer pageSize;
	private Integer countNumber;
	private Integer thisPage;
	// EL表达式调用的是get方法
	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		if (countNumber % pageSize == 0) {
			return countNumber / pageSize;
		}
		return countNumber / pageSize + 1;

	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getPrevPage() {
		if(thisPage==startPage) {
			return thisPage;
		}
		return thisPage-1;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	public Integer getNextPage() {
		if(thisPage==endPage) {
			return thisPage;
		}
		return thisPage+1;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCountNumber() {
		return countNumber;
		// EL表达式调用的是get方法
	}

	public void setCountNumber(Integer countNumber) {
		this.countNumber = countNumber;
	}

	public Integer getThisPage() {
		return thisPage;
	}

	public void setThisPage(Integer thisPage) {
		this.thisPage = thisPage;
	}

	@Override
	public String toString() {
		return "Page [startPage=" + getStartPage() + ", endPage=" + getEndPage() + ", prevPage=" + getPrevPage() + ", nextPage="
				+ getNextPage() + ", studentList=" + studentList + ", pageSize=" + pageSize + ", countNumber=" + countNumber
				+ ", thisPage=" + thisPage + "]";
	}
 
}
