package com.fproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fproject.dto.ScheduleDto;

@Mapper
public interface IScheduleDao {

	public List<ScheduleDto> totalSch();

}
