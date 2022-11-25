package com.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;
import org.springframework.stereotype.Service;

import com.sample.Entity.Posts;
import com.sample.Entity.PostsRepository;
import com.sample.dto.PostsListResponseDto;
import com.sample.dto.PostsResponseDto;
import com.sample.dto.PostsSaveRequestDto;
import com.sample.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	// DB에 데이터를 저장하기 위한 인터페이스 변수
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		// 클래스 또는 메소드에 트랜잭션 시작, commit 또는 rollback 수행
		return postsRepository.save(requestDto.toPosts()).getId();
		//saverequestDto 의 toPosts()메소드 통해 insert 또는 update 쿼리 실행 id 리턴
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		//update 메소드 추가 
		// 사용자가 입력한 id 정보를 이용하여 데이터베이스 겁색 
		// 결과에 따라 posts 클래스의 update 메소드 실행 
		Posts posts = postsRepository.findById(id)
					.orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		posts.update(requestDto.getTitle(), requestDto.getContents());
		return id;
	}
	
	public PostsResponseDto findById(Long id) {
		// 사용자가 입력한 id 정보 이요하여 데이터베이스 검색
		// 검색 결과가 있으면 PostsResponseDto 객체 반환 
		Posts posts = postsRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 업습니다. id="+ id));
		return new PostsResponseDto(posts);
	}
	
	@Transactional
	public List<PostsListResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().stream()
				.map(posts -> new PostsListResponseDto(posts))
				.collect(Collectors.toList());
		// postsRepository 결과로 넘어온 posts의 스트림을 map을 통해 postsListResponseDto 변환 > list로 반환하는 코드
	}
	
	@Transactional
	public void delete(Long id) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		postsRepository.delete(posts);
	}
	
	@Transactional
	public List<PostsListResponseDto> findByKeyword(String title){
		//사용자가 검색창에 입력한 값 제목 검색
		return  postsRepository.findByTitleContaining(title).stream()
				.map(posts -> new PostsListResponseDto(posts))
				.collect(Collectors.toList());
	}

}
