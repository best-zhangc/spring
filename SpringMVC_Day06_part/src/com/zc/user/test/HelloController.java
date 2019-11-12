package com.zc.user.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring")
public class HelloController {
	@RequestMapping("/hello.form")
	public String  execute() throws Exception{
		System.out.println("执行HelloController");
		return "hello" ;
	}
}
