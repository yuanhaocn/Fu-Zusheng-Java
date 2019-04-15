package com.syc.book.exception;

/**
 * 自定义异常
 * @类名称:UserException
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:48:25
 */
public class UserException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}

	public UserException(String msg) {
		super(msg);
	}
	
	public UserException(Throwable tr) {
		super(tr);
	}
	
	public UserException(String msg,Throwable tr) {
		super(msg,tr);
	}
	
}
