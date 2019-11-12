package com.zc.user.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zc.user.bean.User;
import com.zc.user.jdbc.JdbcDataSource;

/**
 * 持久层 注解
 * @author zhangchao
 *
 */
@Repository("userDao")  //指定特定的Bean Id 方便setuserDao 注入
public class MysqlUserDao implements UserDao , Serializable{
	private JdbcDataSource  dataSource ;
	
	public MysqlUserDao() {
		
	}
	/**创建 MysqlUserDao 必须依赖于 JDBCDataSource 实列*/
	public MysqlUserDao(JdbcDataSource dataSource) {
			this.dataSource = dataSource ;
		}
	
	public JdbcDataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired //按照类型自动装配
	public void setDataSource(@Qualifier("jdbcDataSource")JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 根据唯一用户名查询系统用户 没有找到用户信息返回null */
	public User findByName(String name) {
		System.out.println("利用 JDBC 技术查找 User 信息");
		String sql = "select id , name , pwd , phone from Users where name = ? " ;
		Connection conn = null ;
		try {
			conn = dataSource.getConnection() ;
			PreparedStatement ps = conn.prepareStatement(sql) ;
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			User user = null ;
			while (rs.next()) {
				user = new User() ;
				user.setId(rs.getInt("id"));
				user.setName(rs.getNString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
			return user ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e) ;
		}finally {
			dataSource.close(conn);
		}
	}

}
