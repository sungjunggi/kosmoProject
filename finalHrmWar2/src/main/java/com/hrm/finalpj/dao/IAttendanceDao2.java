package com.hrm.finalpj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.AttendanceDto2;

@Mapper
public interface IAttendanceDao2 {
	
	public List<AttendanceDto2> totalAtt();
	public List<AttendanceDto2> attRate1();
	public List<AttendanceDto2> attRate2();
}
