package com.hrm.finalpj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.AttendanceDto2;

@Mapper
public interface IAttendanceDao2 {
	
	public List<AttendanceDto2> working();
	public List<AttendanceDto2> beforeWork();
	public List<AttendanceDto2> notWork();
	public List<AttendanceDto2> scheduleWork();
	public List<AttendanceDto2> lateWork();
	public List<AttendanceDto2> leftEarlier();
	public List<AttendanceDto2> businessTrip();
	public List<AttendanceDto2> vacation();
	public List<AttendanceDto2> education();
	public List<AttendanceDto2> etc();
	public List<AttendanceDto2> noSchedule();	
	public List<AttendanceDto2> total();
	
	public int workingCount();
	public int beforeWorkCount();
	public int notWorkCount();
	public int scheduleWorkCount();
	public int lateWorkCount();
	public int leftEarlierCount();
	public int businessTripCount();
	public int vacationCount();
	public int educationCount();
	public int etcCount();
	public int noScheduleCount();
	public int totalCount();
	
	public int atten(int num);
	public int exist(int num);
	public String check(int num);
	public int getNum(String name);
}
