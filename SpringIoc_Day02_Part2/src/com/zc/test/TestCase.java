package com.zc.test;

import java.sql.Connection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.dao.JDBCDataSource;
import com.zc.dao.User;
import com.zc.user.dao.UserDao;
import com.zc.user.service.UserService;

public class TestCase {
	
	/**
	 * SQL JDBC注入测试
	 * @return
	 */
	@Test
	public void testJDBCDataSource() throws Exception {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		System.out.println(ac);
		JDBCDataSource ds = ac.getBean("dataSource" , JDBCDataSource.class);
		Connection conn = ds.getconnection();
		System.out.println(conn);
	}
	
	/**
	 *  构造器参数注入
	 *  @return
	 */
	@Test
	public void testMysqlUserDao() {
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf); 
		
		//获取MysqlUserDao 的实列
		UserDao userdao = ac.getBean("userDao", UserDao.class);
		
		//查询用户对象
		User tom = userdao.findByName("Tom"); 
		
		System.out.println(tom);
		
	}
	
	/**
	 * 自动属性注入测试
	 * @return
	 */
	@Test
	public void testUserService() {
		String conf = "applicationContext.xml" ;
		ApplicationContext  ac = new ClassPathXmlApplicationContext(conf);
		
		//获取UserService实列
		UserService userService = ac.getBean("userService", UserService.class);
		
		//调用登录方法 测试自动注入结果
		User tom = userService.login("Tom", "123");
		System.out.println(tom);
	}
}
