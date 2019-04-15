package com.syc.manager.vo;

/**
 * 自定义枚举类 特点:1.每个属性值都对应着一个整数值; 2.构造方法私有化;
 * 
 * @类名称:ResponseStatus
 * @创建人:一一哥
 * @创建时间:2018年3月13日 上午11:33:54
 */
public enum ResponseStatus {

	ERROR(0), SUCCESS(1), LOGIN(2);

	private int code;

	private ResponseStatus(int code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(this.code);
	}
	
}
