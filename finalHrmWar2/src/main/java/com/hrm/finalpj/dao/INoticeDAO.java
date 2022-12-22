package com.hrm.finalpj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


@Mapper
public interface INoticeDAO {
   
   public CommunicationDTO nviewDAO(String num);
   public int nwriteDAO(Map<String,Object> map);
   public int ndeleteDAO(int communication_num);
   public void nupdateDAO(CommunicationDTO dto);
   public void ndeleteBoardDAO(int communication_num);
   public List<CommunicationDTO> ngetList(Criteria criteria);
   public List<CommunicationDTO> nsearchTextDAO(Criteria dto);
   public List<Criteria> nsearchDateDAO(Criteria criteria);
   public List<CommunicationDTO> nsearchAllDAO(Criteria dto);
   public int nnumDAO(String name);
   public Integer ngetTotal();
   
}

