package com.hrm.finalpj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.AttendanceDto2;

@Mapper
public interface IAttendanceDao2 {
	
	public List<AttendanceDto2> defaultList();
	public List<AttendanceDto2> beforeWork();

	public int todayWorkCount();
	public int scheduleWorkCount();
	public int beforeWorkCount();
	public int notWorkCount();
	public int lateWorkCount();
	public int leftEarlierCount();
	public int businessTripCount();
	public int vacationCount();
	public int educationCount();
	public int etcCount();
	public int noScheduleCount();
	public int defaultCount();
}
