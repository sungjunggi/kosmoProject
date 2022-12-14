package com.hrm.finalpj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.mapper.IHrmMapper;
import com.hrm.finalpj.service.HrmTableService;

@Controller
public class HrmMainController {
	
	@Autowired
	IHrmMapper imap;
	
	@Resource
	private HrmTableService hrmtableService;
	
   @RequestMapping("/")
   public String test(Model model) {
      System.out.println("guest");
      return "/test";
   }
	
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
	      return "signlist";
	   }
	
	@RequestMapping("/signpage/{sign_num}")
	   public String getsignpage(@PathVariable("sign_num") int sign_num, Model model) {
		signDTO dto = imap.SelectSignPage(sign_num);
		model.addAttribute("dto", dto);
	      return "signpage";
	   }
	
}
