package org.tarena.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;

public class Test1 {

	public static void main(String[] args) throws Exception{
		String conf = "applicationContext.xml" ;
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf) ;
		EmpDao empDao = ac.getBean("jdbcEmpDao1", EmpDao.class) ;
		List<Emp> list = empDao.findAll();
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + "  " + emp.getEname());
		}
	}

}
