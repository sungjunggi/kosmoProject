package com.hrm.finalpj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.report.dto.ReportDTO;


@Mapper
public interface IHrmMapper {

	//select * from employee
    public List<Map<String, Object>> SelectAllList() throws Exception;
    
    //select * from 
    
    public List<signDTO> SelectSignList(signDTO dto); 
    
    public List<signDTO> SelectSignList2(ReportDTO dto);
    
    public signDTO SelectSignPage(int dto);
    
    public void approveDAO(int sign_num); 
    
    public void denyDAO(int sign_num);
    
    public String numDAO(String name);
    
    public String resDAO(int res);
   
}
