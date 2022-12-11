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
	
	@GetMapping("/report")
	public String userlist(Model model) {
		model.addAttribute("list", dao.listDAO());
		return "reportlist";
	}
	
	@RequestMapping("/view/{num}")
	public String detailView(@PathVariable("num") String num,  Model model) {
		model.addAttribute("view", dao.viewDAO(num));
		return "reportview";
	}
	
	@RequestMapping("/select")
	public String selectTemplate(Model model) {
		model.addAttribute("select", dao.selectDAO());
		return "templateselect";
	}
	
	@RequestMapping("/template/{tnum}")
	public String viewTemplate(@PathVariable("tnum") String tnum, Model model) {
		model.addAttribute("template", dao.templateDAO(tnum));
		return "reportwrite";
	}
	
	@RequestMapping("/add")
	public String addTemplate(HttpServletRequest req, Model model) {
		dao.addDAO(req.getParameter("num"), req.getParameter("writer"), req.getParameter("title"));
		return "redirect:report";
	}
	
	@RequestMapping("/write")
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
		
		return "redirect:report";
	}
	
	@RequestMapping("/update/{num}")
	public String updateView(@PathVariable("num") String num, Model model) {
		model.addAttribute("update", dao.viewDAO(num));
		return "redirect:report";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		dao.deleteDAO(req.getParameter("id"));
		return "redirect:list";
	}
}
