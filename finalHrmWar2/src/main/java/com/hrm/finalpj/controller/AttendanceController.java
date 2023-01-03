package com.hrm.finalpj.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dao.IAttendanceDao2;

@Controller
public class AttendanceController {
	
	@Autowired IAttendanceDao2 dao;
	@RequestMapping("/attMain")
	public String attMain(Model model, HttpServletRequest req, Principal principa) {
		// View에서 직원 상태 분류 파라미터 전달
		String working=req.getParameter("working");
		String beforeWork=req.getParameter("beforeWork");
		String notWork=req.getParameter("notWork");
		String scheduleWork=req.getParameter("scheduleWork");
		String lateWork=req.getParameter("lateWork");
		String leftEarlier=req.getParameter("leftEarlier");
		String businessTrip=req.getParameter("businessTrip");
		String vacation=req.getParameter("vacation");
		String education=req.getParameter("education");
		String etc=req.getParameter("etc");
		String noSchedule=req.getParameter("noSchedule");
		
		String name = principa.getName();
		String atten = req.getParameter("atten");
		String exist = req.getParameter("exist");
		int num = dao.getNum(name);
		
		
		// 파라미터에 따른 표출할 list 지정
		if(working!=null) {
			model.addAttribute("list",dao.working());
		}else if(beforeWork!=null) {
			model.addAttribute("list",dao.beforeWork());
		}else if(notWork!=null) {
			model.addAttribute("list",dao.notWork());
		}else if(scheduleWork!=null) {
			model.addAttribute("list",dao.scheduleWork());
		}else if(lateWork!=null) {
			model.addAttribute("list",dao.lateWork());
		}else if(leftEarlier!=null) {
			model.addAttribute("list",dao.leftEarlier());
		}else if(businessTrip!=null) {
			model.addAttribute("list",dao.businessTrip());
		}else if(vacation!=null) {
			model.addAttribute("list",dao.vacation());
		}else if(education!=null) {
			model.addAttribute("list",dao.education());
		}else if(etc!=null) {
			model.addAttribute("list",dao.etc());
		}else if(noSchedule!=null) {
			model.addAttribute("list",dao.noSchedule());
		}else {
			model.addAttribute("list",dao.total());
		}
		
		// 직원 상태별 인원 수
		model.addAttribute("workingCount",dao.workingCount());
		model.addAttribute("beforeWorkCount",dao.beforeWorkCount());
		model.addAttribute("notWorkCount",dao.notWorkCount());
		model.addAttribute("scheduleWorkCount",dao.scheduleWorkCount());
		model.addAttribute("lateWorkCount",dao.lateWorkCount());
		model.addAttribute("leftEarlierCount",dao.leftEarlierCount());
		model.addAttribute("businessTripCount",dao.businessTripCount());
		model.addAttribute("vacationCount",dao.vacationCount());
		model.addAttribute("educationCount",dao.educationCount());
		model.addAttribute("etcCount",dao.etcCount());
		model.addAttribute("noScheduleCount",dao.noScheduleCount());
		model.addAttribute("totalCount",dao.totalCount());
		
		// 출근율 계산
		double rate1=dao.workingCount();
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
}
