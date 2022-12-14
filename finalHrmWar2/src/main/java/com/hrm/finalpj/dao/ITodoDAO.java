package com.hrm.finalpj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


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
   public List<CommunicationDTO> searchTextDAO(Criteria dto);
   public List<Criteria> searchDateDAO(Criteria criteria);
   public List<CommunicationDTO> searchAllDAO(Criteria dto);

}