package com.kimhw.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;


@Data
public class Criteria {
	private int pageNum;
	private int amount;
	private String type;
	private String keyword;
	
	//생성자로 무조건 실행된다 1번은
	//기본 페이지를 1페이지에 10개씩 보여준다는 의미
	public Criteria() {this(1,10);}
	
	//매개변수로 들어오는 값을 이용하여 조정할 수 있다.
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	//UriComponentsBuilder를 이용하여 링크 생성
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("amount", amount);
		return builder.toUriString();
	}
	
	public String[] getTypeArr() {//get으로 시작해야만 mybatis에서 찾을 수 있음.
		return type ==null? new String[] {} : type.split("");
	}
}
