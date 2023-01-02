package com.hrm.finalpj.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class signDTO {
	
	private Integer sign_num;
    private String sign_req_title;
    private String sign_status;
    private String sign_begin;
    private String sign_end;
    private Integer employee_num;
    private String sign_res_name;
    private int type_num;
    private String sign_req_contents;
    private String sign_req_date;
    private String sign_first;
    private String sign_first_date;
    private String sign_first_status;
    private String sign_second;
    private String sign_second_date;
    private String sign_second_status;
    private String sign_third;
    private String sign_third_date;
    private String sign_third_status;
    private String employee_name;
    
    private int dayoff_num;
    private String dayoff_begin;
    private String dayoff_end;
    private int dayoff_count;
    private String dayoff_reason;
    private String dayoff_status;
	private String type_category;
	private String dayoff_approver;
	private String dayoff_date;
	

	
	private int gettemplate_num;
	private String gettemplate_title;
	private String gettemplate_image;
	private String gettemplate_date;
	private String gettemplate_writer;
	private String gettemplate_question1;
	private String gettemplate_question2;
	private String gettemplate_question3;
	private String gettemplate_question4;
	private String gettemplate_question5;
	private String gettemplate_question6;
	private String gettemplate_question7;
	
	private int getfile_num;
	private String getfile_old_name;
	
	private int template_board_num;
	private String template_board_date;
	private String template_board_answer1;
	private String template_board_answer2;
	private String template_board_answer3;
	private String template_board_answer4;
	private String template_board_answer5;
	private String template_board_answer6;
	private String template_board_answer7;
	private String template_board_sign_status;
	private String template_board_start;
	private String template_board_end;
	private String getcomment_content;
	private String template_board_sign_name;
	private String count;
    
}

