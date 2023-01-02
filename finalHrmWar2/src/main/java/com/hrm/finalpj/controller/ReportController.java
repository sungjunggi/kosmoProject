package com.hrm.finalpj.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dao.IReportDAO;
import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.mapper.IHrmMapper;
import com.hrm.finalpj.report.dto.PageDTO;
import com.hrm.finalpj.report.dto.CommentDTO;
import com.hrm.finalpj.report.dto.Criteria;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.service.HrmTableService;
import com.hrm.finalpj.service.ReportServiceImpl;

@Controller
public class ReportController {

	@Autowired
	IReportDAO dao; 
	
	@Autowired
	IHrmMapper imap;
	
	@Resource
	private HrmTableService hrmtableService;
	
	@Autowired
	ReportServiceImpl reportservice;
	
	@GetMapping("/reportlist")
	public String report( Model model, HttpServletRequest req) {
		model.addAttribute("list", dao.listDAO());
		model.addAttribute("select", dao.selectDAO());

		return "report/reportmain";
	}
	
	@GetMapping("/reportlist/{num}")
	public String reportList(@PathVariable("num") int num, Model model, HttpServletRequest req, Principal principal) {
		
		Criteria test = new Criteria(num, 15);
		String start = req.getParameter("start");
	    String end = req.getParameter("end");
	     
	    test.setTemplate_board_start(start);
	    test.setTemplate_board_end(end);
	   
	    String myReport = req.getParameter("myReport");
	    String allReport = req.getParameter("allReport");
	    int mynum = dao.numDAO(principal.getName());
	    int myReportCount = dao.myReportCount(mynum);
	    int allReportCount = dao.allReportCount();
	    
	    req.setAttribute("myReportCount", myReportCount);
	    req.setAttribute("allReportCount", allReportCount);
	    
	    if(start!=null && end!=null) {
	    	List<Criteria> check = dao.searchDateDAO(test);
	        System.out.println(check.get(0) + "커뮤넘");
		    	if(check.get(0) == null ) {
		    		Criteria test1 = new Criteria(num,0);
		        	model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 1, test1));
		        	model.addAttribute("booleancheck",true);
		            
		        	return "report/reportmain";
		       }else {
		    	   model.addAttribute("list",dao.searchDateDAO(test));
		    	   model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 10, test));
		    	   model.addAttribute("booleancheck",false);
		       }
	    }
	    
	    if(allReport != null) {
	    	model.addAttribute("list", reportservice.getList(test));
	    
	    } else if(myReport != null) {
	    	mynum = dao.numDAO(principal.getName());
	    	model.addAttribute("list", dao.myReportDAO(mynum));
	    	model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 10, test));
	    	
	    	return "report/reportmain";
	    }
	    
	    model.addAttribute("select", dao.selectDAO());
	    model.addAttribute("list", dao.listDAO());
	    model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 10, test));
	    
		return "report/reportmain";
	 }
	
	@PostMapping("/reportlist")
	public String reportWrite(Model model, HttpServletRequest req, Principal principal) {
		ReportDTO dto = new ReportDTO();
		
		int myNum = dao.numDAO(principal.getName());
		String getName = dao.getName(myNum);
		
		dto.setGettemplate_num(Integer.parseInt(req.getParameter("gettemplate_num")));
		dto.setTemplate_board_answer1(req.getParameter("answer1"));
		dto.setTemplate_board_sign_name(req.getParameter("sign"));
		dto.setTemplate_board_start(req.getParameter("start"));
		dto.setTemplate_board_end(req.getParameter("end"));
		dto.setTemplate_board_answer4(req.getParameter("answer4"));
		dto.setTemplate_board_answer5(req.getParameter("answer5"));
		dto.setTemplate_board_answer6(req.getParameter("answer6"));
		dto.setTemplate_board_answer7(req.getParameter("answer7"));
		dto.setEmployee_num(myNum);
		dto.setEmployee_name(getName);
		
		if(Integer.parseInt(req.getParameter("gettemplate_num")) == 1) {	
			dao.writeDAO1(dto);
		
		} else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 2) {
			dao.writeDAO2(dto);
	
		} else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 3) {
			dao.writeDAO3(dto);
		
		}
		
		return "redirect:reportlist/1";
	}
	
	@RequestMapping("/reportview/{num}")
	public String detailView(@PathVariable("num") String num, Model model,HttpServletRequest req, Principal principal) {
		CommentDTO dto = new CommentDTO();
		
		dto.setTemplate_board_num(Integer.parseInt(num));
		model.addAttribute("view", dao.viewDAO(num));

		if(dao.commentReadDAO(num).get(0) != null) {
			
			model.addAttribute("commentRead", dao.commentReadDAO(num));
		}
		
		if(req.getParameter("content") != null) {
			dto.setGetcomment_content(req.getParameter("content"));
			int myNum = dao.numDAO(principal.getName());
			String getName = dao.getName(myNum);
			dto.setGetcomment_writer(getName);
			dao.commentDAO(dto);
		
			model.addAttribute("commentRead", dao.commentReadDAO(num));
			model.addAttribute("view", dao.viewDAO(num));
			
			return "redirect:"+num;
		
		} else {
			model.addAttribute("view", dao.viewDAO(num));
		}
		
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
	
	@GetMapping("/updatereport")
	public String update(Model model, HttpServletRequest req) {
		ReportDTO dto = new ReportDTO();
		
		req.getParameter("template_board_num");
		model.addAttribute("update", dao.updateDAO1(dto));
		model.addAttribute("update", dao.updateDAO2(dto));
		model.addAttribute("update", dao.updateDAO3(dto));
		
		return "report/reportview";
	}
	
	@PostMapping("/updatereport")
	public String updateReport(HttpServletRequest req) {
		ReportDTO dto = new ReportDTO();
		
		dto.setTemplate_board_num(Integer.parseInt(req.getParameter("template_board_num")));
		dto.setTemplate_board_answer1(req.getParameter("answer1")); 
		dto.setTemplate_board_sign_name(req.getParameter("sign")); 
		dto.setTemplate_board_start(req.getParameter("start"));
		dto.setTemplate_board_end(req.getParameter("end"));
		dto.setTemplate_board_answer4(req.getParameter("answer4")); 
		dto.setTemplate_board_answer5(req.getParameter("answer5")); 
		dto.setTemplate_board_answer6(req.getParameter("answer6")); 
		dto.setTemplate_board_answer7(req.getParameter("answer7"));
		
		if(Integer.parseInt(req.getParameter("gettemplate_num")) == 1) {
			dao.updateDAO1(dto);
		
		} else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 2) {
			dao.updateDAO2(dto);
		
		} else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 3) {
			dao.updateDAO3(dto);
		
		}
		
		return "redirect:reportview/"+req.getParameter("template_board_num");
	}
	
	@GetMapping("/deletereport")
	public String deleteReport(HttpServletRequest req, int template_board_num, Model model) {
		template_board_num =Integer.parseInt(req.getParameter("template_board_num"));
		dao.deleteDAO(template_board_num);
		
		return "redirect:reportlist";
	}
	
}
