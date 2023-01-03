package com.hrm.finalpj.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.finalpj.dao.IReportDAO;
import com.hrm.finalpj.dto.PageDTO;
import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.dto.signpageDTO;
import com.hrm.finalpj.mapper.IHrmMapper;
import com.hrm.finalpj.report.dto.CommentDTO;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.service.HrmTableService;

@Controller
public class HrmMainController {

	@Autowired
	IReportDAO dao; 
	
	@Autowired
	IHrmMapper imap;
	

	@Resource
	private HrmTableService hrmtableService;

	private Object IHrmMapper;

//   @RequestMapping("/")
//   public String test(Model model) {
//      System.out.println("guest");
//      return "/test";
//   }

	@RequestMapping(value = "list")
	public ModelAndView AllListView(Map<String, Object> map) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<Map<String, Object>> AllList = hrmtableService.SelectAllList();
		System.out.println(AllList);

		mav.addObject("Alllist", AllList);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping("/signlist")
	public String getsignlist(Model model, HttpServletRequest req) {
		//@RequestParam(defaultValue="1") int currentPage
		//List<signDTO> content = this.IHrmMapper.content();
		//int total = this.IHrmMapper.listCount();
		
		//model.addAttribute("list", new signpageDTO());
		//model.addAttribute("total", total);
	
		
		signDTO dto = new signDTO();
		model.addAttribute("signlist", imap.SelectSignList(dto));
		ReportDTO dto1 = new ReportDTO();
		model.addAttribute("signlist1", imap.SelectSignList2(dto1));
		signDTO dto2 = new signDTO();
		model.addAttribute("signlist2", imap.SelectSignList3(dto2));
		
		String TestDAO = req.getParameter("TestDAO");
		System.out.println(TestDAO);
	    String ReportDAO = req.getParameter("ReportDAO");
	    System.out.println(ReportDAO);
	    String DayoffDAO = req.getParameter("DayoffDAO");
	    System.out.println(DayoffDAO);
	    
	    req.setAttribute("TestDAO", TestDAO);
	    req.setAttribute("ReportDAO", ReportDAO);
	    req.setAttribute("DayoffDAO", DayoffDAO);
		
		if(TestDAO != null) {
			System.out.println("되고있음");
	    	   model.addAttribute("click",imap.TestDAO(TestDAO));
	    	   return "sign/signlist1";
	       }else if(ReportDAO != null) {
	    	   model.addAttribute("click",imap.ReportDAO(ReportDAO));
	           return "sign/signlist2";
	       }else if(DayoffDAO != null) {
	    	   model.addAttribute("click",imap.DayoffDAO(DayoffDAO));
	           return "sign/signlist3";
	       }

		return "sign/signlist";
	}

	@RequestMapping("/signpage/{sign_num}")
	public String getsignpage(@PathVariable("sign_num") int sign_num, Model model, HttpServletRequest req,
			Principal principal, Object Test1DAO) {
		String name = imap.numDAO(principal.getName());
		model.addAttribute("name", name);

		signDTO dto = imap.SelectSignPage(sign_num);
		model.addAttribute("dto", dto);

		String res = imap.resDAO(sign_num);
		model.addAttribute("res", res);

		String approve = req.getParameter("approve");
		String deny = req.getParameter("deny");
		if (approve != null && deny == null) {
			imap.approveDAO(sign_num);
		} else if (deny != null && approve == null) {
			imap.denyDAO(sign_num);
		} else {
			model.addAttribute("dto", dto);
		}

		return "sign/signpage";
	}

	@RequestMapping("/dayoffpage/{dayoff_num}")
	public String getdayoffpage(@PathVariable("dayoff_num") int dayoff_num, Model model, HttpServletRequest req) {
		signDTO dto = imap.SelectDayoffPage(dayoff_num);
		model.addAttribute("dto", dto);

		String approve = req.getParameter("approve");
		String deny = req.getParameter("deny");
		if (approve != null && deny == null) {
			imap.approveDAO1(dayoff_num);
		} else if (deny != null && approve == null) {
			imap.denyDAO1(dayoff_num);
		} else {
			model.addAttribute("dto", dto);
		}

		return "dayoff/dayoffpage";
	}
	

	 @RequestMapping("/reportviewsign/{template_board_num}") 
	 public String getreportviewsign(@PathVariable("template_board_num") int template_board_num, Model model, HttpServletRequest req,
			 Principal principal) { 
		 	signDTO dto = imap.SelectReportViewSign(template_board_num); 
		 	model.addAttribute("dto", dto);
		 
		 	String name1 = imap.numDAO1(principal.getName());
			model.addAttribute("name1", name1);

			String res1 = imap.resDAO1(template_board_num);
			model.addAttribute("res1", res1);
	 
        String approve = req.getParameter("approve");
		String deny = req.getParameter("deny");
		if (approve != null && deny == null) {
			imap.approveDAO2(template_board_num);
		} else if (deny != null && approve == null) {
			imap.denyDAO2(template_board_num);
		} else {
			model.addAttribute("dto", dto);
		}
		
		model.addAttribute("view", imap.viewDAO1(template_board_num));
		
	 
	 return "report/reportviewsign"; 
	 
	 	}

  
}
 


