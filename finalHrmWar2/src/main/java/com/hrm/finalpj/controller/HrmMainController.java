package com.hrm.finalpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.mapper.IHrmMapper;

@Controller
public class HrmMainController {
	
	@Autowired
	IHrmMapper imap;
	

	
   @RequestMapping("/")
   public String test(Model model) {
      System.out.println("guest");
      return "/test";
   }
	


	@RequestMapping("/signlist")
	   public String getsignlist(Model model) {
		signDTO dto = new signDTO();
		model.addAttribute("signlist", imap.SelectSignList(dto));
	      return "sign/signlist";
	   }
	
	@RequestMapping("/signpage/{sign_num}")
	   public String getsignpage(@PathVariable("sign_num") int sign_num, Model model) {
		signDTO dto = imap.SelectSignPage(sign_num);
		model.addAttribute("dto", dto);
	      return "sign/signpage";
	   }
	
}
