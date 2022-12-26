package com.hrm.finalpj.service;

import java.util.List;

import com.hrm.finalpj.report.dto.Criteria;
import com.hrm.finalpj.report.dto.ReportDTO;

public interface ReportService {
	public List<ReportDTO> getList(Criteria criteria);  // 게시물 페이징
	public Integer getTotal();  // 게시물 페이징
}
