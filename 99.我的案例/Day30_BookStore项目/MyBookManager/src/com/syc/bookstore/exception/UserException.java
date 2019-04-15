package com.syc.bookstore.exception;

/**
 * 自定义用户异常
 * @类名称:UserExcetion
 * @创建人:SYC
 * @创建时间:2017年7月1日 下午11:22:43
 */
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}

	public UserException(String msg) {
		super(msg);
	}

	public UserException(Throwable throwable) {
		super(throwable);
	}

	public UserException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
