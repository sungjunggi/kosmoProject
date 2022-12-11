package com.exmaple.demo.config.dto;

import java.io.Serializable;

import com.exmaple.demo.entity.Member;

import lombok.Getter;

@Getter
public class SessionMember implements Serializable{
	private String name;
	private String email;
	private String address;
//	private String password;
	
		public SessionMember(Member member) {
			this.name = member.getName();
			this.email = member.getEmail();
			this.address = member.getAddress();
//			this.password = member.getPassword();
			
	}
}
