package com.zc.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zc.dao.JDBCDataSource;
import com.zc.dao.User;

public class MysqlUserDao implements UserDao {
	
	private JDBCDataSource dataSource;
	
	/**
	 * 创建MysqlUserDao 对象必须依赖于JDBCDataSource实列
	 * @param dataSource
	 */
	public MysqlUserDao(JDBCDataSource dataSource) {
		this.dataSource = dataSource ;
	}
	
	/**
	 * 根据唯一用户名查询系统用户 ， 如果没有找到用户信息返回null
	 * @return 
	 */
	@Override
	public User findByName(String name) {
		System.out.println("利用JDBC技术查找User信息");
		String sql = "select id , name , pwd , phone from stu where name = ?";
		Connection conn = null;
		try {
		conn = dataSource.getconnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		User user = null ;
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));			
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("pwd"));
			user.setPhone(rs.getString("phone"));
		}
		rs.close();
		ps.close();
		return user ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		
	}
}
