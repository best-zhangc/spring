package org.tarena.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Emp;
import org.tarena.entity.EmpMapper;


@Repository
public class JdbcEmpDao implements EmpDao{
	
	private JdbcTemplate template ;	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	
	
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Emp> findAll() {
		String sql = "select * from t_emp" ;
		RowMapper<Emp> mapper = new EmpMapper();
		List<Emp> list = template.query(sql, mapper) ;
		return list ;
	}

	/**
	 * 添加
	 * @return
	 */
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
		template.update(sql, params) ;	
	}
	
	/**
	 * 根据empno查询信息
	 * @return
	 */
	@Override
	public Emp getByempno(int empno) {
		String sql = "select * from t_emp where empno =?" ;
		Object [] params = {empno};
		RowMapper<Emp> mapper = new EmpMapper();
		Emp emp = template.queryForObject(sql, params, mapper) ;
		return emp;
	}

	/**
	 * 修改
	 * @return
	 */
	@Override
	public void update(Emp emp) {
		String sql = "update t_emp set ename = ? , job = ? , mgr = ? , hiredate = ? , sal = ? , comm= ? , deptno=? "
				+ "where empno = ?" ;
		Object [] params = {
				emp.getEname(),
				emp.getJob() ,
				emp.getMgr() ,
				emp.getHiredate() ,
				emp.getSal() ,
				emp.getComm() ,
				emp.getDeptno() ,
				emp.getEmpno() 	
		};
		System.out.println("**********************="+emp.getEname());
		template.update(sql, params) ;
		System.out.println("======================="+template.update(sql, params));
	}

	/**
	 * 删除
	 * @return
	 */
	@Override
	public void delete(int empno) {
		String sql = "delete from t_emp where empno = ?" ;
		Object [] params = {empno};
		 template.update(sql, params);
		
		
	}

}
