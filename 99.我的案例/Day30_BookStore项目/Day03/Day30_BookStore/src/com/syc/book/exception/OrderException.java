package com.syc.book.exception;

/**
 * 自定义的订单异常
 * 
 * @类名称:OrderException
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午11:12:03
 */
public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderException() {
		super();
	}

	public OrderException(String msg) {
		super(msg);
	}

	public OrderException(Throwable tr) {
		super(tr);
	}

	public OrderException(String msg, Throwable tr) {
		super(msg, tr);
	}

}
