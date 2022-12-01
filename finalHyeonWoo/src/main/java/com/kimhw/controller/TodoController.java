package com.kimhw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kimhw.dao.ITodoDAO;
import com.kimhw.dto.CommunicationDTO;
import com.kimhw.service.TodoService;



@Controller
public class TodoController {
	
	@Autowired
	ITodoDAO dao;
	@Autowired
	TodoService todoservice;
	
	@GetMapping("/todo")
	public String todoMain(Model model) {
		model.addAttribute("list",dao.listDAO());
		for(CommunicationDTO i : dao.listDAO() ) {
			System.out.println(i.getCommunication_title());
		}
		return "TodoMain";
	}
	
	@GetMapping("/write")
	public String writeForm() {
		return "writeForm";
	}
	@PostMapping("/writing")
	public String write(HttpServletRequest req, Model model) {
		
		todoservice.write(req);

		return "redirect:todo"; 
	}
	
	@GetMapping("/view/{num}")
	public String detailView(@PathVariable("num") String num,HttpServletRequest req, Model model) {
		model.addAttribute("dto",dao.viewDAO(num));
		return "viewForm";
	}
	
//	@PostMapping("/test")
//	public String test() {
//		
//	}
	
	@PostMapping("/delete")
	public String delete(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		String[] str=req.getParameterValues("deleteId");
		for(String s:str) {
			System.out.println(s);
			int communication_num= Integer.parseInt(s);
			dao.deleteDAO(communication_num);
		}
		return "redirect:todo";
	}
	
	@GetMapping("/board")
	public String boardMain(Model model) {
		return "Board";
	}
	

}
