package com.sample.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.service.PostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

	public final PostsService postsService;	
	
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		model.addAttribute("posts",postsService.findAllDesc());
		if(principal != null) {
			model.addAttribute("name",principal.getName());
		}
		return "index";
	}
}
