package com.hrm.finalpj.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.signDTO;





@Mapper
public interface IHrmMapper {

	//select * from employee
    public List<Map<String, Object>> SelectAllList() throws Exception;
    
    public List<signDTO> SelectSignList(signDTO dto); 
    
    public signDTO SelectSignPage(int dto);
   
  	
}
