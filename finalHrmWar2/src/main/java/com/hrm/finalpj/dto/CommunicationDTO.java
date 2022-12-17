package com.hrm.finalpj.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunicationDTO {
	private int communication_num;
	private String communication_title;
	private String communication_date;
	private String communication_start;
	private String communication_end;
	private String communication_assign;
	private String communication_state;
	private String employee_name;
	private String communication_image;
	private String communication_content;
	private String category_title;
	private int file_num;
	private String bookmark_id;
	private int employee_num;
}
