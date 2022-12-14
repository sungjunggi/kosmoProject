package com.fproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fproject.dao.IScheduleDao;

@Controller
public class ScheduleController {

	@Autowired
	IScheduleDao dao;
	
	@RequestMapping("/schMain")
	public String totalSch(Model model) {
		model.addAttribute("totalList",dao.totalSch());
		return "/thymeleaf/ScheduleMain";
	}
}
