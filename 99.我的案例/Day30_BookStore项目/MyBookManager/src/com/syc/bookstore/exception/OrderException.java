package com.syc.bookstore.exception;

/**
 * 自定义订单异常
 * 
 * @类名称:OrderException
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午11:18:32
 */
public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderException() {
		super();
	}

	public OrderException(String msg) {
		super(msg);
	}

	public OrderException(Throwable throwable) {
		super(throwable);
	}

	public OrderException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
