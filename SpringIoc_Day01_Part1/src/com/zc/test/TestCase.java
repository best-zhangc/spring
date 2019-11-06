package com.zc.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.bean.ExampleBean;

public class TestCase {

	/**
	 *  实列化Spring容器
	 */
	@Test
	public void testInitContext() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac =new ClassPathXmlApplicationContext(conf) ;
		System.out.println(ac);
	}
	
	/**测试Spring支持多种JavaBean对象创建方式*/
	@Test
	public void testCreatBeanObject() {
		//实列化Spring容器
		String conf  = "applicationContext.xml" ;
		 ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		 //1、用构造器来实列化的方式
		 //利用Spring调用构造器GregorianCalendar创建Calendar实列
		//  Calendar cal1 = (Calendar) ac.getBean("calendarObj1"); //方式1
		 	Calendar cal1 = ac.getBean("calendarObj1", Calendar.class); //方式2
		 System.out.println("Cal1: " +cal1);
		 
		 
		 //2、使用静态工厂方法实列化 的方式
		 //利用 Spring 调用 Calendar 的静态工厂方法 getInstance() 创建 Calendar 实列
		 Calendar cal2  = ac.getBean("calendarObj2" , Calendar.class);
		 System.out.println("cal2: " + cal2);
		 
		 //3、使用实列工厂方法实列化的方式
		 //利用 Spring 创建 GregorianCalendar 对象作为工厂 , 调用getTime() 方法创建Date类型对象实列
		 Date  date = ac.getBean("dateObj", Date.class);
		 System.out.println("Date: " + date);
	}
	
	@Test 
	public void testExampleBean() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ExampleBean bean1 = ac.getBean("exampleBean",ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean1==bean2);
		//关闭Spring容器 注意AbstractApplicationContext类型定义了close() 方法
		AbstractApplicationContext ctx = (AbstractApplicationContext)ac ;
		ctx.close();
	}
}
