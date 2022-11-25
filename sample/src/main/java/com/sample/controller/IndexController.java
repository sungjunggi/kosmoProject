package com.sample.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.Entity.Member;
import com.sample.dto.MemberFormDto;
import com.sample.dto.PostsListResponseDto;
import com.sample.dto.PostsResponseDto;
import com.sample.service.MemberService;
import com.sample.service.PostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	public final PostsService postsService;
	private final MemberService memberService;
	
	@GetMapping("/posts/save")
	public String postsSave(Model model, Principal principal) {
		model.addAttribute("name",principal.getName());
		return "posts-save";
	}
	//저장 
	
	@GetMapping("/posts/update/{id}")	
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("posts", dto);
		return "posts-update";
	}
	//수정
	
	@GetMapping("/posts/info/{id}")
	public String postsInfo(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("posts",dto);
		return "posts-info";
	}
	//조회
	
	@GetMapping("/posts/search")
	public String search(@RequestParam(value="searchQuery") String keyword, Model model) {
	    List<PostsListResponseDto> dto = postsService.findByKeyword(keyword);
	    model.addAttribute("posts", dto);
	    return "index";
	}
	//검색
	
}
