package com.fproject.dto;

import lombok.Data;

@Data
public class AttendanceDto {
	
	private int attendance_num;
	private String attendance_workstart;
	private String attendance_workend;
	private int employee_num;
	
}
