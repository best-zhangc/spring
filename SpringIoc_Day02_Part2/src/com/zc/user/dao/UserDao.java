package com.zc.user.dao;

import com.zc.dao.User;

/**
 * 用户数据访问对象接口
 * @author zhangchao
 *
 */
public interface UserDao {
	/**
	 * 根据唯一用户名查询系统用户 ， 如果没有找到用户信息返回Null
	 * @return
	 */
	public User findByName(String name);
}
