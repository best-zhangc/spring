package com.zc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.bean.MessageBean;

public class Test02 {

	public static void main(String[] args)  throws Exception{
			String conf = "applicationContext.xml" ;
		 	ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		 	MessageBean bean = ac.getBean("messagebean2", MessageBean.class	) ;
		 	bean.execute() ;
	}

}
