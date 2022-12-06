package com.hrm.finalpj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class HrmEmployeeDTO {
   private int EMPLOYEE_NUM;
   private String EMPLOYEE_ID;
   private String EMPLOYEE_PASSWORD;
   private String EMPLOYEE_NAME;
   private String  EMPLOYEE_PHON;
   private String EMPLOYEE_ADDRESS;
   private String EMPLOYEE_TYPE;
   private String EMPLOYEE_DATE;
   private String EMPLOYEE_QUITDATE;
   private int DEPARTMENT_NUM;
   private String EMPLOYEE_GENDER;
   private String GETROLE_NUM;

   
	private int userNo; //회원 pk
	private String id; //회원 아이디
	private String password;// 비밀번호
	private String name; // 회원 이름
	
	private String roleName; //권한 이름
   
   
}