package com.hrm.finalpj.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hrm.finalpj.dao.EmployeeDAO;
import com.hrm.finalpj.service.EmployeeService;
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDAO dao;
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/employee")
	public String todoMain(Model model) {
		model.addAttribute("list3",dao.listDAO3());
		
		return "employee/EmployeeMain";
	}
	
	@GetMapping("/employee/{Dname}")
	public String todoMain2(@PathVariable("Dname") String Dname ,Model model) {
		int a = 0;
		for(int i=0; i<dao.deptCount(Dname).size(); i++) {
			
			 
			a = Integer.parseInt(dao.deptCount(Dname).get(i).getDept()) + a;
		}
		model.addAttribute("total",a);
		model.addAttribute("dept",dao.deptCount(Dname));
		model.addAttribute("list",dao.listDname(Dname));

		return "employee/departmentPage";
	}
	

	
	

}
