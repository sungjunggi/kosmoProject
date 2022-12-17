package com.hrm.finalpj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dao.IReportDAO;
import com.hrm.finalpj.report.dto.ReportDTO;

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
	
	@PostMapping("/reportlist")
	public String userlist2(Model model, HttpServletRequest req) {
		
		ReportDTO dto = new ReportDTO();
	
		dto.setGettemplate_num(Integer.parseInt(req.getParameter("gettemplate_num")));
		dto.setTemplate_board_answer1(req.getParameter("answer1")); 
		dto.setTemplate_board_answer2(req.getParameter("answer2")); 
		dto.setTemplate_board_answer3(req.getParameter("answer3")); 
		dto.setTemplate_board_answer4(req.getParameter("answer4")); 
		dto.setTemplate_board_answer5(req.getParameter("answer5")); 
		dto.setTemplate_board_answer6(req.getParameter("answer6")); 
		dto.setTemplate_board_answer7(req.getParameter("answer7")); 
		
		if(Integer.parseInt(req.getParameter("gettemplate_num")) == 1) {
			dao.writeDAO1(dto);
		} else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 2) {
			dao.writeDAO2(dto);
		} else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 3) {
			dao.writeDAO3(dto);
		}
		
		return "redirect:reportlist";
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
	
//	@PostMapping("/writereport")
//	public String writeReport(Model model, HttpServletRequest req){
//		
//		int gtnum = Integer.parseInt(req.getParameter("gtnum"));
//		int emnum = Integer.parseInt(req.getParameter("emnum"));
//		int fnum = Integer.parseInt(req.getParameter("fnum"));
//		
//		String answer1 = req.getParameter("answer1");
//		String answer2 = req.getParameter("answer2");
//		String answer3 = req.getParameter("answer3");
//		String answer4 = req.getParameter("answer4");
//		String answer5 = req.getParameter("answer5");
//		String answer6 = req.getParameter("answer6");
//		String answer7 = req.getParameter("answer7");
//		
//		System.out.println(gtnum);
//		System.out.println(emnum);
//		System.out.println(fnum);
//		System.out.println(answer1);
//		System.out.println(answer2);
//		System.out.println(answer3);
//		System.out.println(answer4);
//		System.out.println(answer5);
//		System.out.println(answer6);
//		System.out.println(answer7);
//		
////		model.addAttribute("write", dao.writeDAO(dto));
//		return "redirect:reportlist";
//	}
	
	@GetMapping("/updatereport/{num}")
	public String update(@PathVariable("num") String num, Model model) {
		model.addAttribute("update", dao.viewDAO(num));
		return "redirect:reportlist";
	}
	
	@PostMapping("/updatereport/{num}")
	public String updateReport(@PathVariable("num") String num, HttpServletRequest req) {
		
	}
	
	@RequestMapping("/deletereport")
	public String deleteReport(HttpServletRequest req, Model model) {
		dao.deleteDAO(req.getParameter("id"));
		return "redirect:reportlist";
	}
}
