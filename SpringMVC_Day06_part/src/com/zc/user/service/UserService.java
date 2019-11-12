package com.zc.user.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zc.user.bean.User;
import com.zc.user.dao.UserDao;
import com.zc.user.exception.NameOrPwdException;
import com.zc.user.exception.NullParamException;

/**
 * 业务层 注解
 * @author zhangchao
 *
 */
@Service //默认Bean ID为 userService
public class UserService implements Serializable{
	private UserDao userDao ;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource //自动匹配 userDao 对象并注入
	//@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User login(String name , String pwd) throws NameOrPwdException , NullParamException{
		if (name == null || name.equals("") || pwd == null ||pwd.equals("")) {
			throw new NullParamException("登录参数不能为空！") ;
		}
		User user = userDao.findByName(name) ;
		if (user != null && pwd.equals(user.getPwd())) {
			return user ;	
		}
		throw new NameOrPwdException("登录名或密码错误") ;
	}

}
