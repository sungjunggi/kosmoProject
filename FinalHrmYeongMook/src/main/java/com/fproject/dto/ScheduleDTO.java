package com.fproject.dto;

import lombok.Data;

@Data
public class ScheduleDTO {
	private int schedule_num;
	private String schedule_name;
	private String schedule_begin;
	private String schedule_end;
	private String schedule_rest;
	private String schedule_contents;
	private String schedul_writer;
	private int type_num;
}
