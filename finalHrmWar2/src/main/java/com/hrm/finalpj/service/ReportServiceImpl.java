package com.hrm.finalpj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.finalpj.dao.IReportDAO;
import com.hrm.finalpj.report.dto.Criteria;
import com.hrm.finalpj.report.dto.ReportDTO;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	IReportDAO dao; 
	
	public void write(HttpServletRequest req, int num) {
		String tnum = req.getParameter("gettemplate_num");
		String ans1 = req.getParameter("answer1");
		String sign = req.getParameter("sign");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		String ans4 = req.getParameter("answer4");
		String ans5 = req.getParameter("answer5");
		String ans6 = req.getParameter("answer6");
		String ans7 = req.getParameter("answer7");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gettemplate_num", tnum);
		map.put("answer1", ans1);
		map.put("sign", sign);
		map.put("start", start);
		map.put("end", end);
		map.put("answer4", ans4);
		map.put("answer5", ans5);
		map.put("answer6", ans6);
		map.put("answer7", ans7);
		map.put("num", num);
		dao.writeDAO1(map);
		dao.writeDAO2(map);
		dao.writeDAO3(map);
	}
	
	@Override
	public List<ReportDTO> getList(Criteria criteria) {
		
		return dao.getList(criteria);
	}

	@Override
	public Integer getTotal() {
		System.out.println();
		return dao.getTotal();
	}
}
