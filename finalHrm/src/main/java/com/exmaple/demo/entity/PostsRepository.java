package com.exmaple.demo.entity;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long>{

	//기본적 CROUD 메소드 자동 셍성 
	@Query("SELECT p from Posts p ORDER BY p.id DESC")
	List<Posts> findAllDesc();
	//조회용 프레임워크 사용

	List<Posts> findByTitleContaining(String title);
	//Containing을 붙이면 like 검색 
}
