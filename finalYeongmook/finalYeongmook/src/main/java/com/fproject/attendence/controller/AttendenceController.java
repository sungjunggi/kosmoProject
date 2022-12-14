package com.fproject.attendence.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Mapper
public class AttendenceController {

	@RequestMapping("/")
	public String root() {
		return "btnTest";
	}
}
