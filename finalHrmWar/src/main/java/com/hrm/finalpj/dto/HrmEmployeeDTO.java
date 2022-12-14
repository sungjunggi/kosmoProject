package com.hrm.finalpj.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.hrm.finalpj.constant.Role;

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
   private String EMPLOYEE_ROLE;

   
	private int userNo; //회원 pk
	private String id; //회원 아이디
//	private String password;// 비밀번호
//	private String name; // 회원 이름
	
	private String roleName; //권한 이름
	
	@NotBlank(message = "이름을 입력해주세요.")
	private String name;
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String email;
	
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	@Length(min = 8, max=16, message="비밀번호는 8자이상, 16자 이하로 입력해주세요")
	private String password;
	
	@NotEmpty(message = "주소를 입력해주세요.")
	private String address;
   
	private Role role;
   
}