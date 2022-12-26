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
	   public String getvacationlist(Model model, Principal principal) {
		vacationDTO dto = new vacationDTO();
		int num = vmap.numDAO(principal.getName());
		model.addAttribute("vacationlist", vmap.vacationList(dto,num));
		int total = vmap.vacationTotal();
		model.addAttribute("total",total);
		model.addAttribute("num",num);
		return "vacation/vacationList";
	   }
	
	@GetMapping("/vacationWrite")
	   public String writeForm() {
	      return "vacation/vacationwriteForm";
	   }
	
	@PostMapping("/vacationWriting")
		public String writing(HttpServletRequest req,Principal principal) {
		String vac = req.getParameter("vacation");
		String sta = req.getParameter("start");
		String end = req.getParameter("end");
		String sta1 = sta.substring(0,10);
		String sta2 = sta.substring(11);
		String sta3 = sta1+"/"+sta2;
		String end1 = end.substring(0,10);
		String end2 = end.substring(11);
		String end3 = end1+"/"+end2;
		String rea = req.getParameter("reason");
		int num = vmap.numDAO(principal.getName());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("vacation", vac);
		map.put("start", sta3);
		map.put("end", end3);
		map.put("reason", rea);
		map.put("num", num);
		vmap.vacationWriteDAO(map);
		
		return "redirect:vacationlist";
	}
	   
}
