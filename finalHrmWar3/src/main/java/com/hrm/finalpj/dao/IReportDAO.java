package com.hrm.finalpj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.report.dto.TemplateDTO;

@Mapper
public interface IReportDAO {
	public List<ReportDTO> listDAO();  // 게시물 전체보기
	public ReportDTO viewDAO(String num);  // 게시물 보기
	public List<TemplateDTO> selectDAO();  // 템플릿 전체보기
	public TemplateDTO templateDAO(String tnum);  // 템플릿 보기
	public int addDAO(String num, String writer, String title);  // 템플릿 작성
	public int writeDAO(String answer1, String answer2, String answer3, int answer4);  // 게시글 작성
	public int updateDAO(ReportDTO dto);  // 게시글 수정
	public int deleteDAO(@Param("_id") String id); // 게시글 삭제
}
