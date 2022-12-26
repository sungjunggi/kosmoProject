package com.hrm.finalpj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.signDTO;
import com.hrm.finalpj.dto.vacationDTO;
import com.hrm.finalpj.report.dto.ReportDTO;


@Mapper
public interface IVacationMapper {
    
    public List<vacationDTO> vacationList(vacationDTO dto); 
    
    public signDTO SelectSignPage(int dto);
    
    public String numDAO(String name);
    
    public String resDAO(int res);
    
    public int vacationTotal();
    
    public int vacationWriteDAO(Map<String,Object> map);
   
}
