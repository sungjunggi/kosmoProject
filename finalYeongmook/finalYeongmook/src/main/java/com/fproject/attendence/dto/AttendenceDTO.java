package com.fproject.attendence.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AttendenceDTO {
	private String attendNum;
	private String attendStart;
	private String attendEnd;
	private String empNum;
}
