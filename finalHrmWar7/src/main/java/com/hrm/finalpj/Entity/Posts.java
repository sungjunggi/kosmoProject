package com.hrm.finalpj.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="SEQ_POSTS_NUM", //시퀀스 제너레이터 이름
        sequenceName="SEQ_POSTS", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POSTS_NUM")
	private long id;
	
	@Column(length=500, nullable=false)
	private String title;
	
	@Column(length=2000, nullable =false)
	private String contents;
	
	private String author;
	
	@Builder
	public Posts(String title, String contents, String author) {
		this.title = title;
		this.contents = contents;
		this.author = author;
		
	}
	
	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
}
