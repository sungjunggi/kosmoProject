package com.hrm.finalpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.hrm.finalpj.dao.IAttendanceDao2;

//@Controller
//public class AttendanceController {
//
//	
//	@Autowired IAttendanceDao2 dao;
//	
//	
//	@RequestMapping("/attMain") public String defaultAtt(Model model) {
//	model.addAttribute("totalAtt",dao.totalAtt()); return
//	"attendence/attendance"; }
//	
//
//	@RequestMapping("/attMain")
//		public String attRate1(Model model) {
//		model.addAttribute("attRate1",dao.attRate1());
//		model.addAttribute("attRate2",dao.attRate2());
//		double rate1=dao.attRate1();
//		double rate2=dao.attRate2();
//		double average = ((rate1 / rate2)*100);
//		String average2 = String.format("%.1f", average);
//		model.addAttribute("average", average2);
//		return "attendence/attendance";
//	}
//	@RequestMapping("/attMain")
//	public String alreadyAtt(Model model) {
//		model.addAttribute("alreadyAtt",dao.alreadyAtt());
//		return "attendence/attendance";
//	}
//}
