package org.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 映射类
 * @author zhangchao
 *
 */
public class EmpMapper implements RowMapper<Emp>{

	@Override
	public Emp mapRow(ResultSet rs, int rowIndex) throws SQLException {
		Emp emp = new Emp() ;
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setJob(rs.getString("job"));
		emp.setMgr(rs.getInt("mgr"));
		emp.setHiredate(rs.getDate("hiredate"));
		emp.setSal(rs.getDouble("sal"));
		emp.setComm(rs.getDouble("comm"));
		emp.setDeptno(rs.getInt("deptno"));
		return emp;
	}
	
}
