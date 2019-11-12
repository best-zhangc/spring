package com.zc.user.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录检查拦截
 * @author zhangchao
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	/**请求处理完成后调用*/
	public void afterCompletion(HttpServletRequest req , HttpServletResponse res ,
			Object handler , Exception e) throws Exception {
		
	}
	
	/**处理器执行后调用*/
	public void postHandle(HttpServletRequest  req , HttpServletResponse res ,
			Object handler , ModelAndView mv) throws Exception{
		
	}
	
	/**处理器执行前调用*/
	public boolean preHandle(HttpServletRequest req , HttpServletResponse res ,
			Object handler ) throws Exception{
		Object user = req.getSession().getAttribute("user");
		if (user != null ) {	
			return true ;
		}
		ServletContext ctx = req.getSession().getServletContext() ;
		res.sendRedirect(ctx.getContextPath()+"/login/login-form.form");
		return false;
	}
}
