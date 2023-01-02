package com.hrm.finalpj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hrm.finalpj.report.dto.CommentDTO;
import com.hrm.finalpj.report.dto.Criteria;
import com.hrm.finalpj.report.dto.ReportDTO;
import com.hrm.finalpj.report.dto.TemplateDTO;

@Mapper
public interface IReportDAO {
   public List<ReportDTO> listDAO();  // 게시물 전체보기
   public ReportDTO viewDAO(String num);  // 게시물 보기
   public int numDAO(String name);  // EMPLOYEE_NAME 가져오기
   public List<Criteria> searchDateDAO(Criteria criteria); // 게시물 페이징
   public List<ReportDTO> getList(Criteria criteria); // 게시물 페이징
   public Integer getTotal(); // 게시물 페이징
   public List<TemplateDTO> selectDAO();  // 템플릿 고르기
   public ReportDTO templateDAO(String tnum);  // 템플릿 보기
   public int writeDAO1(ReportDTO map);  // 1번 템플릿 게시글 작성
   public int writeDAO2(ReportDTO map);  // 2번 템플릿 게시글 작성
   public int writeDAO3(ReportDTO map);  // 3번 템플릿 게시글 작성
   public int updateDAO1(ReportDTO dto);  // 1번 템플릿 게시글 수정
   public int updateDAO2(ReportDTO dto);  // 2번 템플릿 게시글 수정
   public int updateDAO3(ReportDTO dto);  // 3번 템플릿 게시글 수정
   public int deleteDAO(int template_board_num); // 게시글 삭제
   public int commentDAO(CommentDTO dto);  // 게시글 댓글 작성
   public CommentDTO boardDAO(String num);  // 게시글 댓글 보기
   public int commentDeleteDAO(int gnum); // 게시글 댓글 삭제
   public List<ReportDTO> commentReadDAO(String num);  // 게시글 댓글 가져오기
   public int allReportCount();  // 전체 보고서 개수 세기
   public int myReportCount(int num);  // 내 보고서 개수 세기
   public List<ReportDTO> myReportDAO(int num);  // 내 보고서 보기
   public int dateCount(Criteria criteria );
   public String getName(int myNum); // 회원 이름 가져오기
}