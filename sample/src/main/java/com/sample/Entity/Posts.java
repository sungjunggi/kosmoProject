package com.sample.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
