package org.tarena.dao;

import java.util.List;


import org.tarena.entity.Emp;

public interface EmpDao {
	public List<Emp> findAll(); //查全部
	public void save(Emp emp) ; //增
	public void update(Emp emp) ; //改
	public void delete(int empno) ; //删
	public Emp getByempno(int empno);//根据empno查信息
}
