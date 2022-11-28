package com.project.dto;

import lombok.Data;

@Data
public class ReportDTO {

	private int bookmark_num;
	private String bookmark_id;
	
	private int category_num;
	private String category_title;
	
	private int comment_num;
	private String comment_content;
	private String comment_date;
	private String comment_image;

}
