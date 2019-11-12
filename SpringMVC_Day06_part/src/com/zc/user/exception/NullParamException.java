package com.zc.user.exception;

/**
 * 参数为空
 * @author zhangchao
 *
 */
public class NullParamException extends Exception{
	public NullParamException() {
		
	}
		
	public NullParamException(String message) {
			super(message) ;	
			}
	public NullParamException(Throwable cause) {
		super(cause) ;
	}
	public NullParamException(String message , Throwable cause) {
		super(message , cause) ;
		
	}
}
