package com.hrm.finalpj.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {
	
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
}
