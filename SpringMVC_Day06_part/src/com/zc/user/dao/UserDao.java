package com.zc.user.dao;

import com.zc.user.bean.User;

/**
 *  用户数据访问对象接口
 * @author zhangchao
 *
 */
public interface UserDao{
	/** 根据唯一用户名查询系统用户 没有找到用户信息返回Null	 */
	public User findByName(String name);
}
