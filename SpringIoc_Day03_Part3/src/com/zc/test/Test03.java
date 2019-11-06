package com.zc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.bean.ExampleBean;

public class Test03 {
	//自动组件扫描
	public static void main(String[] args) throws Exception{
		String conf = "applicationContext.xml" ;
	    ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	    ExampleBean bean = ac.getBean("exampleBean", ExampleBean.class) ;
	    bean.execute();
	}

}
