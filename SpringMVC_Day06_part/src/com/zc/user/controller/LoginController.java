package com.zc.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zc.user.bean.User;
import com.zc.user.exception.NameOrPwdException;
import com.zc.user.exception.NullParamException;
import com.zc.user.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Resource //请求Spring 注入资源 userService
	private UserService userService ;
	
	@RequestMapping("/login-form.form")
	public String loginform() {
		//可以向表单界面传递一些参数 
		return "login-form" ; //映射到 login-from.jsp
	}
	
	@RequestMapping("/login-action1.form")
	//Spring自动参数注入HttpServletRequest
	public String checkLogin1(HttpServletRequest  req) {
		System.out.println("----方法一--------");
		
		//异常处理  方法一： 使用SimpleMappingExceptionResolver 制造空指针异常
		String s = null ;
		s.length() ;
		
		//优点直接简洁 缺点需要自己处理数据类型转换 不支持文件上传功能
		String name = req.getParameter("name") ;
		String pwd = req.getParameter("pwd") ;
		System.out.println(name);
		System.out.println(pwd);
		try {
			User user = userService.login(name, pwd) ;
			//登陆成功将用户信息保存在当前会话中
			req.getSession().setAttribute("user", user);
			System.out.println(user);
			return "success" ; //映射到success.jsp
			
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			/*return "login-form" ;*/
			return "redirect:login-form.form"; //redirect重定向页面 信息丢失  页面不会显示 登录参数不能为空！ 
		}catch(RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
		
	}
	
	
	@RequestMapping("/login-action2.form")
	public String checkLogin2(String name , 
									@RequestParam("pwd") String password ,  //映射表单属性不同的参数
									HttpServletRequest req) {
		System.out.println("======方法二 ======");
		
		//优点：自动转换数据类型 缺点：可能出现数据类型转换异常
		System.out.println(name);
		System.out.println(password);
		
		try {
			User user = userService.login(name, password) ;
			req.getSession().setAttribute("user", user);
			System.out.println(user);
			return "success" ;
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form" ;
		} catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		}catch(RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error" ;
		}
	}
	
	@RequestMapping("/login-action3.form")
	public String checkLogin3(User user , HttpServletRequest req) {
		System.out.println("————方法三————");
		
		//自动填充到bean对象
		System.out.println(user);//输出得到的用户名和密码
		try {
			user = userService.login(user.getName()	, user.getPwd()) ;
			req.getSession().setAttribute("user", user);
			System.out.println(user); //输出数据库查询的用户信息
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form" ;
		} catch (NullParamException e) {
			e.printStackTrace();
			req.getSession().setAttribute("message", e.getMessage());
			return "login-form" ;
		}catch(RuntimeException e) {
		e.printStackTrace();
		req.getSession().setAttribute("message", e.getMessage());
		return "error" ;
		}
	}
	
	@RequestMapping("/login-action4.form")
	public ModelAndView  checkLogin4(String name , String pwd ,  HttpServletRequest req) {
		System.out.println("————方法四————");
		System.out.println("----"+name + pwd);

		Map<String , Object> data =new HashMap<String , Object>();
		try {
			User user = userService.login(name, pwd) ;
			//登录成功将用户信息保存到当前会话中
			req.getSession().setAttribute("user", user);
			return new ModelAndView("success" , data) ;
			
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			data.put("message",  e.getMessage()) ;
			return new ModelAndView("login-form" , data) ;
			
		} catch (NullParamException e) {
			e.printStackTrace();
			data.put("message", e.getMessage()) ;
			return new ModelAndView("login-form" , data) ;
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			data.put("message", e.getMessage()) ;
			return new ModelAndView("error" ,data);
		}
	}
	
	
	@RequestMapping("/login-action5.form")
	public String checkLogin5(String name , String pwd , ModelMap model , HttpServletRequest req) {
		System.out.println("————方法五————");
		try {
			User user = userService.login(name, pwd) ;
			
			//登录成功将用户信息保存到当前会话中
			req.getSession().setAttribute("user", user);
			System.out.println(user);
			return "success" ;
			
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage()) ;
			return "login-form" ;
		} catch (NullParamException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage()) ;
			return "login-form" ;
		}catch(RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage()) ;
			return "error";
		}	
	}
	
	
	@RequestMapping("/login-action6.form")
	public String checkLogin6(@ModelAttribute("user") User user ,ModelMap model , HttpServletRequest req) {
		
		System.out.println("————方法六 ————");
	
		try {
			System.out.println("name=" + user.getName() +","+ "password=" +user.getPwd());
			user = userService.login(user.getName(), user.getPwd()) ;
			req.getSession().setAttribute("user", user);
			System.out.println(user);
			return "success" ;
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			model.addAttribute("message" , e.getMessage()) ;
			return "login-form" ;
		} catch (NullParamException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage()) ;
			return "login-form" ;
		}catch(RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage()) ;
			return "error";
		}
	}
	private String [] msg = {"再来一次" , "下次就对了" , "没关系还有机会"};
	@ModelAttribute("next")
	public String getNext() {
		Random r = new Random() ;
		return msg[r.nextInt(msg.length)];
	}
}
