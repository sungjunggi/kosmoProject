package com.hrm.finalpj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.hrm.finalpj.service.HrmTableService;

@RestController
public class HrmMainController {
	
	@Resource
	private HrmTableService hrmtableService;
	
	@RequestMapping(value="list")
	public ModelAndView AllListView(Map<String, Object> map) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> AllList = hrmtableService.SelectAllList();
		System.out.println(AllList);
		
		
		mav.addObject("Alllist", AllList);
		mav.setViewName("list");
		return mav;
	}

}
