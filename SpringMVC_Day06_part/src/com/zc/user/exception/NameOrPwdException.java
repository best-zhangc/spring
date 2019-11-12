package com.zc.user.exception;

/**
 * 用户名或密码错误
 * @author zhangchao
 *
 */
public class NameOrPwdException extends Exception{
	public NameOrPwdException() {
		
	}
	
	public NameOrPwdException(String message) {
		super(message);
	}

	public NameOrPwdException(Throwable cause) {
		super(cause);
	}
	
	public NameOrPwdException(String message , Throwable cause) {
		super(message , cause);
	}
}
