package com.zc.user.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理  方法三 :  使用@ExceptionHandler
 * 	定义BaseController 异常处理方法
 * 使用@ExceptionHandler标注该方法
 * @author zhangchao
 *
 */

public class BaseController implements Serializable{
	@ExceptionHandler
	//@ResponseBody
	public String  execute(HttpServletRequest request , Exception ex) {
		request.setAttribute("ex", ex);
		request.setAttribute("message", ex.getMessage());
		//可根据异常类型不同返回不同视图名	
		return "error";
		
	}

}
