package com.zc.user.test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.user.bean.User;
import com.zc.user.jdbc.JdbcDataSource;
import com.zc.user.service.UserService;

public class TestCause {
	@Test
	public void testUserService() throws Exception{
		String conf = "spring-mvc.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Properties obj = ac.getBean("jdbcProps" , Properties.class) ;
		JdbcDataSource ds = ac.getBean("jdbcDataSource", JdbcDataSource.class) ;
		System.out.println(obj);
		System.out.println(ds);
		System.out.println(ds.getConnection());
		UserService service = ac.getBean("userService", UserService.class);
		User user = service.login("Tom", "123") ;
		System.out.println(user);
	}
}
