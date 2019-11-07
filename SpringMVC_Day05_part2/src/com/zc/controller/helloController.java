package com.zc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zc.bean.city;

	/**
	 * 注解
	 * @author zhangchao
	 *
	 */
	@Controller
	@RequestMapping("/day01")
	public  class helloController {
		@RequestMapping("/hello.form")
		public String execute() throws Exception{
			return "hello";
			
		}
		@RequestMapping("/city.form")
		public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
			List<city> list = new ArrayList<city>();
			city city1 = new city(1001, "深圳");
			city city2 = new city(1002, "上海");
			city city3 = new city(1003, "北京");			
			list.add(city1);
			list.add(city2);
			list.add(city3);
			ModelAndView mv = new ModelAndView("city");
			mv.addObject("list", list);
			return mv;
			
		}
	
	
}
