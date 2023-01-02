package com.hrm.finalpj.report.dto;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;


@Data
public class Criteria {
   private int pageNum;
   private int amount;
   private int num;
   private String type;
   private String keyword;
  
   private int employee_num;
   private String employee_name;
	
   private int gettemplate_num;
   private String gettemplate_title;
	
   private int template_board_num;
   private String template_board_date;
   private String template_board_sign_status;
   private String template_board_start;
   private String template_board_end;
   private String count;
   
   // 생성자로 무조건 실행된다 1번은
   // 기본 페이지를 1페이지에 10개씩 보여준다는 의미
   public Criteria() {
      this(1,20);
   }
   
   public Criteria(int num, int pageNum, int amount){
      this.num = num;
      this.pageNum=pageNum;
      this.amount=amount;
   };
   
   // 매개변수로 들어오는 값을 이용하여 조정할 수 있다.
   public Criteria(int pageNum, int amount) {
      this.pageNum=pageNum;
      this.amount=amount;
   }
   
   // UriComponentsBuilder를 이용하여 링크 생성
   public String getListLink() {
      UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
            .queryParam("pageNum", pageNum)
            .queryParam("amount", amount);
      return builder.toUriString();
   }
   
   public String[] getTypeArr() {// get으로 시작해야만 mybatis에서 찾을 수 있음.
      return type ==null? new String[] {} : type.split("");
   }
   
}