package com.zc.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器   SomeInterceptor实现HandlerInterceptor接口
 * 及其约定方法
 * @author zhangchao
 *
 */
public class SomeInterceptor implements HandlerInterceptor{
	public void afterCompletion(HttpServletRequest req , HttpServletResponse res ,
			Object handler , Exception e) throws Exception{
		System.out.println("请求处理完成后调用");
	}
	
	public void postHandle(HttpServletRequest req , HttpServletResponse res ,
			Object handler ,ModelAndView mv) throws Exception{
		System.out.println("处理器执行后调用");
	}
	
	public boolean preHandle(HttpServletRequest req , HttpServletResponse res ,
			Object handler) throws Exception{
		System.out.println("处理器执行前调用");
				return true;
		
	}
}
