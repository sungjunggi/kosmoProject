package com.kimhw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.kimhw.dto.CommunicationDTO;

@Mapper
public interface TodoDAO {
	public List<CommunicationDTO> listDAO();//게시물 전체보기
	public CommunicationDTO viewDAO(String id);//게시물 보기
	public int writeDAO(Map<String,String> map);//게시물 작성
	public int deleteDAO(@Param("_id") String id);//게시물 삭제
	public int postCount(); //전체 게시물 수

}
