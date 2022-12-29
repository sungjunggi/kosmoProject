package com.hrm.finalpj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.hrm.finalpj.dto.ScheduleDTO;

@Mapper
public interface IScheduleMapper {
	public List<ScheduleDTO> UserList() ;
}