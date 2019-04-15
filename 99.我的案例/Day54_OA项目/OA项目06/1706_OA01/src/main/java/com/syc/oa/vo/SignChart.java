package com.syc.oa.vo;

/**
 * 自定义的用于图表查询的JavaBean
 * 
 * @类名称:SignChart
 * @创建人:一一哥
 * @创建时间:2018年3月7日 上午10:47:31
 */
public class SignChart {

	private String day;// 图表查询中的日期
	private long num;// 图表查询中的人数

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

}
