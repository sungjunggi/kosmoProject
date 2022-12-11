package com.hrm.finalpj.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.hrm.finalpj.constant.Role;
import com.hrm.finalpj.dto.MemberFormDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name="SEQ_MEMBER_NUM2", //시퀀스 제너레이터 이름
        sequenceName="SEQ_MEMBER", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_NUM2")
	private Long Id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Builder
	public Member(String name, String email, String address,String password, Role role){
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setAddress(memberFormDto.getAddress());
		String pw = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(pw);
		member.setRole(Role.ADMIN);
		return member;
	}
	
	public Member update(String name, String password, String address, PasswordEncoder passwordEncoder) {
		this.name = name;
		String pw = passwordEncoder.encode(password);
		this.password = pw;
		this.address = address;
		return this;
		
	}
	
}
