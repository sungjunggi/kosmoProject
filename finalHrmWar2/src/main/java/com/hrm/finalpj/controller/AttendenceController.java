//package com.hrm.finalpj.controller;
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.hrm.finalpj.dto.ScheduleDTO;
//import com.hrm.finalpj.service.ScheduleServiceImp;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class AttendenceController {
//	
//	@Autowired
//	ScheduleServiceImp ScheduleService;
//	
//	@GetMapping("/att2")
//	@ResponseBody
//	public String TodayAtt(Model model, HttpServletRequest req) {
//		List<Integer> cali  = new ArrayList<>();
//
//		if(req.getParameter("year")!= null) {
//		 int year = Integer.parseInt(req.getParameter("year")); 
//		 int month =Integer.parseInt(req.getParameter("month"));
//			 
//		System.out.println(req.getParameter("year"));
//		System.out.println(req.getParameter("month"));
//
//		
//		cali = ScheduleService.day(year, month);
//		System.out.println(cali);
//		model.addAttribute("calisize",cali);
//		}
//		
//		return "/att :: #calisize";
//		
//		
//	}
//	
//	@GetMapping("/att")
//	public String index2(Model model, HttpServletRequest req) {
//		List<Integer> cali  = new ArrayList<>();
//		
//		if(req.getParameter("year")!= null) {
//			 int year = Integer.parseInt(req.getParameter("year")); 
//			 int month =Integer.parseInt(req.getParameter("month"));
//				 
//			System.out.println(req.getParameter("year"));
//			System.out.println(req.getParameter("month"));
//
//			
//			cali = ScheduleService.day(year, month);
//			model.addAttribute("calisize",cali);
//			model.addAttribute("userlist",ScheduleService.UserList()) ;
//			return "attendence/schedule";
//			
//			}
//		cali = ScheduleService.day(2022, 12);
//		model.addAttribute("calisize",cali);
//		model.addAttribute("userlist",ScheduleService.UserList()) ;
//		return "attendence/schedule";
//	}
//	
//	@GetMapping("/att/edit")
//	public String scheduleEdit(Model model) {
//		List<Integer> cali  = new ArrayList<>();
//		cali = ScheduleService.day(2022, 10);
//		System.out.println();
//		System.out.println(cali + " 사이즈좀");
//		model.addAttribute("calisize",cali);
//		model.addAttribute("userlist",ScheduleService.UserList()) ;
//		return "attendence/scheduleEdit";
//	}
//	
//	/*
//	 * @GetMapping("/att/edit") public String scheduleEdit2(Model model,
//	 * HttpServletRequest req ) { List<Integer> cali = new ArrayList<>(); int year =
//	 * Integer.parseInt(req.getParameter("year")); int month =
//	 * Integer.parseInt(req.getParameter("month")); cali = ScheduleService.day(year,
//	 * month); System.out.println(); System.out.println(cali + " 사이즈좀");
//	 * model.addAttribute("calisize",cali);
//	 * model.addAttribute("userlist",ScheduleService.UserList()) ; return
//	 * "attendence/scheduleEdit"; }
//	 */
//	
//	@GetMapping("/att/editAdd")
//	public String scheduleEditAdd(Model model) {
//		List<Integer> cali  = new ArrayList<>();
//		cali = ScheduleService.day(2022, 10);
//		System.out.println();
//		System.out.println(cali + " 사이즈좀");
//		model.addAttribute("calisize",cali);
//		model.addAttribute("userlist",ScheduleService.UserList()) ;
//		return "redirect:att";
//	}
//	
//
//	
//}