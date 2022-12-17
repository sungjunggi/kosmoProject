package com.fproject.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private int employee_num;
	private String employee_id;
	private String employee_password;
	private String employee_gender;
	private String employee_name;
	private int employee_phon;
	private String employee_address;
	private String employee_date;
	private String employee_quitdate;
	private String employee_picture;
	private int department_num;
}
