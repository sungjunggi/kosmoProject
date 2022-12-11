package com.hrm.finalpj.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hrm.finalpj.dto.HrmEmployeeDTO;


@Mapper
public interface IHrmMapper {

	//select * from employee
    public List<Map<String, Object>> SelectAllList() throws Exception;
    
    //유저 정보
  	HrmEmployeeDTO findByUserId(@Param("id") String id);
  	
  	//유저 정보
  	public String getUserId();

  	//유저 저장
  	int userSave(HrmEmployeeDTO userVO);

  	//유저 권한 저장
  	int userRoleSave(@Param("userNo") int userNo,@Param("roleNo") int roleNo);

  	//유저 FK번호 알아내기
  	int findUserNo(@Param("id") String id);

  	//권한 FK번호 알아내기
  	int findRoleNo(@Param("roleName") String roleName);
  	
}
