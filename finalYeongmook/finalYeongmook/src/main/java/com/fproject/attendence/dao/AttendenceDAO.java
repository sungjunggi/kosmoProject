package com.fproject.attendence.dao;

import org.apache.ibatis.annotations.Mapper;

import jakarta.websocket.Session;

@Mapper
public interface AttendenceDAO {
	public String workStart(Session id); //출근시간 체크
	public String workEnd(Session id); //퇴근시간 체크	
}
