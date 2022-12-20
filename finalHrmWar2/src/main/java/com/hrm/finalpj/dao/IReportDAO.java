package com.hrm.finalpj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hrm.finalpj.report.dto.Criteria;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.report.dto.TemplateDTO;

@Mapper
public interface IReportDAO {
	public List<ReportDTO> listDAO();  // 게시물 전체보기
	public List<Criteria> searchDateDAO(Criteria criteria); // 게시물 페이징
	public List<ReportDTO> getList(Criteria criteria);  // 게시물 페이징
	public Integer getTotal();  // 게시물 페이징
	public ReportDTO viewDAO(String num);  // 게시물 보기
	public List<TemplateDTO> selectDAO();  // 템플릿 전체보기
	public ReportDTO templateDAO(String tnum);  // 템플릿 보기
	public int writeDAO1(ReportDTO dto);  // 1번 템플릿 게시글 작성
	public int writeDAO2(ReportDTO dto);  // 2번 템플릿 게시글 작성
	public int writeDAO3(ReportDTO dto);  // 3번 템플릿 게시글 작성
	public int updateDAO(ReportDTO dto);  // 게시글 수정
	public int deleteDAO(@Param("_id") String id); // 게시글 삭제
}
