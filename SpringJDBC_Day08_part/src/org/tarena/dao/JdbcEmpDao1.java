package org.tarena.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.tarena.entity.Emp;
import org.tarena.entity.EmpMapper;

public class JdbcEmpDao1 extends JdbcDaoSupport implements EmpDao{

	@Override
	public void save(Emp emp) {
		String sql = "insert into t_emp (empno , ename , job , mgr , hiredate , sal , comm , deptno)"
				+ "values(? , ? , ? , ? ,? , ? , ? , ?)" ;
		Object [] params = {
			emp.getEmpno() ,
			emp.getEname() ,
			emp.getJob() ,
			emp.getMgr() ,
			emp.getHiredate() ,
			emp.getSal() ,
			emp.getComm(),
			emp.getDeptno()
		} ;
		super.getJdbcTemplate().update(sql , params) ;
	}

	@Override
	public void update(Emp emp) {
		String sql = "updata t_emp set ename = ? , job = ? , mgr = ? , hiredate = ? , sal = ? , comm= ? , deptno=? "
				+ "where empno = ?" ;
		Object [] params = {
			emp.getEname() ,
			emp.getJob() ,
			emp.getMgr() ,
			emp.getHiredate() ,
			emp.getSal() ,
			emp.getComm() ,
			emp.getDeptno() ,
			emp.getEmpno() 		
		} ;
		super.getJdbcTemplate().update(sql	, params) ;
 		
	}

	@Override
	public void delete(int no) {
		String sql = "delete from t_emp where empno = ?" ;
		Object [] params = {no} ;
		super.getJdbcTemplate().update(sql , params) ;
	}

	@Override
	public Emp findByNo(int no) {
		String sql = "select * from t_emp where empno = ?" ;
		Object [] params = {no} ;
		RowMapper<Emp> mapper = new EmpMapper() ;
		Emp emp = super.getJdbcTemplate().queryForObject(sql, params , mapper) ;
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select * from t_emp" ;
		RowMapper<Emp> mapper = new EmpMapper();
		List<Emp> list = super.getJdbcTemplate().query(sql, mapper);
		return list;
	}

}
