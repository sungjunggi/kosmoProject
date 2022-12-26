package com.hrm.finalpj.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.dto.vacationDTO;
import com.hrm.finalpj.mapper.IVacationMapper;

@Controller
public class VacationController {
	
	@Autowired
	IVacationMapper vmap;
	
	@RequestMapping("/vacationlist")
	   public String getvacationlist(Model model) {
		vacationDTO dto = new vacationDTO();
		model.addAttribute("vacationlist", vmap.vacationList(dto));
		int total = vmap.vacationTotal();
		model.addAttribute("total",total);
		return "vacation/vacationList";
	   }
	
	@GetMapping("/vacationWrite")
	   public String writeForm() {
	      return "vacation/vacationwriteForm";
	   }
	
	@PostMapping("/vacationWriting")
		public String writing(HttpServletRequest req) {
		String vac = req.getParameter("vacation");
		String sta = req.getParameter("start");
		String end = req.getParameter("end");
		String rea = req.getParameter("reason");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("vacation", vac);
		map.put("start", sta);
		map.put("end", end);
		map.put("reason", rea);
		vmap.vacationWriteDAO(map);
		
		return "redirect:vacationlist";
	}
	   
	  
	
	
	@RequestMapping("/vacationPage/{sign_num}")
	   public String getsignpage(@PathVariable("sign_num") int sign_num, Model model,HttpServletRequest req, Principal principal) {
		String name = vmap.numDAO(principal.getName());
		model.addAttribute("name", name);
		
		signDTO dto = vmap.SelectSignPage(sign_num);
		model.addAttribute("dto", dto);
		
		String res = vmap.resDAO(sign_num);
		model.addAttribute("res", res);
	
		model.addAttribute("dto", dto);
		
	      return "vacation/vacationPage";
	   }
}
