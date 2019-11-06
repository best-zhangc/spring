package com.zc.user.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zc.user.bean.User;
import com.zc.user.dao.UserDao;

/**
 * 业务层 注解
 * @author zhangchao
 *
 */
@Scope("prototype")
@Service //默认的Bean Id是userService
public class UserService  implements Serializable{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	//@Resource //自动匹配userDao对象并注入
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 登录系统功能
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name ,String pwd) {		
		User user;
		try {
			user = userDao.findByName(name);
		if (user.getPwd().equals(pwd)) {
			return user ;
			
		}
		return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
		
	}

}
