package com.hrm.finalpj.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	// 수정 요청 클래스 
	private String title;
	private String contents;
	
	@Builder
	public PostsUpdateRequestDto(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
}
