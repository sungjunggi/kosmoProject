package com.hrm.finalpj.dto;

import com.hrm.finalpj.Entity.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
	// 상단 어노테이션 객체 생성을 위한 생성자 메소드
	private String title;
	private String contents;
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String contents, String author) {
		// posts 클래스를 이용 데이터베이스에 저장할 객체 생성하기 위한 toEntity 메소드 구현 
		this.title = title;
		this.contents = contents;
		this.author = author;
	}
	
	public Posts toPosts() {
		return Posts.builder()
				.title(title)
				.contents(contents)
				.author(author)
				.build();
	}
	// Entity인 posts 클래스가 있어도 dto 클래스 추가 생성
	// entity 클래스를 request, response 클래스로 사용해선 안된다. entity 클래스는 DB와 밀접한 핵심 클래스
	// view layer와 db layer 역할 분리 
	
}
