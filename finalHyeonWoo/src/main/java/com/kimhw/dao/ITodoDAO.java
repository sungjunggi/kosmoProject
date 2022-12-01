package com.kimhw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimhw.dto.CommunicationDTO;


@Mapper
public interface ITodoDAO {
	
	public List<CommunicationDTO> listDAO(); 
	public CommunicationDTO viewDAO(String num);
	public int writeDAO(Map<String,String> map);
	public int deleteDAO(int communication_num);
	

}
