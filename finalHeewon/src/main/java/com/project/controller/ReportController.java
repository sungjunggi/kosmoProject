package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.IReportDAO;

@Controller
public class ReportController {

	@Autowired
	IReportDAO dao; //다오다옹 라이옹
	
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";
	}
	
	@RequestMapping("/report")
	public String userlist(Model model) {
		model.addAttribute("list", dao.listDAO());
		return "report";
	}
	
	@RequestMapping("/write")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/writing")
	public String write(HttpServletRequest req, Model model) {
		dao.writeDAO(req.getParameter("writer"), req.getParameter("title"), req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String detailView(HttpServletRequest req, Model model) {
		String uId = req.getParameter("id");
		model.addAttribute("dto", dao.viewDAO(uId));
		return "view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		dao.deleteDAO(req.getParameter("id"));
		return "redirect:list";
	}
}
