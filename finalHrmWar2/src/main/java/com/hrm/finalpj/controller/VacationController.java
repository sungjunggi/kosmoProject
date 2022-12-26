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
import com.hrm.finalpj.mapper.IVacationMapper;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.service.HrmTableService;

@Controller
public class VacationController {
	
	@Autowired
	IVacationMapper vmap;
	
	@RequestMapping("/vacationlist")
	   public String getsignlist(Model model) {
		signDTO dto = new signDTO();
		model.addAttribute("vacationlist", vmap.SelectSignList(dto));
		ReportDTO dto1 = new ReportDTO();
		model.addAttribute("vacationlist1", vmap.SelectSignList2(dto1));
		
		return "vacation/vacationList";
	   }
	
	
	
	@RequestMapping("/vacationPage/{sign_num}")
	   public String getsignpage(@PathVariable("sign_num") int sign_num, Model model,HttpServletRequest req, Principal principal) {
		String name = vmap.numDAO(principal.getName());
		model.addAttribute("name", name);
		
		signDTO dto = vmap.SelectSignPage(sign_num);
		model.addAttribute("dto", dto);
		
		String res = vmap.resDAO(sign_num);
		model.addAttribute("res", res);
		
		String approve = req.getParameter("approve");
		String deny = req.getParameter("deny");
		if(approve != null && deny == null) {
			vmap.approveDAO(sign_num);
		}else if(deny !=null && approve == null) {
			vmap.denyDAO(sign_num);
		}else {  
			model.addAttribute("dto", dto);
		}
		
	      return "vacation/vacationPage";
	   }
}
