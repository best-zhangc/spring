package com.zc.user.test;

import java.sql.Connection;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.user.bean.User;
import com.zc.user.dao.JDBCDataSource;
import com.zc.user.dao.MysqlUserDao;
import com.zc.user.dao.UserDao;
import com.zc.user.service.UserService;

public class TestCase {
	
	/**
	 * 创建测试UserService组件
	 */
	@Test
	public void testUSerService() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf)	 ;
		UserService service = ac.getBean("userService", UserService.class) ;
		System.out.println(service);
		User  u = service.login("Tom", "123") ;
		System.out.println(u);
	}
	
	@Test
	public void testMysqlUserDao() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		MysqlUserDao dao = ac.getBean("userDao", MysqlUserDao.class	) ;
		User user = dao.findByName("Tom");
		System.out.println(dao);
		System.out.println(user);
	}
	
	/**
	 * 测试UserDao Bean的创建和注入
	 * 
	 */
	@Test
	public void testUserDao() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		UserDao dao = ac.getBean("userDao", UserDao.class) ;
		UserService service = ac.getBean("userService", UserService.class) ;
		//有对象输出说明Spring正确地创建了 UserDao组件
		System.out.println(dao);
		//返回true说明Spring正确地将userDao 组件注入到Service组件中
		System.out.println(dao==service.getUserDao());
		User u = service.login("Tom", "123") ;
		System.out.println(u);
	}
	
	/**
	 * 测试JDBCDataSource的创建和注入
	 */
	@Test
	public void testJDBCDataSource() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		JDBCDataSource dataSource = ac.getBean("JDBCDataSource", JDBCDataSource.class) ;
		MysqlUserDao userdao = ac.getBean("userDao", MysqlUserDao.class) ;
		//有对象输出说明Spring正确地创建了 JDBCDataSource组件
		System.out.println(dataSource);
		//返回true说明Spring正确地将JDBCDataSource 组件注入到userdao组件中
		System.out.println(dataSource==userdao.getDataSource());
		User user = userdao.findByName("Tom") ;
		//输出用户数据
		System.out.println(user);
	}
	
	/**
	 *  测试Spring表达式注入
	 */
	
	@Test
	public void testJDBCProps() throws Exception{
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		Properties props = ac.getBean("jdbcProps", Properties.class) ;
		JDBCDataSource dataSource = ac.getBean("JDBCDataSource", JDBCDataSource.class) ;
		 System.out.println(props);
		 System.out.println(dataSource.getDriver());
		 System.out.println(dataSource.getUrl());
		 System.out.println(dataSource.getUser());
		 System.out.println(dataSource.getPwd());
		 Connection conn = dataSource.getConnection();
		 System.out.println(conn);
		
	}
	
	/**
	 * 测试login方法功能
	 */
	@Test
	public void testLogin() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		UserService service = ac.getBean("userService", UserService.class);
		UserDao dao = service.getUserDao();
		System.out.println(dao);
		User user = service.login("Tom", "123") ;
		System.out.println(user);
	}
}
