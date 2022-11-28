package com.kimhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TodoController {
//	@Autowired
//	TodoDAO dao;
	
	@GetMapping("/todo")
	public String todoMain(Model model) {
//		model.addAttribute("list",dao.listDAO());
		return "TodoMain";
	}
	
	@GetMapping("/board")
	public String boardMain(Model model) {
		return "Board";
	}
	

}
