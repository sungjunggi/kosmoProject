package com.hrm.finalpj.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	private int getcomment_num;
	private String getcomment_content;
	private String getcomment_date;
	private String getcomment_writer;
	private int template_board_num;
	private int employee_num;
}
