package com.sample.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.sample.constant.Role;
import com.sample.dto.MemberFormDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
