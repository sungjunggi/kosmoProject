package com.hrm.finalpj.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrm.finalpj.dao.INoticeDAO;
import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;
import com.hrm.finalpj.dto.PageDTO;
import com.hrm.finalpj.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class NoticeController {
   
   @Autowired
   INoticeDAO dao;
   @Autowired
   NoticeServiceImpl nservice;
   

    @GetMapping("notice/{num}")
    public String todoMain(@PathVariable("num") int num,Criteria criteria, Model model,HttpServletRequest req,Principal principal) {
       Criteria test = new Criteria(num,20);
       String search = req.getParameter("searchText");
       String start = req.getParameter("start");
       String end = req.getParameter("end");
       test.setCommunication_search(search);
       test.setCommunication_start(start);
       test.setCommunication_end(end);
       int totalx = 0;
       int total = nservice.ngetTotal();
       model.addAttribute("total",total);
       
       if(num%2 == 0) {
    	   totalx = total - num*10;
    	   model.addAttribute("total",totalx);
       }else if(num%3 == 0) {
    	   totalx = (total - num*10) - 10;
    	   model.addAttribute("total",totalx);
       }
       
       if(search !=null) {
          model.addAttribute("list",dao.nsearchTextDAO(test));
       }else {
          model.addAttribute("list", nservice.ngetList(test));
       }
       model.addAttribute("pageMaker", new PageDTO(nservice.ngetTotal(), 10, test));
       return "/notice/noticeMain";
    }
   
   @GetMapping("/nwrite")
   public String writeForm() {
      return "/notice/nwriteForm";
   }
   
   @PostMapping("/nwriting")
   public String write(HttpServletRequest req, Model model, Principal principal) {
      int num = dao.nnumDAO(principal.getName());
	   nservice.write(req,num);
      return "redirect:notice/1"; 
   }
   
   @GetMapping("/nview/{num}")
   public String detailView(@PathVariable("num") String num,HttpServletRequest req, Model model) {
      model.addAttribute("dto",dao.nviewDAO(num));
      return "/notice/nviewForm";
   }
   
   @PostMapping("/ndelete")
   public String delete(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
      String[] str=req.getParameterValues("deleteId");
      for(String s:str) {
         int communication_num= Integer.parseInt(s);
         dao.ndeleteDAO(communication_num);
      }
      return "redirect:notice/1";
   }
   
   @GetMapping("/nedit/{num}")
   public String editForm(@PathVariable("num") String num,Model model) {
      model.addAttribute("dto",dao.nviewDAO(num));
      return "/notice/neditForm";
   }
   
   @PostMapping("/nedit/{num}")
   public String edit(@PathVariable("num") String num, CommunicationDTO dto,HttpServletRequest req) {
      dto.setCommunication_title(req.getParameter("title"));
      dto.setCommunication_date(req.getParameter("date"));
      dto.setCommunication_content(req.getParameter("content"));
      dao.nupdateDAO(dto);
      return "redirect:/notice/1";
   }
   
   @GetMapping("/ndeleteBoard")
   public String deleteBoard(HttpServletRequest req,int communication_num, Model model) {
      communication_num=Integer.parseInt(req.getParameter("communication_num"));
      dao.ndeleteBoardDAO(communication_num);
      return "redirect:notice/1";
   }
}