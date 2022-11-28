package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.dto.ReportDTO;

@Mapper
public interface IReportDAO {
	public List<ReportDTO> listDAO();  // 게시물 전체보기
	public ReportDTO viewDAO(String id);  // 게시물 보기
	public int writeDAO(String writer, String title, String content);  // 게시물 작성
	public int deleteDAO(@Param("_id") String id); // 게시물 삭제
}
