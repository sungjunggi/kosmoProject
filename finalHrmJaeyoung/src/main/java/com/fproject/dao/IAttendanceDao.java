package com.fproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fproject.dto.AttendanceDto;

@Mapper
public interface IAttendanceDao{
	
	public List<AttendanceDto> totalAtt();

}
