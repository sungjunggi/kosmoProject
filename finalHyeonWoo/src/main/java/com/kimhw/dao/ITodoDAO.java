package com.kimhw.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.kimhw.dto.CommunicationDTO;
import com.kimhw.dto.Criteria;
import com.kimhw.dto.PageDTO;
import org.springframework.stereotype.Repository;


@Mapper
public interface ITodoDAO {
	
	public List<CommunicationDTO> listDAO(); 
	public CommunicationDTO viewDAO(String num);
	public int writeDAO(Map<String,String> map);
	public int deleteDAO(int communication_num);
	public void updateDAO(CommunicationDTO dto);
	public void deleteBoardDAO(int communication_num);
	public List<CommunicationDTO> getList(Criteria criteria);
	public Integer getTotal();

}
