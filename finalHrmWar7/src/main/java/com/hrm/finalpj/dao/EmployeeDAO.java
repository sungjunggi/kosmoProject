package com.hrm.finalpj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hrm.finalpj.dto.EmployeeDTO;


@Mapper
public interface EmployeeDAO {
	
	public List<EmployeeDTO> listDAO(); 
	public List<EmployeeDTO> listDname(String Dname); 
	public EmployeeDTO viewDAO(String num);
	public int writeDAO(Map<String,String> map);
	public int deleteDAO(int employee_num);
	public EmployeeDTO DepartSearch(String DepartID);
	public List<EmployeeDTO> listDAO2(); 
	public List<EmployeeDTO> listDAO3(); 
	
	
	public List<EmployeeDTO> deptCount(String Dname);
}
