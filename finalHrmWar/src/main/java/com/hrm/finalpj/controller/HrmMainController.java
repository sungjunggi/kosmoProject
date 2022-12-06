package com.hrm.finalpj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.finalpj.dto.HrmEmployeeDTO;
import com.hrm.finalpj.dto.HrmEmployeePrincipalVO;
import com.hrm.finalpj.service.HrmHomeService;
import com.hrm.finalpj.service.IHrmTableService;

@RestController
public class HrmMainController {
	
	@Autowired
	private HrmHomeService homeService;
	
	@Resource
	private IHrmTableService hrmtableService;
	
	@RequestMapping(value="list")
	public ModelAndView AllListView(Map<String, Object> map) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> AllList = hrmtableService.SelectAllList();
		System.out.println(AllList);
		
		
		mav.addObject("Alllist", AllList);
		mav.setViewName("list");
		return mav;
	}
	

	
	@PostMapping("/user/save")
	public String saveUserInfo(@RequestBody HrmEmployeeDTO userVO) {
		return homeService.InsertUser(userVO);
	}
	
	@GetMapping("/")
	public String loadExceptionPage(ModelMap model) throws Exception{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HrmEmployeePrincipalVO userPrincipalVO = (HrmEmployeePrincipalVO)auth.getPrincipal();
		
		model.addAttribute("name",userPrincipalVO.getUsername());
		model.addAttribute("auth",userPrincipalVO.getAuthorities());
		
		return "index";
	}
	
	@GetMapping("/access-denied")
	public String loadAccessdeniedPage() throws Exception{
		return "index";
	}
	

}
