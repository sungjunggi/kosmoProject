package com.hrm.finalpj.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.finalpj.dao.EmployeeDAO;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDAO dao;
	
	public void write(HttpServletRequest req) {
		String EMPNUM = req.getParameter("EMPLOYEE_NUM");
		String EMPID = req.getParameter("EMPLOYEE_ID");
		String EMPPW = req.getParameter("EMPLOYEE_PASSWORD");
		String EMPNAME = req.getParameter("EMPLOYEE_NAME");
		String EMPPHONE = req.getParameter("EMPLOYEE_PHONE");
		String EMPADD = req.getParameter("EMPLOYEE_ADDRESS");
		String EMPTYPE = req.getParameter("EMPLOYEE_TYPE");
		String EMPDATE = req.getParameter("EMPLOYEE_DATE");
		String EMPQUITDATE = req.getParameter("EMPLOYEE_QUITDATE");
		String EMPDEPNUM = req.getParameter("DEPARTMENT_NUM");
		String EMPPICTURE = req.getParameter("EMPLOYEE_PICTURE");
		String EMPGENDER = req.getParameter("EMPLOYEE_GENDER");
		String EMPEMAIL = req.getParameter("EMPLOYEE_EMAIL");
		String DEPTNUM = req.getParameter("DEPARTMENT_NUM");
		String DEPTNAME = req.getParameter("DEPARTMENT_NAME");
		String DEPTJOB = req.getParameter("JOB_NUM");
		String DEPTPOS = req.getParameter("POSITION_NUM");
		String MEMID = req.getParameter("ID");
		String MEMADD = req.getParameter("ADDRESS");
		String MEMEMAIL = req.getParameter("EMAIL");
		String MEMNAME = req.getParameter("JOB_NAME");
		String MEMPW = req.getParameter("PASSWOARD");
		String MEMROLE = req.getParameter("ROLE");
		String POSNAME = req.getParameter("POSITION_NAME");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("EMPLOYEE_NUM", EMPNUM);
		map.put("EMPLOYEE_ID", EMPID);
		map.put("EMPLOYEE_PASSWORD", EMPPW);
		map.put("EMPLOYEE_NAME", EMPNAME);
		map.put("EMPLOYEE_PHONE", EMPPHONE);
		map.put("EMPLOYEE_ADDRESS", EMPADD);
		map.put("EMPLOYEE_TYPE", EMPTYPE);
		map.put("EMPLOYEE_DATE", EMPDATE);
		map.put("EMPLOYEE_QUITDATE", EMPQUITDATE);
		map.put("DEPARTMENT_NUM", EMPDEPNUM);
		map.put("EMPLOYEE_PICTURE", EMPPICTURE);
		map.put("EMPLOYEE_GENDER", EMPGENDER);
		map.put("EMPLOYEE_EMAIL", EMPEMAIL);
		map.put("DEPARTMENT_NUM", DEPTNUM);
		map.put("DEPARTMENT_NAME", DEPTNAME);
		map.put("JOB_NUM", DEPTJOB);
		map.put("ID", MEMID);
		map.put("ADDRESS", MEMADD);
		map.put("EMAIL", MEMEMAIL);
		map.put("POSITION_NUM", DEPTPOS);
		map.put("JOB_NAME", MEMNAME);
		map.put("PASSWOARD", MEMPW);
		map.put("ROLE", MEMROLE);
		map.put("POSITION_NAME", POSNAME);

		int res = dao.writeDAO(map);
	}

	
	
}
