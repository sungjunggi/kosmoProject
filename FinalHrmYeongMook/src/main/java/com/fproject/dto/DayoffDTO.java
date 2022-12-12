package com.fproject.dto;

import lombok.Data;

@Data
public class DayoffDTO {
	private int dayoff_num;
	private int type_num;
	private String dayoff_begin;
	private String dayoff_end;
	private int dayoff_count;
	private String dayoff_reason;
	private int dayoff_status;
	private String dayoff_approver;
	private int employee_num;
}
