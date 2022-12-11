package com.hrm.finalpj.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dto.HrmEmployeeDTO;
import com.hrm.finalpj.dto.Member;
import com.hrm.finalpj.service.MemberService;


import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	
	@GetMapping("/new")
	public String memberForm(Model model) {
		model.addAttribute("memberFormDto", new HrmEmployeeDTO());
		return "member/memberForm";
	}
	
	@PostMapping("/new")
	public String newMember(@Validated HrmEmployeeDTO memberFormDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "member/memberForm";
		}
		try {
			HrmEmployeeDTO member = Member.createMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);
		}catch(IllegalStateException e){
			model.addAttribute("errorMessage",e.getMessage());
			return "member/memberForm";
		}
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String loginMember() {
		return "/member/memberLoginForm";
	}
	
	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
		return "/member/memberLoginForm";
	}
}
