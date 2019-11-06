package com.zc.user.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zc.user.bean.User;
/**
 * 持久层 注解
 * @author zhangchao
 *
 */

@Repository("userDao") //指特定的Bean ID方便setUserDao注入
public class MysqlUserDao implements UserDao , Serializable{
	private JDBCDataSource dataSource ;
	
	public MysqlUserDao() {
		
	}
	
	/**
	 * 创建MySQLDataSource 对象必须依赖于JDBCDataSource实列
	 * @param dataSource
	 */
	public MysqlUserDao(JDBCDataSource dataSource) {
		this.dataSource = dataSource  ; 
	}
	
	@Autowired //按照类型自动装配
	public void setDataSource(@Qualifier("JDBCDataSource")JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JDBCDataSource getDataSource() {
		return dataSource;
	}

	public User findByName(String name) {
		System.out.println("利用JDBC技术查找 User 信息");
		String sql = "select id , name , pwd , phone from stu where name = ?" ;
		Connection conn  = null ;
		try {
		 conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql) ;
		 ps.setString(1, name);
		 ResultSet rs = ps.executeQuery() ;
		 User user = null ;
		 while (rs.next()) {
			 user = new User();
			 user.setId(rs.getInt("id"));
			 user.setName(rs.getString("name"));
			 user.setPwd(rs.getString("pwd"));
			 user.setPhone(rs.getString("phone"));	
		}
		 rs.close();
		 ps.close();
		 return user; 	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			dataSource.close(conn);
		}
		
	}

}
