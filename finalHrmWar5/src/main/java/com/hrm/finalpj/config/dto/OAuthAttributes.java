package com.hrm.finalpj.config.dto;

import java.util.Map;

import com.hrm.finalpj.Entity.Member;
import com.hrm.finalpj.constant.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String address;
	
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, 
											String name, String email, String address) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return ofGoogle(userNameAttributeName, attributes);
		
	}
	
	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String , Object> response = (Map<String, Object>) attributes.get("response");
		
		return OAuthAttributes.builder()
				.name((String) response.get("name"))
				.email((String) response.get("email"))
				.attributes(response)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }
}
