package com.zc.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Scope("prototype")//输出为 False*/
@Scope("singleton") //输出为 true
public class ExampleBean {
	 public ExampleBean(){
		 System.out.println("实列化 ExampleBean");
		 
	 }
	 public void execute() {
		 System.out.println("执行 ExampleBean 处理");
	 }
	 
	 @PostConstruct 
	 public void init() {
		 System.out.println("初始化 ExampleBean 对象");
	 }
	 
	 @PreDestroy
	 public void destroy() {
		 System.out.println("销毁 ExampleBean 对象");
	 }
}
