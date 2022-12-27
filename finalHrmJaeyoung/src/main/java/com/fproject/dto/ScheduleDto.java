package com.fproject.dto;

import lombok.Data;

@Data
public class ScheduleDto {
	
	private int schedule_num;
	private String schedule_name;
	private String schedule_begin;
	private String schedule_end;
	private String schedule_rest;
	private String schedule_contents;
	private String schedule_writer;
	private int type_num;
	
	private String type_category;

	private int employee_num;
	private String employee_name;
	
	private String attendance_workstart;
}
