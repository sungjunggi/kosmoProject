package com.hrm.finalpj.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.mapper.IHrmMapper;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.service.HrmTableService;

@Controller
public class HrmMainController {
	
	@Autowired
	IHrmMapper imap;
	
	@Resource
	private HrmTableService hrmtableService;
	
//   @RequestMapping("/")
//   public String test(Model model) {
//      System.out.println("guest");
//      return "/test";
//   }
	
	@RequestMapping(value="list")
	public ModelAndView AllListView(Map<String, Object> map) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> AllList = hrmtableService.SelectAllList();
		System.out.println(AllList);
		
		
		mav.addObject("Alllist", AllList);
		mav.setViewName("list");
		return mav;
	}

	@RequestMapping("/signlist")
	   public String getsignlist(Model model) {
		signDTO dto = new signDTO();
		model.addAttribute("signlist", imap.SelectSignList(dto));
		ReportDTO dto1 = new ReportDTO();
		model.addAttribute("signlist1", imap.SelectSignList2(dto1));
		signDTO dto2 = new signDTO();
		model.addAttribute("signlist2", imap.SelectSignList3(dto2));
		
		return "sign/signlist";
	   }
	
	
	
	@RequestMapping("/signpage/{sign_num}")
	   public String getsignpage(@PathVariable("sign_num") int sign_num, Model model,HttpServletRequest req, Principal principal) {
		String name = imap.numDAO(principal.getName());
		model.addAttribute("name", name);
		
		signDTO dto = imap.SelectSignPage(sign_num);
		model.addAttribute("dto", dto);
		
		String res = imap.resDAO(sign_num);
		model.addAttribute("res", res);
		
		String approve = req.getParameter("approve");
		String deny = req.getParameter("deny");
		if(approve != null && deny == null) {
			imap.approveDAO(sign_num);
		}else if(deny !=null && approve == null) {
			imap.denyDAO(sign_num);
		}else {  
			model.addAttribute("dto", dto);
		}
		
	      return "sign/signpage";
	   }
	
	@RequestMapping("/dayoffpage/{dayoff_num}")
	   public String getdayoffpage(@PathVariable("dayoff_num") int dayoff_num, Model model) {
		signDTO dto = imap.SelectDayoffPage(dayoff_num);
		model.addAttribute("dto", dto);
		
		return "dayoff/dayoffpage";
	}
}
