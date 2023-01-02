package com.hrm.finalpj.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class vacationDTO {
	private Integer dayoff_num;
    private Integer type_num;
    private String dayoff_begin;
    private String dayoff_end;
    private Integer dayoff_count;
    private String dayoff_reason;
    private String dayoff_status;
    private String dayoff_approver;
    private String employee_num;
    private String type_category;
    private String dayoff_date;
	
}

