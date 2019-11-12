package com.zc.user.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理  方法二： 自定义异常处理器 MyMappingExceptionResolver 
 * 实现HandlerExceptionResolver接口
 * @author zhangchao
 *
 */
public class MyMappingExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, 
			Object handler,Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex) ;
		
		//根据不停错误专向不同页面
		return new ModelAndView("error" , model);
	}

}
