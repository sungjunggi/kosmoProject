package com.hrm.finalpj.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrm.finalpj.dao.IAttendanceDao2;

@Controller
public class AttendanceController {
	
	@Autowired IAttendanceDao2 dao;
//	@ResponseBody
	@RequestMapping("/attMain")
	public String attMain(Model model, HttpServletRequest req, Principal principa) {
		model.addAttribute("defaultList",dao.defaultList());
		String name = principa.getName();
		String atten = req.getParameter("atten");
		String exist = req.getParameter("exist");
		int num = dao.getNum(name);
	
		
		model.addAttribute("todayWorkCount",dao.todayWorkCount());
		model.addAttribute("scheduleWorkCount",dao.scheduleWorkCount());
		model.addAttribute("beforeWorkCount",dao.beforeWorkCount());
		model.addAttribute("notWorkCount",dao.notWorkCount());
		model.addAttribute("lateWorkCount",dao.lateWorkCount());
		model.addAttribute("leftEarlierCount",dao.leftEarlierCount());
		model.addAttribute("businessTripCount",dao.businessTripCount());
		model.addAttribute("vacationCount",dao.vacationCount());
		model.addAttribute("educationCount",dao.educationCount());
		model.addAttribute("etcCount",dao.etcCount());
		model.addAttribute("noScheduleCount",dao.noScheduleCount());
		model.addAttribute("defaultCount",dao.defaultCount());
		double rate1=dao.todayWorkCount();
		double rate2=dao.scheduleWorkCount();
		double average=rate1/rate2*100;
		String average2 = String.format("%.1f", average);
		if(rate2==0)
			average2="-";
		model.addAttribute("average",average2);
		if(atten != null) {
			if(dao.check(num) == null) {
			dao.atten(num);
			System.out.println("출근");
			}
		};
		if(exist != null) {
			dao.exist(num);
			System.out.println("퇴근");
		};
		
		return "attendence/attendance";
	}
	
	@RequestMapping("/attMain/{name}")
	public String attMain(@PathVariable("name") String name, Model model) {
		model.addAttribute("todayWorkCount",dao.todayWorkCount());
		model.addAttribute("scheduleWorkCount",dao.scheduleWorkCount());
		model.addAttribute("beforeWorkCount",dao.beforeWorkCount());
		model.addAttribute("notWorkCount",dao.notWorkCount());
		model.addAttribute("lateWorkCount",dao.lateWorkCount());
		model.addAttribute("leftEarlierCount",dao.leftEarlierCount());
		model.addAttribute("businessTripCount",dao.businessTripCount());
		model.addAttribute("vacationCount",dao.vacationCount());
		model.addAttribute("educationCount",dao.educationCount());
		model.addAttribute("etcCount",dao.etcCount());
		model.addAttribute("noScheduleCount",dao.noScheduleCount());
		model.addAttribute("defaultCount",dao.defaultCount());
		double rate1=dao.todayWorkCount();
		double rate2=dao.scheduleWorkCount();
		double average=rate1/rate2*100;
		String average2 = String.format("%.1f", average);
		if(rate2==0)
			average2="-";
		model.addAttribute("average",average2);
		if(name=="att") {
			model.addAttribute("defaultList",dao.defaultList());
		}
		model.addAttribute("defaultList",dao.defaultList());
		return "attendence/attendance";
	}
	
	
}
