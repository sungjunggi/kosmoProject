package com.fproject.attendence.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendenceDAO {
	public String workStart(String empno); //출근시간 체크
	public String workEnd(String empno); //퇴근시간 체크	
}
