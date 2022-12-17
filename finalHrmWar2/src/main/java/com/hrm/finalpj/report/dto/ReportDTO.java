package com.hrm.finalpj.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportDTO {

	private int employee_num;
	private String employee_name;
	private int gettemplate_num;
	private String gettemplate_title;
	private int getfile_num;
	private String getfile_old_name;
	private int template_board_num;
	private String template_board_date;
	private String gettemplate_image;
	private String template_board_answer1;
	private String template_board_answer2;
	private String template_board_answer3;
	private String template_board_answer4;
	private String template_board_answer5;
	private String template_board_answer6;
	private String template_board_answer7;
	private String getcomment_content;
	private String count;
	private String template_board_sign_status;
	private String template_board_sign_name;
}
