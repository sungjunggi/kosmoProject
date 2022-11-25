package com.sample.Entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long>{
	
	@Query("SELECT p from Posts p ORDER BY p.id DESC")
	List<Posts> findAllDesc();
	
	List<Posts> findByTitelContaining(String title);

}
