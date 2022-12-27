package com.hrm.finalpj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.finalpj.dao.INoticeDAO;
import com.hrm.finalpj.dao.ITodoDAO;
import com.hrm.finalpj.dto.CommunicationDTO;
import com.hrm.finalpj.dto.Criteria;


@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	INoticeDAO dao;
	
	public void write(HttpServletRequest req, int num) {
		String tit = req.getParameter("title");
		String con = req.getParameter("content");
		String today = req.getParameter("today");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", tit);
		map.put("content", con);
		map.put("today", today);
		map.put("num",num);
		dao.nwriteDAO(map);
	}
	
	public void ndelete(int communication_num) {
		dao.ndeleteBoardDAO(communication_num);
	}

	@Override
	public List<CommunicationDTO> ngetList(Criteria criteria) {
		
		return dao.ngetList(criteria);
	}

	@Override
	public Integer ngetTotal() {
		System.out.println();
		return dao.ngetTotal();
	}

	
	

	

	
	
}
