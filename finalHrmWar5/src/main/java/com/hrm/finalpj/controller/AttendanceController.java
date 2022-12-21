package com.hrm.finalpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dao.IAttendanceDao2;

@Controller
public class AttendanceController {
	
	@Autowired
	IAttendanceDao2 dao;
	
	@RequestMapping("/attMain")
	public String defaultAtt(Model model) {
		model.addAttribute("totalAtt",dao.totalAtt());
		model.addAttribute("attRate1",dao.attRate1());
		model.addAttribute("attRate2",dao.attRate2());
		return "attendence/attendance";
	}
	
	@RequestMapping("/attRate1")
	public String attRate1(Model model) {
		model.addAttribute("attRate1",dao.attRate1());
		return "attendence/attendance";
	}
	
	@RequestMapping("/attRate2")
	public String attRate2(Model model) {
		model.addAttribute("attRate2",dao.attRate2());
		return "attendence/attendance";
	}
}
