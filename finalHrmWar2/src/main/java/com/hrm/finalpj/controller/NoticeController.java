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
import com.hrm.finalpj.dao.ITodoDAO;
import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;
import com.hrm.finalpj.dto.PageDTO;
import com.hrm.finalpj.service.NoticeServiceImpl;
import com.hrm.finalpj.service.TodoServiceImpl;

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
       
       int myNum = dao.nnumDAO(principal.getName());
       
       if(search !=null && start=="" && end=="") {
    	   System.out.println("검색만");
          model.addAttribute("list",dao.nsearchTextDAO(test));
       }else if(search == "" && start!=null && end!=null) {
           List<Criteria> check = dao.nsearchDateDAO(test);
           System.out.println(check.get(0) + "커뮤넘");
	          if(check.get(0) == null ) {
	        	  Criteria test1 = new Criteria(num,0);
	        	  model.addAttribute("pageMaker", new PageDTO(nservice.getTotal(), 1, test1));
	             model.addAttribute("booleancheck",true);
	             return "TodoMain";
	          }else {
	          model.addAttribute("list",dao.nsearchDateDAO(test));
          model.addAttribute("booleancheck",false);
          }
       }else if(search != null && start!=null && end!=null) {
          model.addAttribute("list",dao.nsearchAllDAO(test));
       }else {
          model.addAttribute("list", nservice.getList(test));
       }
       model.addAttribute("pageMaker", new PageDTO(nservice.getTotal(), 10, test));
       return "noticeMain";
    }
   
   @GetMapping("/nwrite")
   public String writeForm() {
      return "nwriteForm";
   }
   
   @PostMapping("/nwriting")
   public String write(HttpServletRequest req, Model model, Principal principal) {
      model.addAttribute("enum",principal.getName());
      int num = dao.nnumDAO(principal.getName());
	   nservice.write(req,num);
      return "redirect:notice/1"; 
   }
   
   @GetMapping("/nview/{num}")
   public String detailView(@PathVariable("num") String num,HttpServletRequest req, Model model) {
      model.addAttribute("dto",dao.nviewDAO(num));
      return "nviewForm";
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
      return "neditForm";
   }
   
   @PostMapping("/nedit/{num}")
   public String edit(@PathVariable("num") String num, CommunicationDTO dto,HttpServletRequest req) {
      dto.setCommunication_title(req.getParameter("title"));
      dto.setCommunication_start(req.getParameter("start"));
      dto.setCommunication_end(req.getParameter("end"));
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