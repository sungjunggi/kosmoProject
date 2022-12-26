package com.hrm.finalpj.dto;

import com.hrm.finalpj.Entity.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {
	// 조회 클래스 엔티티의 일부만 사용하므로 생성자로 entity받아 필드에 값 저장 
	private Long id;
	private String title;
	private String contents;
	private String author;
	
	public PostsResponseDto(Posts posts) {
		this.id = posts.getId();
		this.title = posts.getTitle();
		this.contents = posts.getContents();
		this.author = posts.getAuthor();
	}
}
