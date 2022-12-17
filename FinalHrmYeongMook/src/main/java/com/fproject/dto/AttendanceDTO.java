package com.fproject.dto;

import lombok.Data;

@Data
public class AttendanceDTO {
	private int attendance_num;
	private String attendance_start;
	private String attendance_end;
	private int employee_Num;
}
