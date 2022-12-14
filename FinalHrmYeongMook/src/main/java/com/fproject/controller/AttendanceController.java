package com.fproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fproject.service.AttendanceService;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
}
