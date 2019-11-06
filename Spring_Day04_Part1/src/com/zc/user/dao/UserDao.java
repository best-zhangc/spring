package com.zc.user.dao;

import com.zc.user.bean.User;

/**
 * 用户数据访问对象接口
 * @author zhangchao
 *
 */
public interface UserDao {
	//根据唯一用户名查询系统用户，如果没有找到用户信息返回Null;
	public User findByName(String name);
	
	/*可扩展
	public User add(String name , String pwd ,String phone);
	public User find (int id) ;
	public User delete(int id) ;
	public  void update(User user) ;
	*/
}
