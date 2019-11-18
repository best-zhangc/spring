package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Emp;

public interface EmpDao {
	public void save(Emp emp) ; //增
	public void update(Emp emp) ; //改
	public void delete(int no) ; //删
	public Emp findByNo(int no) ; //查
	public List<Emp> findAll(); //查
	
}
