package com.kimhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
	
	@GetMapping("/todo")
	public String todoMain() {
		return "TodoMain";
	}
}
