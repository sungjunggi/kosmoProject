package com.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateDTO {
	private int template_board_num;
	
	private int template_num;
	private String template_title;
	private String template_question;
	private String template_explanation;
	private String template_option;
	private String template_image;
	private String template_date;
}
