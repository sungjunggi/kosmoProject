package com.fproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fproject.dao.IAttendanceDao;

@Controller
public class AttendanceController {
	
	@Autowired
	IAttendanceDao dao;
	
	@RequestMapping("/attMain")
	public String totalAtt(Model model) {
		model.addAttribute("totalList",dao.totalAtt());
		return "/thymeleaf/AttendanceMain";
	}
}
