package com.zc.user.service;

import com.zc.dao.User;
import com.zc.user.dao.UserDao;

public class UserService {
	private UserDao userdao;

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public UserDao getUserdao() {
		return userdao;
	}

	/**
	 * 登录系统功能
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name , String pwd) {
		try {
			User user = userdao.findByName(name);
			if (user.getPwd().equals(pwd)) {
				return user;

			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}
