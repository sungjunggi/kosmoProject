package com.hrm.finalpj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface IHrmMapper {

	//select * from Test_Table
    public List<Map<String, Object>> SelectAllList() throws Exception;
}
