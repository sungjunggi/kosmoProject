package com.hrm.finalpj.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.finalpj.dao.IReportDAO;
import com.hrm.finalpj.report.dto.PageDTO;
import com.hrm.finalpj.report.dto.CommentDTO;
import com.hrm.finalpj.report.dto.Criteria;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.service.ReportServiceImpl;

@Controller
public class ReportController {

   @Autowired
   IReportDAO dao; 
   
   @Autowired
   ReportServiceImpl reportservice;
   
   @GetMapping("/reportlist/{num}")
   public String reportList(@PathVariable("num") int num, Criteria criteria, Model model, HttpServletRequest req, Principal principal) {
      
      Criteria test = new Criteria(num, 20);
      
      String start = req.getParameter("start");
       String end = req.getParameter("end");
       
       test.setTemplate_board_start(start);
       test.setTemplate_board_end(end);
       
       String myReport = req.getParameter("myReport");
       String allReport = req.getParameter("allReport");
       
       int mynum = dao.numDAO(principal.getName());
       int myReportCount = dao.myReportCount(mynum);
       int allReportCount = dao.allReportCount();
	   int totalx = 0;
       
       req.setAttribute("myReportCount", myReportCount);
       req.setAttribute("allReportCount", allReportCount);
       
       int total = reportservice.getTotal();
       model.addAttribute("total", total);
       
       if(allReport != null) {
    //      model.addAttribute("list", reportservice.getList(test));
          model.addAttribute("list", dao.listDAO());
          model.addAttribute("pageMaker", new PageDTO(allReportCount, 15, test));
          return "report/reportmain";
          
       } else if(myReport != null) {
          mynum = dao.numDAO(principal.getName());
//          model.addAttribute("list", dao.listDAO());
          model.addAttribute("list", dao.myReportDAO(mynum));
          model.addAttribute("pageMaker", new PageDTO(myReportCount, 15, test));
          model.addAttribute("total", myReportCount);
          return "report/reportmain";
       }
       
       if(start != null && end != null) {
          List<Criteria> check = dao.searchDateDAO(test);
             if(check.get(0) == null ) {
                Criteria test1 = new Criteria(num,0);
                 model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 1, test1));
                 model.addAttribute("booleancheck",true);
                 return "report/reportmain";
             } else {
                model.addAttribute("list",dao.searchDateDAO(test));
                model.addAttribute("booleancheck",false);
				 model.addAttribute("pageMaker", new PageDTO(dao.dateCount(test), 15, test)); 
				 model.addAttribute("total", dao.dateCount(test));
                return "report/reportmain";
             }
       
       } else {
          model.addAttribute("list", reportservice.getList(test));
//          model.addAttribute("list", dao.listDAO());
			/* model.addAttribute("pageMaker", new PageDTO(30, 15, test)); */
          
        
       }
//       model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 10, test));
       
//       model.addAttribute("list", reportservice.getList(test));
      
       model.addAttribute("select", dao.selectDAO());
       model.addAttribute("pageMaker", new PageDTO(reportservice.getTotal(), 15, test));
       if(num%2 == 0) {
    	   totalx = total - num*10;
    	   model.addAttribute("total",totalx);
       }else if(num%3 == 0) {
    	   totalx = (total - num*10) - 10;
    	   model.addAttribute("total",totalx);  	   
       }
       
      return "report/reportmain";
    }
   
   @PostMapping("/reportwrite")
   public String reportWrite(Model model, HttpServletRequest req, Principal principal) {
      ReportDTO dto = new ReportDTO();
      
      int myNum = dao.numDAO(principal.getName());
      String getName = dao.getName(myNum);
      
      dto.setGettemplate_num(Integer.parseInt(req.getParameter("gettemplate_num")));
      dto.setTemplate_board_answer1(req.getParameter("answer1"));
      dto.setTemplate_board_sign_name(req.getParameter("sign"));
      dto.setTemplate_board_start(req.getParameter("start"));
      dto.setTemplate_board_end(req.getParameter("end"));
      dto.setTemplate_board_answer4(req.getParameter("answer4"));
      dto.setTemplate_board_answer5(req.getParameter("answer5"));
      dto.setTemplate_board_answer6(req.getParameter("answer6"));
      dto.setTemplate_board_answer7(req.getParameter("answer7"));
      dto.setEmployee_num(myNum);
      dto.setEmployee_name(getName);
      
      if(Integer.parseInt(req.getParameter("gettemplate_num")) == 1) {   
         dao.writeDAO1(dto);
      
      } else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 2) {
         dao.writeDAO2(dto);
   
      } else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 3) {
         dao.writeDAO3(dto);
      
      }
      
      return "redirect:reportlist/1";
   }
   
   @RequestMapping("/reportview/{num}")
   public String reportView(@PathVariable("num") String num, Model model, HttpSession session, HttpServletRequest req, Principal principal) {
      CommentDTO dto = new CommentDTO();
      
      dto.setTemplate_board_num(Integer.parseInt(num));
      model.addAttribute("view", dao.viewDAO(num));
      model.addAttribute("logincheck", false);
      
      int myNum = dao.numDAO(principal.getName());
      String getName = dao.getName(myNum);
      
      model.addAttribute("num", myNum);
      model.addAttribute("commentcheck", getName);
      
      if(myNum == 2 || dao.viewDAO(num).getEmployee_name().equals(getName)) {
         model.addAttribute("logincheck", true);
      }

      if(dao.commentReadDAO(num).get(0) != null) {
         model.addAttribute("commentRead", dao.commentReadDAO(num));
      }
      
      if(req.getParameter("content") != null) {
         dto.setGetcomment_content(req.getParameter("content"));
         dto.setGetcomment_writer(getName);
         dao.commentDAO(dto);
      
         model.addAttribute("commentRead", dao.commentReadDAO(num));
         model.addAttribute("view", dao.viewDAO(num));
         
         return "redirect:"+num;
      
      } else {
         model.addAttribute("view", dao.viewDAO(num));
      }
      
      return "report/reportview";
   }
   
   @RequestMapping("/templateselect")
   public String templateSelect(Model model) {
      model.addAttribute("select", dao.selectDAO());
      
      return "report/templateselect";
   }
   
   @RequestMapping("/templateview/{tnum}")
   public String templateView(@PathVariable("tnum") String tnum, Model model) {
      model.addAttribute("template", dao.templateDAO(tnum));
      
      return "report/reportwrite";
   }
   
   @PostMapping("/updatereport")
   public String updateReport(HttpServletRequest req) {
      ReportDTO dto = new ReportDTO();
      
      dto.setTemplate_board_num(Integer.parseInt(req.getParameter("template_board_num")));
      dto.setTemplate_board_answer1(req.getParameter("answer1")); 
      dto.setTemplate_board_sign_name(req.getParameter("sign")); 
      dto.setTemplate_board_start(req.getParameter("start"));
      dto.setTemplate_board_end(req.getParameter("end"));
      dto.setTemplate_board_answer4(req.getParameter("answer4")); 
      dto.setTemplate_board_answer5(req.getParameter("answer5")); 
      dto.setTemplate_board_answer6(req.getParameter("answer6")); 
      dto.setTemplate_board_answer7(req.getParameter("answer7"));
      
      if(Integer.parseInt(req.getParameter("gettemplate_num")) == 1) {
         dao.updateDAO1(dto);
      
      } else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 2) {
         dao.updateDAO2(dto);
      
      } else if(Integer.parseInt(req.getParameter("gettemplate_num")) == 3) {
         dao.updateDAO3(dto);
        
      }
       
      return "redirect:reportview/"+req.getParameter("template_board_num");
   }
   
   @GetMapping("/deletereport")
   public String deleteReport(HttpServletRequest req, int template_board_num, Model model) {
      template_board_num =Integer.parseInt(req.getParameter("template_board_num"));
      dao.deleteDAO(template_board_num);
      
      return "redirect:reportlist/1";
   }
   
   @GetMapping("/deletecomment")
   public String deleteComment(String gnum, HttpServletRequest req, Model model, Principal principal) {
      int getcomment_num = Integer.parseInt(req.getParameter("getcomment_num"));
      int template_board_num = Integer.parseInt(req.getParameter("template_board_num"));
      dao.commentDeleteDAO(getcomment_num);
      
      return "redirect:reportview/"+ template_board_num;
   }
   
}