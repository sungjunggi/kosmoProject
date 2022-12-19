package com.hrm.finalpj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


@Mapper
public interface ITodoDAO {
   
   public List<CommunicationDTO> listDAO(); 
   public CommunicationDTO viewDAO(String num);
   public int writeDAO(Map<String,Object> map);
   public int deleteDAO(int communication_num);
   public void updateDAO(CommunicationDTO dto);
   public void deleteBoardDAO(int communication_num);
   public List<CommunicationDTO> getList(Criteria criteria);
   public Integer getTotal();
   public List<CommunicationDTO> searchTextDAO(Criteria dto);
   public List<Criteria> searchDateDAO(Criteria criteria);
   public List<CommunicationDTO> searchAllDAO(Criteria dto);
   public int numDAO(String name);
   public int scheduledTotalDAO();
   public int proceedingTotalDAO();
   public int finishTotalDAO();
   public List<CommunicationDTO> myTodoDAO(int num);
   public List<CommunicationDTO> clickScheduledDAO(Criteria criteria,String clickScheduled);
   public List<CommunicationDTO> clickProceedingDAO(Criteria criteria,String clickProceeding);
   public List<CommunicationDTO> clickFinishDAO(Criteria criteria,String clickFinish);
   

}

