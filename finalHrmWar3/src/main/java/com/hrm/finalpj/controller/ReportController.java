package com.hrm.finalpj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dao.IReportDAO;

@Controller
public class ReportController {

	@Autowired
	IReportDAO dao; //
	
	@GetMapping("/reportlist")
	public String userlist(Model model) {
		model.addAttribute("list", dao.listDAO());
		model.addAttribute("select", dao.selectDAO());
		return "report/reportlist";
	}
	
	
	@RequestMapping("/reportview/{num}")
	public String detailView(@PathVariable("num") String num,  Model model) {
		model.addAttribute("view", dao.viewDAO(num));
		return "report/reportview";
	}
	
	@RequestMapping("/templateselect")
	public String selectTemplate(Model model) {
		model.addAttribute("select", dao.selectDAO());
		return "report/templateselect";
	}
	
	@RequestMapping("/templateview/{tnum}")
	public String viewTemplate(@PathVariable("tnum") String tnum, Model model) {
		model.addAttribute("template", dao.templateDAO(tnum));
		return "report/reportwrite";
	}
	
	@RequestMapping("/addtemplate")
	public String addTemplate(HttpServletRequest req, Model model) {
		dao.addDAO(req.getParameter("num"), req.getParameter("writer"), req.getParameter("title"));
		return "redirect:reportlist";
	}
	
	@RequestMapping("/writereport")
	public String writeReport(Model model, HttpServletRequest req) {
	
		String answer1 = req.getParameter("answer1");
		String answer2 = req.getParameter("answer2");
		String answer3 = req.getParameter("answer3");
		int answer4 = Integer.parseInt(req.getParameter("answer4"));
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
		dao.writeDAO(answer1, answer2, answer3, answer4);
		
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
