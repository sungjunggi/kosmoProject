package com.hrm.finalpj.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.finalpj.service.IHrmTableService;
import com.hrm.finalpj.service.PostsService;

@RestController
public class HrmMainController {
	
//	@Autowired
//	private HrmHomeService homeService;
	
	public PostsService postsService;	
	
	
	private IHrmTableService hrmtableService;
	
//	@RequestMapping(value="list")
//	public ModelAndView AllListView(Map<String, Object> map) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		
//		List<Map<String, Object>> AllList = hrmtableService.SelectAllList();
//		System.out.println(AllList);
//		
//		
//		mav.addObject("Alllist", AllList);
//		mav.setViewName("list");
//		return mav;
//	}
	
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		model.addAttribute("posts",postsService.findAllDesc());
		if(principal != null) {
			model.addAttribute("name",principal.getName());
		}
		return "index";
	}

//	@GetMapping("/new2")
//	public String index(Model model) {
//
//		return "members/memberForm";
//	}

	
//	@PostMapping("/user/save")
//	public String saveUserInfo(@RequestBody HrmEmployeeDTO userVO) {
//		return homeService.InsertUser(userVO);
//	}
//	
//	@GetMapping("/")
//	public String loadExceptionPage(ModelMap model) throws Exception{
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//		return "index";
//	}
//	
//	@GetMapping("/access-denied")
//	public String loadAccessdeniedPage() throws Exception{
//		return "index";
//	}
//	

}
