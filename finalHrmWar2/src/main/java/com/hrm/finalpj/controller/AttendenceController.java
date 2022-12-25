package com.hrm.finalpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendenceController {
	
	@GetMapping("/att")
	public String index2() {
		
		return "attendence/schedule";
	}
}
