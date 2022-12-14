package com.fproject.attendence.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendencePercentageDAO {
	
	public String countTodayAttend();	//금일 출근한 사원 수
	public String countTodayTotalAtt();	//금일 스케줄 상 출근자 총 수
	public String countTardyAttend();	//금일 지각한 사원 수
	public String countLeaveEarly();	//금일 조퇴한 사원 수
}
