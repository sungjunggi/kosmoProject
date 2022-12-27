package com.hrm.finalpj.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyHrmMapper {
    public Map<String, String> insertData();
}
