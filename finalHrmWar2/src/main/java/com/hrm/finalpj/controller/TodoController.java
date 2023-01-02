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

import com.hrm.finalpj.dao.ITodoDAO;
import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;
import com.hrm.finalpj.dto.PageDTO;
import com.hrm.finalpj.service.TodoServiceImpl;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class TodoController {
   
   @Autowired
   ITodoDAO dao;
   
   @Autowired
   TodoServiceImpl todoservice;
   

    @GetMapping("todo/{num}")
    public String todoMain(@PathVariable("num") int num,Criteria criteria, Model model,HttpServletRequest req,Principal principal) {
       Criteria test = new Criteria(num,20);
       String search = req.getParameter("searchText");
       String start = req.getParameter("start");
       String end = req.getParameter("end");
       String allTodo = req.getParameter("allTodo");
       String myTodo = req.getParameter("myTodo");
       test.setCommunication_search(search);
       test.setCommunication_start(start);
       test.setCommunication_end(end);
       String starting = req.getParameter("starting");
       String ending = req.getParameter("ending");
       
       Integer myNum = dao.numDAO(principal.getName());
       int scheduled = dao.scheduledTotalDAO();
       int proceeding = dao.proceedingTotalDAO();
       int finish = dao.finishTotalDAO();
       int allTodoCount = dao.allTodoCountDAO();
       Integer myTodoCount = dao.myTodoCountDAO(myNum);
       
       req.setAttribute("scheduled", scheduled);
       req.setAttribute("proceeding", proceeding);
       req.setAttribute("finish", finish);
       req.setAttribute("allTodoCount", allTodoCount);
       req.setAttribute("myTodoCount", myTodoCount);
       String clickScheduled = req.getParameter("scheduled");
       String clickProceeding = req.getParameter("proceeding");
       String clickFinish = req.getParameter("finish");
       if(starting != null) {
    	   int communication_num=Integer.parseInt(req.getParameter("communication_num"));
    	   dao.startingDAO(communication_num);
       }else if(ending != null) {
    	   int communication_num=Integer.parseInt(req.getParameter("communication_num"));
    	   dao.endingDAO(communication_num);
       }
       
       int total = todoservice.getTotal();
       model.addAttribute("total",total);
       if(clickScheduled != null) {
    	   System.out.println("진행예정");
    	   model.addAttribute("list",dao.clickScheduledDAO(test,clickScheduled));
    	   model.addAttribute("pageMaker", new PageDTO(dao.ScheduledDAO(clickScheduled), 10, test));
           return "TodoMain";
       }else if(clickProceeding != null) {
    	   System.out.println("진행중");
    	   model.addAttribute("list",dao.clickProceedingDAO(test,clickProceeding));
    	   model.addAttribute("pageMaker", new PageDTO(dao.ProceedingDAO(clickProceeding), 10, test));
           return "TodoMain";
       }else if(clickFinish != null) {
    	   System.out.println("진행완료");
    	   model.addAttribute("list",dao.clickFinishDAO(test,clickFinish));
    	   model.addAttribute("pageMaker", new PageDTO(dao.FinishDAO(clickFinish), 10, test));
           return "TodoMain";
       }
      if(allTodo != null ) {
    	  model.addAttribute("list", todoservice.getList(test));
      }else if(myTodo != null) {
          myNum = dao.numDAO(principal.getName());
    	  model.addAttribute("list",dao.myTodoDAO(test, myNum));
    	  model.addAttribute("pageMaker", new PageDTO(dao.myTodoDAO2(myNum), 10, test));
          return "TodoMain";
      }
      

       if(search !=null && start=="" && end=="") {
    	   System.out.println("검색만");
          model.addAttribute("list",dao.searchTextDAO(test));
       }else if(search == "" && start!=null && end!=null) {
           List<Criteria> check = dao.searchDateDAO(test);
           System.out.println(check.get(0) + "커뮤넘");
	          if(check.get(0) == null ) {
	        	  Criteria test1 = new Criteria(num,0);
	        	  model.addAttribute("pageMaker", new PageDTO(todoservice.getTotal(), 1, test1));
	             model.addAttribute("booleancheck",true);
	             return "TodoMain";
	          }else {
	          model.addAttribute("list",dao.searchDateDAO(test));
          model.addAttribute("booleancheck",false);
          }
       }else if(search != null && start!=null && end!=null) {
          model.addAttribute("list",dao.searchAllDAO(test));
       }else {
          model.addAttribute("list", todoservice.getList(test));
       }
       model.addAttribute("pageMaker", new PageDTO(todoservice.getTotal(), 10, test));
     
       return "TodoMain";
    }
   
   @GetMapping("/write")
   public String writeForm() {
      return "writeForm";
   }
   
   @PostMapping("/writing")
   public String write(HttpServletRequest req, Model model, Principal principal) {
      model.addAttribute("enum",principal.getName());
      int num = dao.numDAO(principal.getName());
	   todoservice.write(req,num);
      return "redirect:todo/1"; 
   }
   
   @GetMapping("/view/{num}")
   public String detailView(@PathVariable("num") String num,HttpServletRequest req, Model model) {
      model.addAttribute("dto",dao.viewDAO(num));
      return "viewForm";
   }
   
   @PostMapping("/delete")
   public String delete(Model model,HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
      String[] str=req.getParameterValues("deleteId");
      for(String s:str) {
         int communication_num= Integer.parseInt(s);
         dao.deleteDAO(communication_num);
      }
      return "redirect:todo/1";
   }
   
   @GetMapping("/edit/{num}")
   public String editForm(@PathVariable("num") String num,Model model) {
      model.addAttribute("dto",dao.viewDAO(num));
      return "editForm";
   }
   
   @PostMapping("/edit/{num}")
   public String edit(@PathVariable("num") String num, CommunicationDTO dto,HttpServletRequest req) {
      dto.setCommunication_title(req.getParameter("title"));
      dto.setCommunication_start(req.getParameter("start"));
      dto.setCommunication_end(req.getParameter("end"));
      dto.setCommunication_content(req.getParameter("content"));
      dao.updateDAO(dto);
      return "redirect:/todo/1";
   }
   
   @GetMapping("/deleteBoard")
   public String deleteBoard(HttpServletRequest req,int communication_num, Model model) {
      communication_num=Integer.parseInt(req.getParameter("communication_num"));
      dao.deleteBoardDAO(communication_num);
      return "redirect:todo/1";
   }
}