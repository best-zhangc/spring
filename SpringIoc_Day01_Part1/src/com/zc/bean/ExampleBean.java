package com.zc.bean;

public class ExampleBean {
	 public ExampleBean() {
		 System.out.println("实列化ExampleBean");
	 }
	 
	 public void execute() {
		 System.out.println("执行ExampleBean处理");
	 }
	 
	 public void init() {
		 System.out.println("初始化ExampleBean对象");
	 }
	 
	 public void destroy() {
		 System.out.println("销毁ExampleBean对象");
	 }
	 
}
