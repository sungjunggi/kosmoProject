package com.hrm.finalpj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.Entity.Member;
import com.hrm.finalpj.dao.EmployeeDAO;
import com.hrm.finalpj.dto.EmployeeDTO;
import com.hrm.finalpj.dto.MemberFormDto;
import com.hrm.finalpj.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
   private final PasswordEncoder passwordEncoder;
   private final MemberService memberService;
   
   @Autowired
   EmployeeDAO dao;
   
   EmployeeDTO dto = new EmployeeDTO();
   
   @GetMapping("/new")
   public String memberForm(Model model) {
      model.addAttribute("memberFormDto", new MemberFormDto());
      return "member/memberForm";
   }
   
   @PostMapping("/new")
   public String newMember(@Validated MemberFormDto memberFormDto, BindingResult bindingResult, Model model, HttpServletRequest req) throws Exception{
      dto.setEMPLOYEE_NAME(memberFormDto.getName());
      dto.setEMPLOYEE_PASSWORD(memberFormDto.getPassword());
      dto.setEMPLOYEE_ADDRESS(memberFormDto.getAddress());
      dto.setEMPLOYEE_EMAIL(memberFormDto.getName());
      dto.setEMPLOYEE_PHONE(req.getParameter("phone"));
      dto.setEMPLOYEE_TYPE(req.getParameter("etype"));
      System.out.println(req.getParameter("department") + "널확인");
      dto.setDEPARTMENT_NUM(Integer.parseInt(req.getParameter("department")));
      dto.setEMPLOYEE_GENDER(req.getParameter("gender"));
      
      
      
      if(bindingResult.hasErrors()) {
         return "member/memberForm";
      }
      try {
         Member member = Member.createMember(memberFormDto, passwordEncoder);
         memberService.saveMember(member);
         dao.employeeAdd(dto);
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