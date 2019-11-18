package org.tarena.web;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.tarena.dao.EmpDao;
import org.tarena.entity.Emp;

@Controller
@RequestMapping("/emp/")
public class EmpListController {
	private EmpDao empDao ;

	@Autowired
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	/**
	 * 查询全部员工
	 * @author zhangchao
	 */
	@RequestMapping("list.do")
	public String execute(Model model) {
		List<Emp> list = empDao.findAll();
		model.addAttribute("emps", list);
		return "emp_list" ;
	}
	
	/**
	 * 添加员工 跳转addEmp.jsp
	 * @author zhangchao
	 */
	@RequestMapping("add.do")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("addEmp");
		mv.addObject("emp" , new Emp()) ;
		return mv;
	}
	
	/**
	 * 添加回显
	 * @author zhangchao
	 */
	@RequestMapping(value = "/addEmp.do")
	public String addEmp(Emp emp) {
		empDao.save(emp);
		System.out.println("************姓名="+emp.getEname());
		return "redirect:/emp/list.do";
	}
	
    
	/**
	 * 根据员工编号删除员工
	 * @param empno
	 * @author zhangchao
	 */
    @RequestMapping("delete.do")
    public String deleteEmp(int empno) {
    	System.out.println("************编号="+ empno);
    	 empDao.delete(empno);
		return "redirect:/emp/list.do";
    } 
    
    /**
     * 根据编号查询员工
     * 跳转modify.jsp
     * @author zhangchao
     */
    @RequestMapping("modify.do")
    public ModelAndView getByempno(int empno) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("modify");
    	mv.addObject("emp", empDao.getByempno(empno));
		return mv;	
    }
    
    /**
     * 修改 
     * 重定向到emp_list页面
     * @author zhangchao
     * @param emp
     */
    @RequestMapping("update.do")
    public String updateEmp(Emp emp) {
    	System.out.println("----------------==="+emp.getEname());
    	System.out.println(emp.toString());
    	empDao.update(emp);
		return "redirect:/emp/list.do";	
    }
}
