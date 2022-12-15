package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.IReportDAO;
import com.project.dto.ReportDTO;
import com.project.dto.TemplateDTO;

import lombok.RequiredArgsConstructor;

@Controller
public class ReportController {

	@Autowired
	IReportDAO dao; //
	
	@GetMapping("/reportlist")
	public String userlist(Model model) {
		model.addAttribute("list", dao.listDAO());
		return "reportlist";
	}
	
	@RequestMapping("/reportview/{num}")
	public String detailView(@PathVariable("num") String num,  Model model) {
		model.addAttribute("view", dao.viewDAO(num));
		return "reportview";
	}
	
	@RequestMapping("/templateselect")
	public String selectTemplate(Model model) {
		model.addAttribute("select", dao.selectDAO());
		return "templateselect";
	}
	
	@RequestMapping("/templateview/{tnum}")
	public String viewTemplate(@PathVariable("tnum") String tnum, Model model) {
		model.addAttribute("template", dao.templateDAO(tnum));
		return "reportwrite";
	}
	
	@RequestMapping("/writereport")
	public String writeReport(Model model, HttpServletRequest req) {
	
		int gtnum = Integer.parseInt(req.getParameter("gtnum"));
		String answer1 = req.getParameter("answer1");
		String answer2 = req.getParameter("answer2");
		String answer3 = req.getParameter("answer3");
		String answer4 = req.getParameter("answer4");
		String answer5 = req.getParameter("answer5");
		String answer6 = req.getParameter("answer6");
		String answer7 = req.getParameter("answer7");
		System.out.println(gtnum);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
		System.out.println(answer5);
		System.out.println(answer6);
		System.out.println(answer7);
		dao.writeDAO(gtnum, answer1, answer2, answer3, answer4, answer5, answer6, answer7);
		
		return "redirect:reportlist";
	}
	
	@RequestMapping("/updateview/{num}")
	public String updateView(@PathVariable("num") String num, Model model) {
		model.addAttribute("update", dao.viewDAO(num));
		return "redirect:reportlist";
	}
	
	@RequestMapping("/deletereport")
	public String delete(HttpServletRequest req, Model model) {
		dao.deleteDAO(req.getParameter("id"));
		return "redirect:reportlist";
	}
}
