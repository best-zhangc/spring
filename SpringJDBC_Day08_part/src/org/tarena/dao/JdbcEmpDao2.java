package org.tarena.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.tarena.entity.Emp;
import org.tarena.entity.EmpMapper;

public class JdbcEmpDao2 implements EmpDao {
	private JdbcTemplate template ;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override 
	public void save(Emp emp) {
		String sql = "insert into t_emp(empno , ename , job , mgr , hiredate , sal , comm , deptno)"
				+ "values(? , ? , ? , ? , ? , ? , ? , ?)" ;
		Object [] params = {
			emp.getEmpno() ,
			emp.getEname() ,
			emp.getJob() ,
			emp.getMgr() ,
			emp.getHiredate() ,
			emp.getSal() ,
			emp.getComm() ,
			emp.getDeptno()
		};
		template.update(sql, params) ;
	}

	@Override
	public void update(Emp emp) {
		String sql = "update t_emp set ename = ? , job = ? , mgr = ? , hiredate = ? , sal = ? , comm = ? , deptno = ?"
				+ "where empno = ?" ;
		Object [] params = {
			emp.getEname(),
			emp.getJob() ,
			emp.getMgr() ,
			emp.getHiredate() ,
			emp.getSal() ,
			emp.getComm() ,
			emp.getDeptno(),
			emp.getEmpno()
		};
		template.update(sql, params) ;
	}

	@Override
	public void delete(int no) {
		String sql = "delete from t_emp where empno = ?" ;
		Object [] params = {no};
		template.update(sql, params) ;

	}

	@Override
	public Emp findByNo(int no) {
		String sql = "select * from t_emp where empno = ?" ;
		Object [] params = {no};
		RowMapper<Emp> mapper = new EmpMapper() ;
		Emp emp = template.queryForObject(sql, params, mapper) ;
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select * from t_emp" ;
		RowMapper<Emp> mapper = new EmpMapper() ;
		List<Emp> list = template.query(sql, mapper) ;
		return list;
	}

}
