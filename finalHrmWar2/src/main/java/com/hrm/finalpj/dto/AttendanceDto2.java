package com.hrm.finalpj.dto;

import lombok.Data;

@Data
public class AttendanceDto2 {
	
	private int attendance_num;
	private String attendance_workstart;
	private String attendance_workend;
	
	private int calendar_num;
	private String calendar_date;
	
	private int department_num;
	private String department_name;
	private int position_num;
	
	private int employee_num;
	private String employee_phone;
	private String employee_type;
	private String employee_date;
	private String employee_quitdate;
	private String employee_picture;
	private String employee_gender;
	private int id;
	private String employee_name;
	private String employee_id;
	private String employee_password;
	private String employee_address;
	private String employee_email;
	
	private int job_num;
	private String job_name;
	
	private int schedule_num;
	private String schedule_name;
	private String schedule_begin;
	private String schedule_end;
	private String schedule_rest;
	private String schedule_contents;
	private String schedule_writer;
	
	private int type_num;
	private String type_category;
	
	private double average;
	private int workingCount;
	private int beforeWorkCount;
	private int notWorkCount;
	private int scheduleWorkCount;
	private int lateWorkCount;
	private int leftEarlierCount;
	private int businessTripCount;
	private int vacationCount;
	private int educationCount;
	private int etcCount;
	private int noScheduleCount;
	private int totalCount;
	
}
