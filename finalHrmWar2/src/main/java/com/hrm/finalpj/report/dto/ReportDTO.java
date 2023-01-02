package com.hrm.finalpj.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportDTO {

	private int employee_num;
	private String employee_name;
	private String employee_email;
	
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
	private String template_board_sign_name;
	private String count;
	
	private int getcomment_num;
	
}
